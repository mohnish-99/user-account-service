package com.paymentprocess.io.user_account_service.model;

import java.util.List;


public record UserResponseDTO(Long id,
                             String firstName,
                             String lastName,
                             String email,
                             List<AccountsResponseDTO> accounts) {
    
}
