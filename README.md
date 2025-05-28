# 🕷️ Crawler Platform 爬虫微服务平台

一个基于 Spring Cloud Alibaba 的分布式爬虫系统，支持模块化设计，涵盖任务调度、数据抓取、权限控制、数据存储、监控告警等功能。

---

## 🚀 项目模块结构

```
crawler-platform/
 ├── crawler-core/           # 爬虫核心逻辑模块
 ├── crawler-api/            # 对外提供接口的模块
 ├── crawler-gateway/        # API 网关模块
 ├── crawler-config/         # 集中配置管理模块
 ├── crawler-discovery/      # 服务注册与发现模块（Nacos）
 ├── crawler-common/         # 公共工具类模块
 ├── crawler-auth/           # 认证与授权模块
 ├── crawler-monitor/        # 服务监控模块
 ├── crawler-job/            # 定时任务调度模块
 ├── crawler-log/            # 日志收集与分析模块
 ├── crawler-notification/   # 通知与告警模块
 ├── crawler-storage/        # 数据存储模块
 ├── crawler-visualization/  # 可视化界面模块
 ├── pom.xml                 # 父项目的 Maven 配置文件
 └── README.md               # 项目说明文档
```

---

## 💡 功能简介

- **统一网关（crawler-gateway）**  
  统一请求入口，负责路由转发、身份认证、权限校验、限流与熔断。
- **认证授权（crawler-auth）**  
  用户管理、角色权限控制，基于 JWT 和 RBAC 模型实现安全认证。
- **爬虫核心（crawler-core）**  
  爬虫业务逻辑实现，包括任务定义、调度请求处理。
- **任务调度（crawler-job）**  
  定时调度爬虫任务，支持动态添加、停止任务。
- **数据存储（crawler-storage）**  
  多数据源支持（MySQL、MongoDB、Elasticsearch），存储爬取结果。
- **服务发现（crawler-discovery）**  
  基于 Nacos 实现服务注册和发现。
- **集中配置（crawler-config）**  
  基于 Nacos 实现分布式配置管理。
- **监控告警（crawler-monitor + crawler-notification）**  
  采集运行指标，异常告警，日志分析。
- **日志管理（crawler-log）**  
  收集与管理系统日志。
- **公共模块（crawler-common）**  
  通用工具类和基础组件。
- **可视化界面（crawler-visualization）**  
  管理界面及数据展示。

---

## 🛠️ 技术栈

- Spring Boot 3.x  
- Spring Cloud Alibaba (Nacos, Sentinel, Gateway)  
- MyBatis-Plus  
- JWT + RBAC  
- Kafka  
- MySQL / MongoDB / Elasticsearch  
- Docker & Kubernetes（可选）

---

## 🎯 快速开始

### 环境依赖

- JDK 17+
- Maven 3.6+
- Nacos 注册中心  
- MySQL 数据库  
- Kafka 消息队列  
- Redis（限流、缓存）

### 启动顺序示例

1. 启动 Nacos 注册中心  
2. 启动 MySQL、Kafka、Redis 等依赖  
3. 启动 `crawler-config`（配置中心）  
4. 启动 `crawler-discovery`（服务发现）  
5. 启动核心服务：`crawler-auth`、`crawler-core`、`crawler-job`、`crawler-storage` 等  
6. 启动 `crawler-gateway`（API 网关）  
7. 启动监控和日志服务：`crawler-monitor`、`crawler-log`、`crawler-notification`  
8. 启动 `crawler-visualization`（前端界面）

---

## 📋 项目管理规范

- 使用 Git 进行版本控制，严格遵守 [Conventional Commits](https://www.conventionalcommits.org/zh-hans/v1.0.0/) 提交规范  
- 使用 `husky` 和 `commitlint` 进行提交校验  
- 每个功能模块独立开发，避免单个模块提交过大，保持提交记录清晰  
- 代码通过 SonarQube 等工具进行质量检测  
- 采用 CI/CD 自动化流水线（可选）

---

## 📖 文档和接口说明

- 每个模块代码内提供完整注释  
- REST API 文档采用 Swagger 或 SpringDoc 生成  
- 详细设计文档见 `docs/` 目录（可自建）

---

## 🤝 贡献指南

欢迎提交 Issue 和 PR，贡献请遵循以下规范：

- 保持代码风格一致  
- 单元测试覆盖新代码  
- 变更必须包含详细描述  
- 避免提交敏感信息  

---

## 🗂️ 任务进度

| 模块/功能             | 说明                               | 状态     |
| --------------------- | ---------------------------------- | -------- |
| crawler-auth          | 认证与授权模块，用户、角色权限管理 | ⚠️ 开发中 |
| crawler-gateway       | API 网关，路由、限流、鉴权         | 20%      |
| crawler-core          | 爬虫核心业务逻辑实现               | ⬜ 未开始 |
| crawler-job           | 任务调度，定时任务管理             | ⬜ 未开始 |
| crawler-storage       | 数据存储模块，MySQL/MongoDB/ES     | ⬜ 未开始 |
| crawler-monitor       | 服务监控与指标采集                 | ⬜ 未开始 |
| crawler-log           | 日志收集与分析                     | ⬜ 未开始 |
| crawler-notification  | 告警与通知                         | ⬜ 未开始 |
| crawler-visualization | 可视化界面展示                     | ⬜ 未开始 |
| crawler-config        | 配置管理中心（Nacos 集成）         | ⚠️ 开发中 |
| crawler-discovery     | 服务注册与发现（Nacos）            | ⬜ 未开始 |
| crawler-common        | 公共工具类及基础组件               | ⚠️ 开发中 |

> ✅ 已完成  
> ⚠️ 开发中  
> ⬜ 未开始

## 📄 许可证

本项目采用 MIT 许可证，详情见 LICENSE 文件。
