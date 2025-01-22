package com.javaguide.banking.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "accounts")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Changed from 'long' to 'Long'

    @Column(name = "account_holder_name", nullable = false, length = 100)
    private String accountHolderName;

    @Column(nullable = false)
    private double balance;
}
