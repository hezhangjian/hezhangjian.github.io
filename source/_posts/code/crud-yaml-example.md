---
title: CRUD接口的api yaml心得
date: 2023-12-25 20:05:45
tags:
  - openapi
---

在写swagger的时候，经常碰到增删改查的简单接口，我将增删改查简单接口总结如下：

一般来说，增删改查有如下几个接口

- 创建资源，operationId为createXxx
- 删除资源
- 更新资源
- 查询单个资源
- 查询资源列表（可能不会查询出所有字段），operationId为listXxx

根据接口，一般可以设计如下的实体类

- CreateXxxReq 创建资源请求，包含除资源id之外的所有字段，有些变种里面可能会包含id字段。
- UpdateXxxReq 更新资源请求，包含除资源id之外支持更新的所有字段。
- XxxResp 资源响应，可用于Crate、Update接口的返回，包含所有字段。
- ListXxxResp 资源列表响应，包含资源列表。
- List<BriefXxxResp> 资源列表响应，包含资源列表，每个资源包含部分字段，一般是id、name、createdTime、updatedTime等。
