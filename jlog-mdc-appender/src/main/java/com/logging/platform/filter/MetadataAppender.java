package com.logging.platform.filter;


import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class MetadataAppender extends Filter {

    @Override
    public FilterReply decide(Object o) {
        return null;
    }
}
