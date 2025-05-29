package com.example.warehouse.model;

import com.example.warehouse.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private UserRole userRole;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "modifed_at")
    @LastModifiedDate
    private Instant lastModifiedAt;
}
