package com.serheev.awssqsmessenger.repository;

import com.serheev.awssqsmessenger.entity.RecipientEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface RecipientRepository extends R2dbcRepository<RecipientEntity, String> {
}
