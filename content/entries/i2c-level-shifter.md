---
id: i2c-level-shifter
kind: category
title: I²C双向电平转换
englishName: I2C Level Shifter
aliases: I2C Level Shifter|i2c-level-shifter
categoryId: interface
summary: 在不同电压域之间转换 I²C 的开漏双向信号。
keywords: 连接 1.8 V|3.3 V|5 V 的 I²C/SMBus 设备
image: images/interface.svg
imageAlt: I²C双向电平转换分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: 24c02|uart-transceiver
sourceTitle: I²C双向电平转换官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/interface/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
在不同电压域之间转换 I²C 的开漏双向信号。

## 工作原理
常用 MOSFET 利用两侧上拉和体二极管实现低电平双向传递，高电平各自回到本域电压。

## 关键参数
两侧电压、允许低电平、上拉阻值、总线电容、速率、通道数和方向性。

## 选型要点
选型时结合电压域、速率、总线电容、器件类型和上电顺序，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
连接 1.8 V、3.3 V、5 V 的 I²C/SMBus 设备。

## 注意事项
推挽信号不能直接套用被动 MOSFET 方案；两侧都需要上拉。

## 常见故障与误区
缺少一侧上拉、MOSFET 漏源接反、上拉过弱或选到带方向控制的错误器件。
