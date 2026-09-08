---
id: rs485-transceiver
kind: category
title: RS-485收发器
englishName: RS-485 Transceiver
aliases: RS-485 Transceiver|rs485-transceiver
categoryId: interface
summary: 在 UART 逻辑电平与 RS-485 差分总线之间转换，支持长距离多点通信。
keywords: Modbus RTU|工业仪表和分布式控制网络
image: images/interface.svg
imageAlt: RS-485收发器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: max485|can-transceiver
sourceTitle: RS-485收发器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/interface/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
在 UART 逻辑电平与 RS-485 差分总线之间转换，支持长距离多点通信。

## 工作原理
驱动器产生 A/B 差分电压，接收器按差分极性恢复逻辑，半双工型需方向控制。

## 关键参数
供电、速率、单位负载、共模、故障保护、ESD、延迟和待机。

## 选型要点
选型时结合节点数、线长、波特率、电平、隔离和浪涌环境，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
Modbus RTU、工业仪表和分布式控制网络。

## 注意事项
仅在线缆物理两端终端，长线需偏置并控制方向切换时序。

## 常见故障与误区
A/B 命名差异、终端位置错、共地不当、DE 释放晚或空闲漂移。
