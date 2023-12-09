package com.moz.ates.traffic.police.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class UserVO {

    private String oprtrId;
    private String oprtrDeptId;
    private String oprtrNm;
    private String oprtrAccountId;
    private String oprtrAccountPw;
    private String oprtrAccountPwChk;
    private String oprtrPno;
    private String oprtrEmail;
    private String oprtrRegDt;
    private String oprtrPermission;
    private String oprtrDeptNm;
    private String lastLoginDt;
    private String loginFailCnt;
    private String connectIp;
    private String crDt;
    private String crtr;
    
    private int start = 0;
    private int length = 10;

    private String sDate;
    private String eDate;
    private String searchType;
    private String searchTxt;

    private Collection<? extends GrantedAuthority> authorities;

    public UserVO(String username){
        this.oprtrAccountId = username;
    }
}
