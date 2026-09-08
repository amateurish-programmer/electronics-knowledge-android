---
id: buck-converter
kind: category
title: 降压型DC-DC
englishName: Buck Converter
aliases: Buck Converter|buck-converter
categoryId: analog-power
summary: 用开关、电感和电容把较高直流电压高效转换为较低电压。
keywords: 数字系统电源|电池降压和大电流低压轨
image: images/analog-power.svg
imageAlt: 降压型DC-DC分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: boost-converter|ldo
sourceTitle: 降压型DC-DC参考资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
用开关、电感和电容把较高直流电压高效转换为较低电压。

## 工作原理
PWM 开关驱动电感连续供能，反馈环路调节占空比稳定输出。

## 关键参数
输入范围、输出电流、频率、电感纹波与饱和、效率和补偿。

## 选型要点
选型时结合最大输入、最小输出、负载瞬态、EMI、尺寸和散热，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
数字系统电源、电池降压和大电流低压轨。

## 注意事项
反馈节点远离开关节点，高 di/dt 回路必须紧凑。

## 常见故障与误区
电感饱和、输入振铃、反馈取样错误、环路不稳或过热。
