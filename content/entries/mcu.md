---
id: mcu
kind: category
title: 微控制器
englishName: Microcontroller
aliases: Microcontroller|mcu
categoryId: digital-control
summary: 把 CPU、存储和外设集成在单芯片中，用于实时嵌入式控制。
keywords: 传感采集|电机控制|仪表|家电和工业设备
image: images/digital-control.svg
imageAlt: 微控制器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: stm32f103|atmega328p
sourceTitle: 微控制器官方技术资料
sourcePublisher: STMicroelectronics
sourceUrl: https://www.st.com/en/microcontrollers-microprocessors.html
sourceAccessedAt: 2026-09-07
---
## 简介
把 CPU、存储和外设集成在单芯片中，用于实时嵌入式控制。

## 工作原理
处理器执行固件，通过中断、总线和寄存器协调片上外设。

## 关键参数
内核、主频、Flash/RAM、外设、引脚、功耗、电压和温度。

## 选型要点
选型时结合实时性、资源、接口、低功耗、封装、供货和生态，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
传感采集、电机控制、仪表、家电和工业设备。

## 注意事项
电源、复位、时钟、启动脚、调试口和去耦必须按手册设计。

## 常见故障与误区
资源不足、复用冲突、中断阻塞、看门狗误用或电源完整性差。
