package com.serheev.awssqsmessenger.mapper;

import com.serheev.awssqsmessenger.dto.RecipientDto;
import com.serheev.awssqsmessenger.entity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {
    RecipientDto map(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDto dto);
}
