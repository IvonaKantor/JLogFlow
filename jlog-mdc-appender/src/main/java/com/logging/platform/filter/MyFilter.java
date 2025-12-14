package com.logging.platform.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class MyFilter extends Filter {
    @Override
    public FilterReply decide(Object iLoggingEvent) {
        return null;
    }
}
