package com.xiateng.dao.user;

import com.xiateng.entity.TtUser;

public interface TtUserMapper {

    TtUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TtUser record);
}