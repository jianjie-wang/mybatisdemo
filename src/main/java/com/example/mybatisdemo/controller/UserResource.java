package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 /**
 * @program: mybatisdemo
 * @description:
 * @author: WangJJ
 * @create: 2020-09-03 15:43
 **/
 @Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    UserMapper userMapper;

     @ApiOperation("获取用户列表")
     @GetMapping("/wang")
    public ResponseEntity<List<User>> getUser(){
         log.debug("REST request to get all user");
         List<User>  users =  userMapper.queryAll();
         return ResponseEntity.ok(users);
    }

     @ApiOperation("获取用户列表（mybatis-plus自带）")
     @GetMapping("/jian")
     public ResponseEntity<List<User>> getUserList(){
         log.debug("REST request to get all user");
         List<User>  users =  userMapper.selectList(null);
         return ResponseEntity.ok(users);
 }

     @ApiOperation("获取一个用户")
     @GetMapping("/jie")
     public ResponseEntity<User> getOneUser(String userId){
         log.debug("REST request to get a user{}",userId);
         User users =  userMapper.getOneById(userId);
         return ResponseEntity.ok(users);
     }

     @ApiOperation("获取一个用户（mybatis-plus自带）")
     @GetMapping("/j")
     public ResponseEntity<User> getOneUsers(String userId){
         log.debug("REST request to get a user{}",userId);
         User users =  userMapper.selectById(userId);
         return ResponseEntity.ok(users);
     }

     @ApiOperation("添加一个用户(mybatis-plus自带)")
     @PostMapping("/user")
     public ResponseEntity<Integer> addUser(@RequestBody User user){
         log.debug("REST request to creat a user{}",user);
         Integer i = userMapper.insert(user);
         return ResponseEntity.ok(i);
     }

     @ApiOperation("删除用户")
     @DeleteMapping("/delete")
     public ResponseEntity<Boolean> deleteUser(String userId){
         log.debug("REST request to delete a user{}",userId);
         userMapper.deleteById(userId);
         return ResponseEntity.ok(true);
     }

}
