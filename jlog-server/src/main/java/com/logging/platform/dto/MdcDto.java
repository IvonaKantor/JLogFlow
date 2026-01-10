package com.logging.platform.dto;

import com.logging.platform.entity.LogEntity;

import java.time.LocalDateTime;
import java.util.Map;

public class MdcDto {
    private int id;
    private Map<String, Object> mdcData;
    private LocalDateTime timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getMdcData() {
        return mdcData;
    }

    public void setMdcData(Map<String, Object> mdcData) {
        this.mdcData = mdcData;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
