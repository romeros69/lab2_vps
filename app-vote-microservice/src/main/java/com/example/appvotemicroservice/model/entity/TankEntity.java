package com.example.appvotemicroservice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "tank")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class TankEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "tittle", nullable = false)
    private String tittle;
}