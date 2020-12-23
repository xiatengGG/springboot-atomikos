package com.xiateng.service;

import com.xiateng.entity.TUser;
import com.xiateng.entity.TtUser;

import java.util.List;

public interface TUserService {

    List<TUser> selectByUserList(TUser example);

    int transactionalTest() throws Exception;
}
