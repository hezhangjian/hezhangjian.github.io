---
title: 有些事你只有抓包才知道之mysql tls会话
date: 2023-02-09 08:21:43
tags:
  - mysql
---

你的mysql客户端和服务端之间开启tls了吗？你的回答可能是No，我根本没开启mysql的tls。

可是当你抓取了3306 mysql的端口之后，你会发现，抓出来的包里居然有Client Hello、Server Hello这样的典型TLS报文。

![mysql-tls-pcap](mysql-tls-pcap.png)

Mysql返回的**Server Greeting** 中有一个flag的集合字段，名为**Capabilities Flag**，顾名思义，这就是用来做兼容性的位flag。其中的2048位、也就是第12位，代表着**CLIENT_SSL**，如果设置为1，则会在后面的会话中切换到TLS。可以看到里面还有一些其他的flag，事务、长密码等等相关的兼容性开关。

![mysql-pcap-capabilities-flag](mysql-pcap-capabilities-flag.png)

那么该如何关闭这个TLS呢，只需要在my.cnf中添加

```bash
echo "ssl=0" >> /etc/my.cnf
```

重启mysql。再度进行抓包，就发现没有tls的报文了，都是在使用明文进行通信了。

![mysql-plain-pcap](mysql-plain-pcap.png)
