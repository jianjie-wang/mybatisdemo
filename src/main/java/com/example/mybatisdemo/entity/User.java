package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: mybatisdemo
 * @description:
 * @author: WangJJ
 * @create: 2020-09-03 15:42
 **/

@Data
@TableName("user")
public class User {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "name")
    private String name;
    private String sex;
    private int score;
}
