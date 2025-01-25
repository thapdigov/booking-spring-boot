package az.turing.bookingspringboot.mapper;

import az.turing.bookingspringboot.domain.entity.PassengerEntity;
import az.turing.bookingspringboot.model.dto.PassengerDto;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {
    public PassengerDto toDto(PassengerEntity entity) {
        return PassengerDto.builder()
                .ID(entity.getID())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }

    public PassengerEntity toEnt(PassengerDto dto) {
        return PassengerEntity.builder()
                .ID(dto.getID())
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
    }
}
