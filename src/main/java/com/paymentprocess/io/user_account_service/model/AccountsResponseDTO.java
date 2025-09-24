package com.paymentprocess.io.user_account_service.model;

import java.math.BigDecimal;

public record AccountsResponseDTO(Long id,
    String accountNumber,  
    AccountType accountType,
    BigDecimal accountBalance) {
    
}
