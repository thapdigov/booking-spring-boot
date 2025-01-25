package az.turing.bookingspringboot.controller;

import az.turing.bookingspringboot.model.dto.PassengerDto;
import az.turing.bookingspringboot.model.request.CreatePassengerRequest;
import az.turing.bookingspringboot.model.request.UpdatePassengerRequest;
import az.turing.bookingspringboot.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("passengers")
@RequiredArgsConstructor

public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping
    public ResponseEntity<PassengerDto> create(CreatePassengerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDto> update(@PathVariable("id") Long id, UpdatePassengerRequest request) {
        return ResponseEntity.ok(passengerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        passengerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<PassengerDto> getAll() {
        return passengerService.findAll();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PassengerDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(passengerService.findById(id));
    }
}
