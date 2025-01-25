package az.turing.bookingspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalErrorResponse {
    private UUID requestId;
    private String errorCode;
    private String message;
    private LocalDateTime timeStump;
}
