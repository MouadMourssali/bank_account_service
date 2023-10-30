package com.example.bank_account_service.web;


import com.example.bank_account_service.DTO.BankAccountRequestDTO;
import com.example.bank_account_service.DTO.BankAccountResponseDTO;
import com.example.bank_account_service.Service.AccountService;
import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.repositories.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount>bankAccountList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount (@Argument BankAccountRequestDTO bankAccount){
        return accountService.AddAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
   @MutationMapping
public Boolean deleteAccount(@Argument String id){
    bankAccountRepository.deleteById(id);
    return true;
}
}