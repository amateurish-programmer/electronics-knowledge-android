---
id: crystal
kind: category
title: 石英晶体
englishName: Quartz Crystal
aliases: Quartz Crystal|crystal
categoryId: passive
summary: 石英晶体利用机械谐振提供高 Q 值频率选择，常作为时钟基准。
keywords: MCU|通信芯片和实时时钟的 Pierce 振荡器
image: images/passive.svg
imageAlt: 石英晶体分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: resonator|ds3231
sourceTitle: 石英晶体参考资料
sourcePublisher: Vishay
sourceUrl: https://www.vishay.com/en/passives/
sourceAccessedAt: 2026-09-07
---
## 简介
石英晶体利用机械谐振提供高 Q 值频率选择，常作为时钟基准。

## 工作原理
压电效应把电信号与晶体机械振动互相转换，在串并联谐振附近呈特定阻抗。

## 关键参数
标称频率、负载电容、频差、温漂、ESR、驱动功率和老化。

## 选型要点
选型时结合振荡器拓扑、频率精度、负载电容、启动裕量和温度，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
MCU、通信芯片和实时时钟的 Pierce 振荡器。

## 注意事项
负载电容要计入引脚和走线寄生；驱动过强会加速老化或损坏。

## 常见故障与误区
电容按错误公式选取、布局过长、ESR 过高不起振或探头使振荡停振。
