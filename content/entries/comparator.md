---
id: comparator
kind: category
title: 电压比较器
englishName: Comparator
aliases: Comparator|comparator
categoryId: analog-power
summary: 比较两个模拟电压并输出逻辑状态，适合阈值检测和波形整形。
keywords: 过压欠压|零交越|窗口比较和 RC 波形整形
image: images/analog-power.svg
imageAlt: 电压比较器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: lm393|op-amp
sourceTitle: 电压比较器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
比较两个模拟电压并输出逻辑状态，适合阈值检测和波形整形。

## 工作原理
高增益差分级判断输入差值符号，输出级通常进入高或低饱和状态。

## 关键参数
输入共模范围、失调、传播延迟、迟滞、输出类型和供电范围。

## 选型要点
选型时结合阈值精度、速度、输入范围、输出接口和功耗，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
过压欠压、零交越、窗口比较和 RC 波形整形。

## 注意事项
开漏输出需要上拉；无迟滞时慢信号会在阈值附近抖动。

## 常见故障与误区
把运放当高速比较器、输入越过共模范围、缺上拉或正反馈方向错误。
