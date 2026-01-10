package com.logging.platform.models;

import java.time.LocalDateTime;
import java.util.Map;

public class LogMdcData {
    private Map<String, Object> mdc;
    private LocalDateTime timestamp;

    public Map<String, Object> getMdc() {
        return mdc;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMdc(Map<String, Object> mdc) {
        this.mdc = mdc;
    }
}
