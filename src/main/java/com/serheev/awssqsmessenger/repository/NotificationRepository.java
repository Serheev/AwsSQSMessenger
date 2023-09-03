package com.serheev.awssqsmessenger.repository;

import com.serheev.awssqsmessenger.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<NotificationEntity, String> {
}
