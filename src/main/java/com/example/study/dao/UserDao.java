package com.example.study.dao;

import com.example.study.entity.UserEntity;

import java.util.List;

public interface UserDao {
    //声明功能方法，增删改查
    public List<UserEntity> queryUsers();
    public boolean addUser(UserEntity userEntity);
    public boolean updateUser(UserEntity userEntity);
    public boolean deleteUserById(int id);
    public UserEntity queryUserById(int id);
}
