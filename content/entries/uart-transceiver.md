---
id: uart-transceiver
kind: category
title: UART收发器
englishName: UART Transceiver
aliases: UART Transceiver|uart-transceiver
categoryId: interface
summary: 在 MCU UART 与外部物理电平或总线标准之间完成驱动、接收和保护。
keywords: 调试串口|设备通信和工业现场总线接口
image: images/interface.svg
imageAlt: UART收发器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: max232|rs485-transceiver
sourceTitle: UART收发器参考资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/interface/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
在 MCU UART 与外部物理电平或总线标准之间完成驱动、接收和保护。

## 工作原理
逻辑 TX/RX 经电平转换、反相或差分驱动适配 RS-232、RS-485 等线路。

## 关键参数
接口标准、供电、电平、速率、通道、共模、ESD 和方向控制。

## 选型要点
选型时结合线路标准、距离、速率、节点数、电压和隔离，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
调试串口、设备通信和工业现场总线接口。

## 注意事项
UART 是字节时序，不等同于 RS-232 或 RS-485 物理层。

## 常见故障与误区
标准混淆、TX/RX 方向错、电平不兼容、波特率不一致或缺共地。
