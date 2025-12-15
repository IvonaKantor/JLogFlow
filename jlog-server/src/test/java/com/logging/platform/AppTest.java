package com.logging.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logging.platform.models.LogData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void appTest() {

        String errorJson = """
                {
                  "timestamp": "2025-12-14T23:01:04.3058485+01:00",
                  "sequence": 2093,
                  "loggerClassName": "org.slf4j.impl.Slf4jLogger",
                  "loggerName": "com.logging.platform.LogGenerator",
                  "level": "ERROR",
                  "message": "test exception",
                  "threadName": "pool-8-thread-1",
                  "threadId": 56,
                  "mdc": {},
                  "ndc": "",
                  "hostName": "hp-840-g5",
                  "processName": "C:\\\\Users\\\\iwona\\\\.jdks\\\\temurin-17.0.16\\\\bin\\\\java.exe",
                  "processId": 2816,
                  "exception": {
                    "refId": 1,
                    "exceptionType": "java.lang.RuntimeException",
                    "message": "test exception",
                    "frames": [
                      {
                        "class": "com.logging.platform.LogGenerator",
                        "method": "lambda$startGenerating$0",
                        "line": 41
                      },
                      {
                        "class": "java.util.concurrent.Executors$RunnableAdapter",
                        "method": "call",
                        "line": 539
                      },
                      {
                        "class": "java.util.concurrent.FutureTask",
                        "method": "runAndReset",
                        "line": 305
                      },
                      {
                        "class": "java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask",
                        "method": "run",
                        "line": 305
                      },
                      {
                        "class": "java.util.concurrent.ThreadPoolExecutor",
                        "method": "runWorker",
                        "line": 1136
                      },
                      {
                        "class": "java.util.concurrent.ThreadPoolExecutor$Worker",
                        "method": "run",
                        "line": 635
                      },
                      {
                        "class": "java.lang.Thread",
                        "method": "run",
                        "line": 840
                      }
                    ]
                  },
                  "serviceName": "service-1",
                  "serviceId": "app-7865"
                }
                """;
        final var objectMapper = new ObjectMapper();

        Assertions.assertDoesNotThrow(() -> objectMapper.readValue(errorJson, LogData.class));

    }
}
