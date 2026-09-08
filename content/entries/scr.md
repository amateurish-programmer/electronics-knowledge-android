---
id: scr
kind: category
title: 晶闸管
englishName: Silicon Controlled Rectifier
aliases: Silicon Controlled Rectifier|scr
categoryId: semiconductor
summary: 可控硅整流器由门极触发后锁存导通，适合单向大功率控制。
keywords: 可控整流|软启动|过压 crowbar 和交流半波控制
image: images/semiconductor.svg
imageAlt: 晶闸管分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: triac|igbt
sourceTitle: 晶闸管参考资料
sourcePublisher: Nexperia
sourceUrl: https://www.nexperia.com/products
sourceAccessedAt: 2026-09-07
---
## 简介
可控硅整流器由门极触发后锁存导通，适合单向大功率控制。

## 工作原理
PNPN 结构被门极脉冲触发后再生导通，阳极电流降到维持电流以下才关断。

## 关键参数
重复耐压、通态电流、浪涌、门极触发、保持电流、dv/dt 和 di/dt。

## 选型要点
选型时结合电网峰值、负载、触发、浪涌、换相和散热，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
可控整流、软启动、过压 crowbar 和交流半波控制。

## 注意事项
直流电路触发后不会靠门极关断，感性负载需换相与吸收设计。

## 常见故障与误区
误以为门极可关断、dv/dt 误触发、门极电流不足或浪涌击穿。
