package az.turing.bookingspringboot.exception;

import az.turing.bookingspringboot.model.constant.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> notFoundExceptionHandler(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GlobalErrorResponse.builder()
                .requestId(UUID.randomUUID())
                .errorCode(ErrorCode.NOT_FOUND)
                .message(exception.getMessage())
                .timeStump(LocalDateTime.now())
                .build());
    }
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<GlobalErrorResponse> alreadyExistsExceptionHandler(AlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalErrorResponse.builder()
                .requestId(UUID.randomUUID())
                .errorCode(ErrorCode.ALREADY_EXISTS)
                .message(exception.getMessage())
                .timeStump(LocalDateTime.now())
                .build());
    }
}
