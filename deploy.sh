#!/bin/bash

# 检查是否传入 commit message 参数
if [ -z "$1" ]; then
  echo "使用方法: $0 <commit-message> [branch]"
  exit 1
fi

# 获取 commit message
COMMIT_MSG=$1

# 获取分支名称，默认值为 main
BRANCH=${2:-main}

# 执行 git 操作
echo "Adding changes to git..."
git add .

echo "Committing changes..."
git commit -m "$COMMIT_MSG"

echo "Pushing to branch $BRANCH..."
git push origin "$BRANCH"

# 构建项目
echo "Building the project..."
mvn clean package

# 获取 JAR 文件路径
JAR_FILE=$(ls target/*.jar)

# 构建 Docker 镜像
DOCKER_IMAGE=eumenides741/rookie-discord-api:latest
echo "Building Docker image $DOCKER_IMAGE..."
docker buildx build --platform linux/amd64 --build-arg JAR_FILE=${JAR_FILE} -t $DOCKER_IMAGE .

# 推送 Docker 镜像到 Docker Hub
echo "Pushing Docker image to Docker Hub..."
docker push eumenides741/rookie-discord-api:latest

echo "Done."