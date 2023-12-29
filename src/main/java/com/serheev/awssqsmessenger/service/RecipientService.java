package com.serheev.awssqsmessenger.service;

import com.serheev.awssqsmessenger.dto.RecipientDto;
import com.serheev.awssqsmessenger.entity.NotificationEntity;
import com.serheev.awssqsmessenger.entity.RecipientEntity;
import com.serheev.awssqsmessenger.mapper.RecipientMapper;
import com.serheev.awssqsmessenger.repository.NotificationRepository;
import com.serheev.awssqsmessenger.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                        notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipient = tuples.getT1();
                    List<NotificationEntity> notifications = tuples.getT2();
                    recipient.setNotifications(notifications);
                    return recipientMapper.map(recipient);
                });
    }
}
