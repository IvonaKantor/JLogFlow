package com.logging.platform.mapper;

import com.logging.platform.dto.*;
import com.logging.platform.entity.LogDataEntity;
import com.logging.platform.models.LogData;
import org.mapstruct.*;
import java.util.List;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface LogDataMapper {

    LogDataEntity toEntity(LogDataDto request);

    List<LogData> toResponseList(List<LogDataEntity> entities);

    LogData toResponse(LogDataEntity entity);
}