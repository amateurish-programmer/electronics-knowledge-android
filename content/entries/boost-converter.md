---
id: boost-converter
kind: category
title: 升压型DC-DC
englishName: Boost Converter
aliases: Boost Converter|boost-converter
categoryId: analog-power
summary: 把较低直流电压转换为较高直流电压，常用于电池和母线升压。
keywords: 单节电池升压|LED 电源前级和辅助高压轨
image: images/analog-power.svg
imageAlt: 升压型DC-DC分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: buck-converter|inductor
sourceTitle: 升压型DC-DC官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
把较低直流电压转换为较高直流电压，常用于电池和母线升压。

## 工作原理
开关导通时电感储能，关断时电感电流与输入共同向输出供能。

## 关键参数
输入范围、输出、占空比、频率、电感饱和、纹波、效率和环路。

## 选型要点
选型时结合最低输入、最大负载、启动、效率、瞬态和耐压余量，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
单节电池升压、LED 电源前级和辅助高压轨。

## 注意事项
基本拓扑通常不能切断输入直通路径，启动与空载可能过冲。

## 常见故障与误区
电感饱和、开关耐压不足、反馈受噪声或补偿不稳定。
