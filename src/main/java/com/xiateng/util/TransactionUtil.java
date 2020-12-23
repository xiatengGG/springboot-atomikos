package com.xiateng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * 封装一个编程式事务
 * 申明式事务是通过注解实现（基于AOP），可不影响业务代码的实现
 */
@Component
@Scope("prototype")
public class TransactionUtil {
    private static final Logger logger = LoggerFactory.getLogger(TransactionUtil.class);
    // 全局接受事务状态
    private TransactionStatus transactionStatus;

    // 获取事务原
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    public TransactionStatus begin(){
        logger.info("开启事务！");
        transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }

    public void commit(){
        logger.info("提交事务！"+transactionStatus.toString());
        dataSourceTransactionManager.commit(transactionStatus);
    }

    public void rollback(){
        System.out.println("回滚事务。。。");
        logger.info("回滚事务。。。"+transactionStatus.toString());
        if(transactionStatus != null){
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }
}
