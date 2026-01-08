package com.logging.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logging.platform.dto.request.LogDataRequest;
import com.logging.platform.entity.LogDataEntity;
import com.logging.platform.mapper.LogDataMapper;
import com.logging.platform.models.LogData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class Service {

    @Inject
    ObjectMapper objectMapper;

    @Inject
    LogDataMapper logDataMapper;

    @Transactional
    public LogDataRequest createLog(LogData request) {
        LogDataEntity entity = logDataMapper.toEntity(request);

        entity.persist(); 
        return logDataMapper.toResponse(entity);
    }

    @Transactional
    public List<LogData> batchCreate(List<LogData> requests) {
        List<LogDataEntity> entities = requests.stream()
                .map(logDataMapper::toEntity)
                .toList();
 
        LogDataEntity.persist(entities);

        return logDataMapper.toResponseList(entities);
    }

    public LogDataRequest getById(Long id) {
        LogDataEntity entity = LogDataEntity.findById(id);
        if (entity == null) {
            return null;
        }
        return logDataMapper.toResponse(entity);
    }

    public List<LogDataRequest> getAll() {
        List<LogDataEntity> entities = LogDataEntity.listAll();
        return logDataMapper.toResponseList(entities);
    }
 
    @Transactional
    public LogDataRequest createLogFromJson(String json) throws Exception {
        LogData request = objectMapper.readValue(json, LogData.class);
 
        return createLog(request);
    }
 
    public String getLogAsJson(Long id) throws Exception {
        LogDataRequest response = getById(id);
        if (response == null) {
            return null;
        }
 
        return objectMapper.writeValueAsString(response);
    }
}