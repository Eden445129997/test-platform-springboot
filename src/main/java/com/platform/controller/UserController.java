package com.platform.controller;

import com.platform.common.singleton.SingletonMybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//声明这个一个rest风格的controller层
@RequestMapping("/user")//路由
public class UserController {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        sqlSessionFactory = SingletonMybatis.getSqlSessionFactory();
    }

//    @RequestMapping(method = RequestMethod.GET,value = "/queryUsers")
//    public List<UserEntity> queryUser(){
//        //打开数据库连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<UserEntity> result = null;
//
//        //通过反射机制获取获取接口
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        //将接口查询到的数据返回给result
//        result = userDao.queryUsers();
//        //提交sql
//        sqlSession.commit();
//        //关闭数据库连接
//        sqlSession.close();
//        return result;
//    }

}