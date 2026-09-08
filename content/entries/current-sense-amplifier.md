---
id: current-sense-amplifier
kind: category
title: 电流检测放大器
englishName: Current Sense Amplifier
aliases: Current Sense Amplifier|current-sense-amplifier
categoryId: analog-power
summary: 测量分流电阻两端的小差分电压，并在较大共模电压下输出可用信号。
keywords: 电池|电机|电源和过流保护中的电流监测
image: images/analog-power.svg
imageAlt: 电流检测放大器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: shunt-resistor|adc
sourceTitle: 电流检测放大器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
测量分流电阻两端的小差分电压，并在较大共模电压下输出可用信号。

## 工作原理
高共模抑制差分放大器按固定或可设增益放大分流压降。

## 关键参数
共模范围、差分范围、增益、失调、CMRR、带宽、漂移和输出摆幅。

## 选型要点
选型时结合高边/低边位置、双向需求、量程、精度和响应速度，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
电池、电机、电源和过流保护中的电流监测。

## 注意事项
开尔文连接分流电阻，输入滤波需保持两路阻抗匹配。

## 常见故障与误区
共模越界、走线压降计入测量、输出饱和或忽略失调对小电流的影响。
