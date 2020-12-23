package com.xiateng.dao.userbuyer;

import com.xiateng.entity.TUserBuyer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserBuyerMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(TUserBuyer record);

    int insertSelective(TUserBuyer record);


    TUserBuyer selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TUserBuyer record);

    int updateByPrimaryKey(TUserBuyer record);
}