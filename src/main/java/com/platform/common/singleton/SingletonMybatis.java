package com.platform.common.singleton;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SingletonMybatis {
    //首先声明一个sqlsession工厂用于生产数据库连接实例
    private static SqlSessionFactory sqlSessionFactory;
    //静态代码块，全局只会执行一次
    static {
        //mybatis的配置信息
        String resource = "spring-mybatis.xml";
        //声明一个读取实例
        Reader reader = null;
        try {
            //通过getResourceAsReader方式读取xml配置
            reader = Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        //生成一个数据库实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
