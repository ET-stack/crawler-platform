本项目采用 Git 进行版本管理，采用简单明了的分支策略，保证代码质量和开发效率。

## 分支说明

- **main（主分支）**
   存放稳定且可发布的代码。
   所有上线版本都基于该分支。
- **dev（开发分支）**
   开发主线，日常开发在该分支进行。
   新功能开发、Bug 修复等都在此完成，测试无误后合并回 `main`。

## 分支管理规范

- **新功能开发**
   在 `dev` 分支基础上创建新的功能分支，命名规范：`feature/功能描述`，完成后合并回 `dev`。
- **Bug 修复**
   在 `dev` 分支基础上创建修复分支，命名规范：`bugfix/问题描述`，完成后合并回 `dev`。
- **发布版本**
   经过充分测试后，将 `dev` 分支合并到 `main` 分支，并打标签（Tag）发布。

## 提交规范（简要）

- 提交信息格式：
   `<类型>(<范围>): <描述>`
   类型示例：`feat`（新功能）、`fix`（修复）、`docs`（文档）、`style`（代码格式）、`refactor`（重构）、`test`（测试）、`chore`（构建/工具）
   例子：`feat(auth): add user login interface`

  ## 工作流程示例

  ```
  bash复制编辑# 从远程获取最新代码
  git checkout dev
  git pull origin dev
  
  # 新功能开发
  git checkout -b feature/add-login
  
  # 开发完成，提交并推送
  git commit -m "feat(auth): add user login interface"
  git push origin feature/add-login
  
  # 创建合并请求（Pull Request）或合并到 dev 分支
  # 代码审核通过后合并
  
  # 测试通过后，将 dev 合并到 main，打标签发布
  git checkout main
  git merge dev
  git tag v1.0.0
  git push origin main --tags
  ```

  