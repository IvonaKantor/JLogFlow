package com.logging.platform.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class MetadataAppender extends AppenderBase<ILoggingEvent> {

    @Override
    protected void append(ILoggingEvent event) {
        String serviceName = event.getMDCPropertyMap().get("serviceName");

        String formattedMessage = String.format("[service: %s] %s",
                serviceName,
                event.getFormattedMessage());

        System.out.println(formattedMessage);
    }
}