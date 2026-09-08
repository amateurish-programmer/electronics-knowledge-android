---
id: adc
kind: category
title: 模数转换器
englishName: Analog-to-Digital Converter
aliases: Analog-to-Digital Converter|adc
categoryId: analog-power
summary: 把连续模拟量映射为数字码，是传感和测量链路的核心。
keywords: 电压电流采样|传感采集和数据记录|前端需抗混叠滤波
image: images/analog-power.svg
imageAlt: 模数转换器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: dac|voltage-reference
sourceTitle: 模数转换器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
把连续模拟量映射为数字码，是传感和测量链路的核心。

## 工作原理
采样保持取得输入，量化器按参考电压与分辨率划分码阶。

## 关键参数
分辨率、采样率、输入范围、参考源、INL/DNL、ENOB 和带宽。

## 选型要点
选型时结合信号带宽、动态范围、允许误差、通道数和延迟，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
电压电流采样、传感采集和数据记录，前端需抗混叠滤波。

## 注意事项
输入不可越界；参考噪声、源阻抗和采样时间直接影响结果。

## 常见故障与误区
只看标称位数、忽略参考精度、建立不足或采样率过低。
