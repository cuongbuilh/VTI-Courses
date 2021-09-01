package com.myproject.springproject.repository.IRepository;

import com.myproject.springproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Short> {
}
