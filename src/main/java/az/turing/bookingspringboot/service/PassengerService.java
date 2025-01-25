package az.turing.bookingspringboot.service;

import az.turing.bookingspringboot.domain.entity.PassengerEntity;
import az.turing.bookingspringboot.domain.enums.PassengerStatus;
import az.turing.bookingspringboot.domain.repository.PassengerRepositroy;
import az.turing.bookingspringboot.exception.AlreadyExistsException;
import az.turing.bookingspringboot.exception.NotFoundException;
import az.turing.bookingspringboot.mapper.PassengerMapper;
import az.turing.bookingspringboot.model.dto.PassengerDto;
import az.turing.bookingspringboot.model.request.CreatePassengerRequest;
import az.turing.bookingspringboot.model.request.UpdatePassengerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepositroy passengerRepositroy;
    private final PassengerMapper passengerMapper;

    public PassengerDto create(CreatePassengerRequest createPassengerRequest) {
        if (passengerRepositroy.existsByNameAndSurname(createPassengerRequest.getName(),
                createPassengerRequest.getSurname())) {
            throw new AlreadyExistsException("Passenger already exists!");
        }
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setName(createPassengerRequest.getName());
        passengerEntity.setSurname(createPassengerRequest.getSurname());
        PassengerEntity savedPassenger = passengerRepositroy.save(passengerEntity);
        return passengerMapper.toDto(savedPassenger);
    }

    public PassengerDto update(Long id, UpdatePassengerRequest updatePassengerRequest) {
        PassengerEntity updatedEntity = passengerRepositroy.findById(id)
                .orElseThrow(() -> new NotFoundException("Passenger with " + id + " not found!"));
        updatedEntity.setName(updatePassengerRequest.getName());
        updatedEntity.setSurname(updatePassengerRequest.getSurname());
        return passengerMapper.toDto(updatedEntity);
    }

    public void deleteById(Long id) {
        //softDelete
        PassengerEntity deletedEntity = passengerRepositroy.findById(id)
                .orElseThrow(() -> new NotFoundException("Passenger with " + id + " not found!"));
        deletedEntity.setStatus(PassengerStatus.DELETE);
        //hardDelete
        passengerRepositroy.deleteById(id);
    }

    public List<PassengerDto> findAll() {
        return passengerRepositroy.findAll().stream().map(passengerMapper::toDto).collect(Collectors.toList());
    }

    public PassengerDto findById(Long id) {
        return passengerRepositroy.findById(id).map(passengerMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Passenger with " + id + " not found!"));
    }
}
