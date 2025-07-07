package org.jlog.flow.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilterLogger extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getMessage().contains("sensitive_data")) {
            return FilterReply.DENY; // Deny logging events containing "sensitive_data"
        }
        if (event.getLoggerName().startsWith("org.acme.noisy")) {
            return FilterReply.DENY; // Deny logs from a specific noisy package
        }
        return FilterReply.NEUTRAL; // Let other filters or the appender decide
    }
}
