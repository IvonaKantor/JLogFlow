package com.logging.platform.processor;

import com.logging.platform.intrface.LogProcessor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record KafkaLogProcessor(
        KafkaProducer<String, String> producer,
        String topic
) implements LogProcessor, AutoCloseable {

    private static final Logger log = LoggerFactory.getLogger(KafkaLogProcessor.class);

    @Override
    public void process(String logLine) {
        if (logLine != null && !logLine.trim().isEmpty()) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, null, logLine);

            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    log.error("Error send to Kafka: {}", exception.getMessage());
                }
            });
        }
    }

    @Override
    public void close() {
        producer.close();
    }
}