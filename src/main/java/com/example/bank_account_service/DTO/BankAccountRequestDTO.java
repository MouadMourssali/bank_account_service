package com.example.bank_account_service.DTO;

import com.example.bank_account_service.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {


    private Double balance;
    private String currency;

    private AccountType type;
}
