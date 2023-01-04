---
title: 多语言编程 各大Http库配置指南
date: 2023-11-18 17:24:58
tags:
  - Code
---
<!-- toc -->

# Go

## Go标准库

### timeout

```go
client := http.Client{
    Timeout: timeout,
}
```

### connection timeout

```go
client := http.Client{
    Transport: &http.Transport{
        Dial: (&net.Dialer{
            Timeout: timeout,
        }).Dial,
    },
}
```
