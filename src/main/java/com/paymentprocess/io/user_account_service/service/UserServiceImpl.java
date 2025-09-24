package com.paymentprocess.io.user_account_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.paymentprocess.io.user_account_service.entity.Account;
import com.paymentprocess.io.user_account_service.entity.User;
import com.paymentprocess.io.user_account_service.exception.UserNotFoundException;
import com.paymentprocess.io.user_account_service.model.AccountsResponseDTO;
import com.paymentprocess.io.user_account_service.model.UserResponseDTO;
import com.paymentprocess.io.user_account_service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO getUserById(Long id) {
        
       return mapToDTO(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }
    @Override
    public void saveUser(User userRequest) {

        List<Account> accounts = userRequest.getAccounts();
        List<Account> filteredAccounts = new ArrayList<>();
        

        if(!CollectionUtils.isEmpty(accounts)){
           filteredAccounts = accounts.stream()
            .collect(Collectors.toList());

        }
        User user = User.builder()
                    .firstName(userRequest.getFirstName())
                    .lastName(userRequest.getLastName())
                    .email(userRequest.getEmail())
                    .build();

        filteredAccounts.forEach(user::addAccount);

        userRepository.save(user);
        
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {

    return userRepository.findAll()
           .stream()
           .map(this::mapToDTO)
           .toList();


    }

    private UserResponseDTO mapToDTO(User user){

        List<AccountsResponseDTO> accountsDTO = user.getAccounts()
                                                     .stream()
                                                     .map(account -> new AccountsResponseDTO
                                                     (account.getId(), 
                                                     account.getAccountNumber(), 
                                                     account.getAccountType(), 
                                                     account.getAccountBalance())
                                                     )
                                                     .toList();                        

    return new UserResponseDTO(user.getId(),
                              user.getFirstName(),
                              user.getLastName(),
                              user.getEmail(),
                              accountsDTO);
    }
    
}
