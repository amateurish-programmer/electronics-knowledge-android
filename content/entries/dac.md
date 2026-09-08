---
id: dac
kind: category
title: 数模转换器
englishName: Digital-to-Analog Converter
aliases: Digital-to-Analog Converter|dac
categoryId: analog-power
summary: 把数字码转换为模拟电压或电流，用于设定、控制和波形输出。
keywords: 偏置设定|模拟控制量|音频和任意波形生成
image: images/analog-power.svg
imageAlt: 数模转换器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: adc|voltage-reference
sourceTitle: 数模转换器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
把数字码转换为模拟电压或电流，用于设定、控制和波形输出。

## 工作原理
电阻网络、电流源或电容阵列按数字权重叠加，并由参考源确定满量程。

## 关键参数
分辨率、更新率、INL/DNL、建立时间、参考、输出范围、毛刺和驱动能力。

## 选型要点
选型时结合精度、速度、单调性、通道、输出缓冲和参考方案，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
偏置设定、模拟控制量、音频和任意波形生成。

## 注意事项
输出负载和参考源必须满足稳定条件，高速更新需处理重构滤波。

## 常见故障与误区
码制理解错误、参考不稳、输出超负载、毛刺被误当噪声或未留建立时间。
