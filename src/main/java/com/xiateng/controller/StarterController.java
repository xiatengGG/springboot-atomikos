package com.xiateng.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiateng.config.Test;
import com.xiateng.dao.user.TtUserMapper;
import com.xiateng.entity.TUser;
import com.xiateng.entity.TtUser;
import com.xiateng.service.TUserService;
import com.xiateng.util.JedisUtil;
import com.xiateng.util.SerializeUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/user")
public class StarterController {

    @Autowired
    private TUserService tUserService;
    @Autowired
    private TtUserMapper ttUserMapper;
    @Autowired
    @Qualifier("preSqlSessionFactory")
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    private Test test;

    @RequestMapping(value = "/tUserList1")
    @ResponseBody
    public Map<String, Object> tUserList1(){
//        Test test = new Test();
        System.out.println(test.getBlogUrl());
        System.out.println(test.getName());

        Map<String, Object> map = new HashMap<>();
        int result = 0;
        try {
            result = tUserService.transactionalTest();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result","系统异常！");
            return map;
        }
        map.put("result",result);
        return map;
    }

    /**
     * 测试mybatis的一级缓存
     * @return
     */
    @RequestMapping(value = "/a")
    @ResponseBody
    public String a(){
        // 开启一个SqlSession（会话）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TtUserMapper mapper = sqlSession.getMapper(TtUserMapper.class);
        TtUser ttUser = mapper.selectByPrimaryKey(1L);
        System.out.println("-----------------------------------------"+ttUser);
        System.out.println("-----------------------------------------第二次执行");
        TtUser ttUser2 = mapper.selectByPrimaryKey(1L);
        System.out.println("-----------------------------------------"+ttUser2);
        // 关闭会话
        sqlSession.close();
        return "成功";
    }

    /**
     * 测试mybatis的二级缓存
     * @return
     */
    @RequestMapping(value = "/b")
    @ResponseBody
    public Map<String, Object> b(){
        Map map = new HashMap();
        List l = new ArrayList();
        Set s = new HashSet();
        TtUser ttUser = ttUserMapper.selectByPrimaryKey(1L);
        map.put("ttUser",ttUser);
        System.out.println("-----------------------------------------"+ttUser);
        System.out.println("-----------------------------------------第二次执行");
        TtUser ttUser2 = ttUserMapper.selectByPrimaryKey(1L);
        map.put("ttUser2",ttUser2);
        System.out.println("-----------------------------------------"+ttUser2);
        System.out.println("-----------------------------------------第三次执行");
        TtUser ttUser3 = ttUserMapper.selectByPrimaryKey(2L);
        System.out.println("-----------------------------------------"+ttUser3);
        map.put("ttUser3",ttUser3);
        return map;
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String sdf(Model model, HttpServletRequest request) {
//        Jedis jedis = JedisUtil.getJedis();
//        jedis.hset("user", "id", "3");
//        jedis.hset("user", "name", "xiateng");
//        jedis.hset("user", "password", "123455");
//        jedis.hget("user","id");
//        List<String> user = jedis.hmget("user", new String[]{"id","name","password"});
//        System.out.println("---------------------------:  "+user);

        Map map = new TreeMap();
        map.put("2","222222");
        map.put("1","111111");
        map.put("5","555555");
        map.put("3","333333");
        Map map1 = new HashMap();
        map1.put("2","222222");
//        TUser tUser = new TUser();
//        tUser.setUserName("你好");
//        tUser.setPassword("2342342");
//        jedis.set("xiateng", JSON.toJSONString(tUser));

//        String sss = jedis.get("xiateng");
//        TUser ssss = JSON.parseObject(sss,TUser.class);
//        jedis.del("xiateng");
//        System.out.println("---------------------------:  "+ssss.toString());
//
//        jedis.set("code".getBytes(), SerializeUtil.serialize(tUser));
//        byte[] bytes = jedis.get("code".getBytes());
//        TUser o = (TUser)SerializeUtil.unSerialize(bytes);
//        jedis.del("code");
//        System.out.println(o.toString());

//        // String类型
//        jedis.set("test", "123");
//        jedis.get("test");
//        // hash类型
//        jedis.hset("test1","map1","value1");
//        jedis.hget("test1","map1");
//        // list类型
//        jedis.lpush("test2","1");
//        jedis.lpush("test2","2");
//        String pop1 = jedis.lpop("test2");
//        String pop2 = jedis.lpop("test2");
//        List<String> tests2 = jedis.lrange("test2", 0, -1);
//        // set类型
//        jedis.sadd("test3","1","4","2");
//        Set<String> test3 = jedis.smembers("test3");// 查看集合列表
//        Long test31 = jedis.scard("test3");// 查看集合有多少条记录
        // zset类型
//        jedis.zadd("test4",1.0,"你好");// 保存一个key为test4的值，按score排序，默认从小到大排序
//        jedis.zadd("test4",3.0,"你好3");
//        jedis.zadd("test4",2.0,"你好2");
//        Set<String> test4 = jedis.zrange("test4", 0, -1);
//        Map map = new HashMap();
//        map.put("ddd","adfsd");map.put("ddd2","大幅度");
//        System.out.println(map.toString());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("ddd","adfsd");jsonObject.put("ddd2","大幅度");
//        System.out.println(jsonObject.toString());
//        System.out.println(jsonObject.toJSONString());
//        jedis.del("test","test1","test2");

        return "";
    }
}
