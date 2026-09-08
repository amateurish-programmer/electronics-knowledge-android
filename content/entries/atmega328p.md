---
id: atmega328p
kind: model
title: ATmega328P微控制器
englishName: ATmega328P MCU
aliases: ATmega328P MCU|atmega328p
categoryId: digital-control
summary: 8 位 AVR 微控制器，集成 Flash、SRAM、EEPROM、定时器、ADC 和串行接口。
keywords: 小型控制器|Arduino Uno 类原型|传感采集和简单人机界面
image: images/digital-control.svg
imageAlt: ATmega328P微控制器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: mcu|stm32f103
sourceTitle: ATmega328P微控制器官方技术资料
sourcePublisher: Microchip
sourceUrl: https://www.microchip.com/en-us/product/ATmega328P
sourceAccessedAt: 2026-09-07
---
## 简介
8 位 AVR 微控制器，集成 Flash、SRAM、EEPROM、定时器、ADC 和串行接口。

## 工作原理
CPU 从片上 Flash 取指，通过寄存器控制 GPIO 与各片上外设。

## 关键参数
电压与频率关系、存储容量、外设、封装、熔丝和低功耗模式。

## 选型要点
选型时结合程序与 RAM、外设、时钟、功耗、调试方式和封装，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
小型控制器、Arduino Uno 类原型、传感采集和简单人机界面。

## 注意事项
熔丝配置错误会使时钟或编程口失效；AVCC/AREF 必须正确连接。

## 常见故障与误区
时钟熔丝不匹配、看门狗循环、SRAM 溢出或电平不兼容。
