package com.logging.platform.mapper;

import com.logging.platform.dto.request.LogDataRequest;
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

    LogDataEntity toEntity(LogDataRequest request);

   /* LogDataDto toDto(LogDataEntity entity);
    LogDataEntity toEntity(LogDataDto dto);
*/

    List<LogData> toResponseList(List<LogDataEntity> entities);

    LogData toResponse(LogDataEntity entity);
}