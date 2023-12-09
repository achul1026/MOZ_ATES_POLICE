package com.moz.ates.traffic.police.user;

import com.moz.ates.traffic.police.common.DataTableVO;

import java.util.List;

public interface UserService {
    int getDupliChk(UserVO userVO);

    void registUser(UserVO userVO);

    DataTableVO getUserListDatatable(UserVO userVO);

    List getUserList(UserVO userVO);

    int getUserListCnt(UserVO userVO);

    UserVO getUserDetail(String oprtrId);

    void updateUser(UserVO userVO);
}
