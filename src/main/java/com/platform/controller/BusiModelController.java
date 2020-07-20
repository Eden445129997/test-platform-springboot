//package com.platform.controller;
//
//import com.platform.common.singleton.SingletonMybatis;
//import com.platform.dao.TbBusiModelMapper;
//import com.platform.entity.TbBusiModel;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
////@RequestMapping("/busiModel")
//public class BusiModelController {
//
//    private static SqlSessionFactory sqlSessionFactory;
//    static {
//        sqlSessionFactory = SingletonMybatis.getSqlSessionFactory();
//    }
//
//    @RequestMapping(method = RequestMethod.GET,value = "/queryBusiModel")
//    public List<TbBusiModel> queryBusiModel(){
//        //打开数据库连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<TbBusiModel> result = null;
//
//        //通过反射机制获取获取接口
//        TbBusiModelMapper tbBusiModelMapper = sqlSession.getMapper(TbBusiModelMapper.class);
//        try {
//            //将接口查询到的数据返回给result
//            result = tbBusiModelMapper.queryBusiModel();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        //提交sql
//        sqlSession.commit();
//        //关闭数据库连接
//        sqlSession.close();
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.GET,value = "/queryBusiModelByName/{name}")
//    public List<TbBusiModel> queryBusiModelByName(@PathVariable("name") String name){
//        //打开数据库连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<TbBusiModel> result = null;
//
//        //通过反射机制获取获取接口
//        TbBusiModelMapper tbBusiModelMapper = sqlSession.getMapper(TbBusiModelMapper.class);
//        try {
//            //将接口查询到的数据返回给result
//            result = tbBusiModelMapper.queryBusiModelByName(name);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        //提交sql
//        sqlSession.commit();
//        //关闭数据库连接
//        sqlSession.close();
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.POST,value = "/addBusiModel")
//    public boolean addBusiModel(@RequestBody TbBusiModel busiModel){
//        //打开数据库连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //返回布尔值
//        boolean result = true;
//
//        //通过反射机制获取获取接口
//        TbBusiModelMapper tbBusiModelMapper = sqlSession.getMapper(TbBusiModelMapper.class);
//        try {
//            //将接口查询到的数据返回给result
//            result = tbBusiModelMapper.addBusiModel(busiModel);
//        }catch (Exception e){
//            e.printStackTrace();
//            result = false;
//        }
//
//        //提交sql
//        sqlSession.commit();
//        //关闭数据库连接
//        sqlSession.close();
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.PUT,value = "/updateBusiModelById/{id}")
//    public boolean updateBusiModelById(@PathVariable("id") Integer id,@RequestBody TbBusiModel busiModel){
//        //打开数据库连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //返回布尔值
//        boolean result = true;
//
//        //通过反射机制获取获取接口
//        TbBusiModelMapper tbBusiModelMapper = sqlSession.getMapper(TbBusiModelMapper.class);
//        try {
//            busiModel.setId(id);
//            result = tbBusiModelMapper.updateBusiModelById(busiModel);
//        }catch (Exception e){
//            e.printStackTrace();
//            result = false;
//        }
//
//        //提交sql
//        sqlSession.commit();
//        //关闭数据库连接
//        sqlSession.close();
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteBusiModelById/{id}")
//    public boolean deleteBusiModelById(@PathVariable("id") Integer id){
//        //打开数据库连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //返回布尔值
//        boolean result = true;
//
//        //通过反射机制获取获取接口
//        TbBusiModelMapper tbBusiModelMapper = sqlSession.getMapper(TbBusiModelMapper.class);
//        try {
//            result = tbBusiModelMapper.deleteBusiModelById(id);
//        }catch (Exception e){
//            e.printStackTrace();
//            result = false;
//        }
//        //提交sql
//        sqlSession.commit();
//        //关闭数据库连接
//        sqlSession.close();
//        return result;
//    }
//}
