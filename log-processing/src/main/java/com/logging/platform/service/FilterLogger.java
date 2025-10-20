package com.logging.platform.service;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilterLogger extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getMessage().contains("sensitive_data")) {
            return FilterReply.DENY;
        }
        if (event.getLoggerName().startsWith("org.acme.noisy")) {
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }
}
