package com.paymentprocess.io.user_account_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentprocess.io.user_account_service.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
