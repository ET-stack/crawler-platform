-- 1. 用户表
CREATE TABLE `user` (
                        `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                        `username` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
                        `password` VARCHAR(255) NOT NULL COMMENT '加密后的密码',
                        `email` VARCHAR(100) COMMENT '邮箱地址',
                        `phone` VARCHAR(20) COMMENT '手机号码',
                        `status` TINYINT NOT NULL DEFAULT 1 COMMENT '用户状态：0禁用，1启用',
                        `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识，0未删除，1已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- 2. 角色表
CREATE TABLE `role` (
                        `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                        `name` VARCHAR(50) NOT NULL UNIQUE COMMENT '角色名称',
                        `description` VARCHAR(255) COMMENT '角色描述',
                        `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色表';

-- 3. 用户角色关联表
CREATE TABLE `user_role` (
                             `user_id` BIGINT NOT NULL COMMENT '用户ID（业务层保证存在）',
                             `role_id` BIGINT NOT NULL COMMENT '角色ID（业务层保证存在）',
                             `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色关联表';

-- 4. 权限表
CREATE TABLE `permission` (
                              `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                              `name` VARCHAR(100) NOT NULL UNIQUE COMMENT '权限名称',
                              `description` VARCHAR(255) COMMENT '权限描述',
                              `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限定义表';

-- 5. 角色权限关联表
CREATE TABLE `role_permission` (
                                   `role_id` BIGINT NOT NULL COMMENT '角色ID（业务层保证存在）',
                                   `permission_id` BIGINT NOT NULL COMMENT '权限ID（业务层保证存在）',
                                   `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   PRIMARY KEY (`role_id`, `permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与权限关联表';

-- 6. 爬虫任务表
CREATE TABLE `crawler_task` (
                                `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                                `name` VARCHAR(100) NOT NULL COMMENT '任务名称',
                                `url` VARCHAR(255) NOT NULL COMMENT '目标网站URL',
                                `cron_expression` VARCHAR(50) COMMENT 'Cron表达式，用于定时执行',
                                `status` TINYINT NOT NULL DEFAULT 1 COMMENT '任务状态：0停止，1运行',
                                `created_by` BIGINT COMMENT '创建人用户ID（业务层保证存在）',
                                `updated_by` BIGINT COMMENT '更新人用户ID（业务层保证存在）',
                                `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='爬虫任务定义表';

-- 7. 爬虫结果表
CREATE TABLE `crawler_result` (
                                  `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                                  `task_id` BIGINT NOT NULL COMMENT '任务ID（业务层保证存在）',
                                  `data` TEXT COMMENT '抓取结果数据（JSON或HTML等）',
                                  `fetched_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '抓取时间',
                                  `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='爬虫抓取结果表';

-- 8. 任务执行日志
CREATE TABLE `task_execution_log` (
                                      `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                                      `task_id` BIGINT NOT NULL COMMENT '任务ID（业务层保证存在）',
                                      `status` TINYINT NOT NULL COMMENT '执行状态：0失败，1成功',
                                      `start_time` DATETIME COMMENT '开始时间',
                                      `end_time` DATETIME COMMENT '结束时间',
                                      `message` VARCHAR(500) COMMENT '执行信息或错误日志',
                                      `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务执行记录日志表';

-- 9. 系统日志表
CREATE TABLE `system_log` (
                              `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                              `service_name` VARCHAR(100) COMMENT '服务名称或模块',
                              `log_level` VARCHAR(10) COMMENT '日志级别（INFO/ERROR等）',
                              `message` TEXT COMMENT '日志内容',
                              `log_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '日志时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统运行日志记录表';

-- 10. 告警通知表
CREATE TABLE `alert_notification` (
                                      `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                                      `alert_type` VARCHAR(50) COMMENT '告警类型（任务失败等）',
                                      `content` TEXT COMMENT '告警内容',
                                      `status` TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0未读，1已读',
                                      `notify_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '通知时间',
                                      `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统告警通知表';

-- 11. 配置表
CREATE TABLE `config` (
                          `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                          `key` VARCHAR(100) NOT NULL UNIQUE COMMENT '配置项名称',
                          `value` VARCHAR(500) COMMENT '配置值',
                          `description` VARCHAR(255) COMMENT '配置说明',
                          `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统通用配置表';
