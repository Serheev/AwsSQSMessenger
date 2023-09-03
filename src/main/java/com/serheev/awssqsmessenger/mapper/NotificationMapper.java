package com.serheev.awssqsmessenger.mapper;

import com.serheev.awssqsmessenger.dto.NotificationDto;
import com.serheev.awssqsmessenger.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto map(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity map(NotificationDto dto);
}
