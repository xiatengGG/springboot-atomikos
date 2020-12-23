package com.xiateng.service.impl;

import com.xiateng.dao.userbuyer.TUserBuyerMapper;
import com.xiateng.dao.user.TUserMapper;
import com.xiateng.dao.user.TtUserMapper;
import com.xiateng.entity.TUser;
import com.xiateng.entity.TUserBuyer;
import com.xiateng.entity.TtUser;
import com.xiateng.service.TUserService;
import com.xiateng.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TUserServiceImpl implements TUserService{
    @Autowired
    private TtUserMapper ttUserMapper;
    @Autowired
    private TUserBuyerMapper tUserBuyerMapper;

    @Override
    public List<TUser> selectByUserList(TUser example) {
        return null;
    }

    /**
     * 实现多数据库操作
     * @return
     */
    @Transactional
    public int transactionalTest() throws Exception{
        // sit(数据源1)
        TUserBuyer tUserBuyer = new TUserBuyer();
        tUserBuyer.setUserId(0L);
        tUserBuyer.setBond(444);
        tUserBuyerMapper.updateByPrimaryKeySelective(tUserBuyer);
        // pre(数据源2)
        TtUser ttUser = new TtUser();
        ttUser.setId(1L);
        ttUser.setUpdatedBy(444L);
        ttUserMapper.updateByPrimaryKeySelective(ttUser);
        //模拟异常
        int a = 1/0;
        return 1;
    }
}
