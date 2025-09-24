package com.paymentprocess.io.user_account_service.service;

import java.util.List;

import com.paymentprocess.io.user_account_service.entity.User;
import com.paymentprocess.io.user_account_service.model.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUserById(Long id);
    void saveUser(User user);
    List<UserResponseDTO> getAllUsers();
}
