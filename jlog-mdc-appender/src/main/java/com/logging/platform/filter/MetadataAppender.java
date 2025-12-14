package com.logging.platform.filter;

import io.quarkus.logging.LoggingFilter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

@LoggingFilter(name="filter")
public class MetadataAppender implements Filter {

    private final String part;

    public MetadataAppender(@ConfigProperty(name = "filter.part") String part) {
        this.part = part;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return !record.getMessage().contains(part);
    }
}
