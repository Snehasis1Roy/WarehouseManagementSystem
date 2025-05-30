package com.example.warehouse.model;

import com.example.warehouse.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@EntityListeners(AuditingEntityListener.class)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Setter
@Getter
@ToString
public class User {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "user_role",nullable = false, updatable = false )
    private UserRole userRole;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "modifed_at",nullable = false)
    @LastModifiedDate
    private Instant lastModifiedAt;

}
