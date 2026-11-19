package kh.edu.istad.m2restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thanu_customers")
public class Customer {
    @Id
    private UUID id;
    @Column(length = 12, nullable = false, unique = true)
    private String phoneNumber;
    @Column(length = 60, nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToOne
    private User user;

}
