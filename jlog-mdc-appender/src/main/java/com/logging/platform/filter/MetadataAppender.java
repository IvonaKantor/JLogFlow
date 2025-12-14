package com.logging.platform.filter;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class MetadataAppender extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getLevel() == Level.ERROR) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.NEUTRAL;
        }
    }
}
