package com.myproject.springproject.services;

import com.myproject.springproject.entity.Account;
import com.myproject.springproject.repository.IRepository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository iAccountRepository;


    @Override
    public List<Account> getAllAccount() {
        return iAccountRepository.findAll();
    }

}
