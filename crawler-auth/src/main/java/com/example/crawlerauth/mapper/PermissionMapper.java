package com.example.crawlerauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.crawlerauth.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {
    @Select("""
        SELECT p.code
        FROM permission p
        JOIN role_permission rp ON p.id = rp.permission_id
        JOIN user_role ur ON ur.role_id = rp.role_id
        WHERE ur.user_id = #{userId}
    """)
    List<String> selectPermissionsByUserId(Long userId);
}
