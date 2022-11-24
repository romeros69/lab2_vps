package com.example.appvotemicroservice.repository;

import com.example.appvotemicroservice.model.entity.TankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TanksRepository extends JpaRepository<TankEntity, UUID> {
}
