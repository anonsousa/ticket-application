package com.antoniosousa.ticket.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_users")
@Data
public class UserEntity {

    @Id
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private OffsetDateTime createdAt;
    private boolean integrated;
    private boolean notified;
}

