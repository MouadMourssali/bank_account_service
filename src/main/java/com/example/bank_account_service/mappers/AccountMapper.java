package com.example.bank_account_service.mappers;

import com.example.bank_account_service.DTO.BankAccountResponseDTO;
import com.example.bank_account_service.entities.BankAccount;
import com.fasterxml.jackson.databind.util.BeanUtil;
import graphql.parser.UnicodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        bankAccountResponseDTO.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(bankAccount , bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
