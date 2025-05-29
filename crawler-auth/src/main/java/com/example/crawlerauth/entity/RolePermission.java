package com.example.crawlerauth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("role_permission")
public class RolePermission {
    private Long roleId;
    private Long permissionId;
    private Date createdAt;
}