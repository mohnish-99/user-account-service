package com.paymentprocess.io.user_account_service.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
@Builder.Default
@JsonManagedReference
private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account){
        accounts.add(account);
        account.setUser(this);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
        account.setUser(null);
    }
}
