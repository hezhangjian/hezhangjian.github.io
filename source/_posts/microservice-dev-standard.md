---
title: 一些微服务开发规范
date: 2024-12-08 13:27:42
tags:
  - 微服务
---

## 消费组名称

- 共享消费者使用微服务名称，比如(DeviceManager)
- 广播消费者使用微服务名称+唯一标识，比如
  - kubernetes部署场景下可以将pod名称的唯一部分作为唯一标识，比如下图的nginx可以使用5d4f5c59f8-7hztx作为唯一标识
  ```
  $ kubectl get pod
  NAME                          READY   STATUS    RESTARTS   AGE
  nginx-deployment-5d4f5c59f8-7hztx   1/1     Running   0          2d3h
  nginx-deployment-5d4f5c59f8-xvbnm   1/1     Running   0          2d3h
  redis-5f67c8d8c9-4g2h3              1/1     Running   0          10h
  ```
  - pod的IP地址
  - UUID

## 数据库表

- 数据库表名使用单数。
- 数据库的主键，要考虑对应实体物理上是否唯一。
- 数据库可以分为多个列组合唯一、单列唯一、是否有唯一索引、是否有二级索引。
