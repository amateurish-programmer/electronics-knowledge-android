---
id: pmos
kind: category
title: P沟道MOSFET
englishName: P-Channel MOSFET
aliases: P-Channel MOSFET|pmos
categoryId: semiconductor
summary: 栅极低于源极时导通的 P 沟道 MOSFET，常用于简易高边开关。
keywords: 电源通断|反接保护和低频高边负载开关
image: images/semiconductor.svg
imageAlt: P沟道MOSFET分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: mosfet|nmos
sourceTitle: P沟道MOSFET参考资料
sourcePublisher: Nexperia
sourceUrl: https://www.nexperia.com/products
sourceAccessedAt: 2026-09-07
---
## 简介
栅极低于源极时导通的 P 沟道 MOSFET，常用于简易高边开关。

## 工作原理
负栅源电压形成空穴沟道，源漏电流方向与常用 N 沟道高边方案相反。

## 关键参数
VDS、ID、负 VGS 条件下 RDS(on)、栅电荷、SOA、体二极管和热阻。

## 选型要点
选型时结合高边电压、电流、控制电平、损耗和封装，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
电源通断、反接保护和低频高边负载开关。

## 注意事项
控制信号必须相对源极判断，且不能超过最大 |VGS|。

## 常见故障与误区
以地为参考误判 VGS、源漏接反、导通电阻过大或关断不彻底。
