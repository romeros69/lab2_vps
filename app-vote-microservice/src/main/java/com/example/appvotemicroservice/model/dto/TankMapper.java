package com.example.appvotemicroservice.model.dto;

import com.example.appvotemicroservice.model.entity.TankEntity;
import org.springframework.stereotype.Component;

@Component
public class TankMapper {

    public TankEntity tankDTOToTankEntity(TankDTO tankDTO) {
        if (tankDTO == null) {
            return null;
        }
        return TankEntity.builder()
                .tittle(tankDTO.getTittle())
                .build();
    }

    public TankDTO tankEntityToTankDTO(TankEntity tankEntity) {
        if (tankEntity == null) {
            return null;
        }
        return TankDTO.builder()
                .tittle(tankEntity.getTittle())
                .build();
    }
}
