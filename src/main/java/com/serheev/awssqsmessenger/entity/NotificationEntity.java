package com.serheev.awssqsmessenger.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("notifications")
public class NotificationEntity implements Persistable<String> {
    @Id
    String id;
    @Column("subject")
    String subject;
    @Column("text")
    String text;
    @Column("recipient_uid")
    String recipientUid;

    @Transient
    private RecipientEntity recipient;

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }
}
