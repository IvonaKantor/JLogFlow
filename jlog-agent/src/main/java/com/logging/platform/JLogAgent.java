package com.logging.platform;

import com.logging.platform.handler.LogFileHandler;
import com.logging.platform.processor.KafkaLogProcessor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Properties;

import static com.logging.platform.util.JLogEnvironment.JLOG_FILE_PATH;
import static com.logging.platform.util.JLogEnvironment.JLOG_KAFKA_SERVER;
import static com.logging.platform.util.JLogEnvironment.JLOG_KAFKA_TOPIC;
import static java.util.Objects.nonNull;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

public class JLogAgent {

    private static final Logger log = LoggerFactory.getLogger(JLogAgent.class);

    public static void main(String[] args) {
        final var path = System.getenv(JLOG_FILE_PATH);
        final var kafka = System.getenv(JLOG_KAFKA_SERVER);
        final var topic = System.getenv(JLOG_KAFKA_TOPIC);

        final var logFilePath = nonNull(path) && !path.isEmpty() ? path : System.getProperty("java.io.tmpdir") + "app.log";
        final var kafkaServer = nonNull(kafka) && !kafka.isEmpty() ? kafka : "localhost:9092";
        final var kafkaTopic = nonNull(topic) && !topic.isEmpty() ? topic : "logs";

        final var props = new Properties();

        props.put(BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, "1");
        props.put(ProducerConfig.RETRIES_CONFIG, 3);

        final var producer = new KafkaProducer<String, String>(props);
        final File logFile;

        try {
            logFile = new File(logFilePath);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        try (final var processor = new KafkaLogProcessor(producer, kafkaTopic)) {

            final var tailer = new LogFileHandler(logFile, processor);
            final var tailerThread = new Thread(tailer);

            tailerThread.start();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                log.info("Shutdown...");
                tailer.stopTailing();

                try {
                    tailerThread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }));

            tailerThread.join();

        } catch (Exception e) {
            log.error("Error run app [{}]", e.getMessage());
        }
    }
}