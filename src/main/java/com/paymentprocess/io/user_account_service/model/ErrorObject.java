package com.paymentprocess.io.user_account_service.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorObject {
    private LocalDateTime timestamp;
    private String error;
    private String message;
}
