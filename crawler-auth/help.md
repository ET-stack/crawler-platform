| 组件               | 职责                     |
| ---------------- | ---------------------- |
| 用户模块（User）       | 用户注册、登录、信息维护           |
| 角色模块（Role）       | 系统角色增删改查               |
| 权限模块（Permission） | 权限定义与分配                |
| 认证模块             | 登录鉴权、JWT颁发、刷新          |
| 授权模块             | 权限检查、角色绑定              |
| 安全配置             | Spring Security、JWT 支持 |


crawler-auth
├── src/main/java/com/example/auth
│   ├── config            # Spring Security、JWT、CORS、密码加密配置
│   ├── controller        # REST 接口
│   ├── entity            # 实体类（MyBatis-Plus自动生成）
│   ├── mapper            # Mapper 接口（自动生成）
│   ├── service           # Service 接口
│   ├── service/impl      # Service 实现
│   ├── vo                # 请求/响应对象（如 LoginVO, UserVO）
│   └── AuthApplication.java
└── resources
├── application.yml
└── mapper/           # Mapper XML（可选，如不使用注解）
