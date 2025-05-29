package com.example.crawlerauth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_role")
public class UserRole {
    private Long userId;
    private Long roleId;
    private Date createdAt;
}