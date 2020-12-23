package com.xiateng.dao.user;

import com.xiateng.entity.TtUser;

public interface TtUserMapper {

    int updateByPrimaryKeySelective(TtUser record);
}