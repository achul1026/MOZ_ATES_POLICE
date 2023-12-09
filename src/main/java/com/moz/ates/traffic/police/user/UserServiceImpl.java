package com.moz.ates.traffic.police.user;

import com.moz.ates.traffic.police.common.DataTableVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int getDupliChk(UserVO userVO) {
        return sqlSession.selectOne("User.selectDupliChk",userVO);
    }

    @Override
    public void registUser(UserVO userVO) {

        sqlSession.insert("User.insertUser",userVO);
    }


    @Override
    public List getUserList(UserVO userVO) {
        return sqlSession.selectList("User.selectUserList",userVO);
    }

    @Override
    public int getUserListCnt(UserVO userVO) {
        return sqlSession.selectOne("User.selectUserListCnt", userVO);
    }

    @Override
    public DataTableVO getUserListDatatable(UserVO userVO) {
        return new DataTableVO(this.getUserList(userVO), this.getUserListCnt(userVO));
    }

    @Override
    public UserVO getUserDetail(String oprtrId) {
        return sqlSession.selectOne("User.selectUserDetail",oprtrId);
    }

    @Override
    public void updateUser(UserVO userVO) {
        sqlSession.update("User.updateUser",userVO);
    }

}
