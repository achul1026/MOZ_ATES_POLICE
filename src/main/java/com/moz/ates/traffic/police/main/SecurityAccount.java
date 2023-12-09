package com.moz.ates.traffic.police.main;


import org.springframework.security.core.userdetails.User;

import com.moz.ates.traffic.police.config.AuthenticationEntity;


public class SecurityAccount extends User {
    public SecurityAccount(AuthenticationEntity authenticationEntity) {
        super(authenticationEntity.getOprtrAccountId(), authenticationEntity.getOprtrAccountPw(), authenticationEntity.getAuthorities());
    }
}