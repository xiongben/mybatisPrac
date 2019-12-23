package com.xiongben.dao;

import com.xiongben.domain.Account;
import com.xiongben.domain.AccountUser;
import com.xiongben.domain.User;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    List<AccountUser> findAllAccount();
}
