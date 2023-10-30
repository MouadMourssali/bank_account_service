package com.example.bank_account_service.Service;

import com.example.bank_account_service.DTO.BankAccountRequestDTO;
import com.example.bank_account_service.DTO.BankAccountResponseDTO;
import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.mappers.AccountMapper;
import com.example.bank_account_service.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO AddAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

        return accountMapper.fromBankAccount(saveBankAccount);
    }
}
