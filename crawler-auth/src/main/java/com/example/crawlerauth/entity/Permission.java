package com.example.crawlerauth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("permission")
public class Permission {
    @TableId
    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Integer deleted;
}