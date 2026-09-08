---
id: ldo
kind: category
title: 低压差线性稳压器
englishName: Low Dropout Regulator
aliases: Low Dropout Regulator|ldo
categoryId: analog-power
summary: 在较小输入输出压差下提供稳定、低噪声电压的线性稳压器。
keywords: 模拟前端|射频|传感器和数字电路的局部稳压
image: images/analog-power.svg
imageAlt: 低压差线性稳压器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: ams1117|buck-converter
sourceTitle: 低压差线性稳压器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
在较小输入输出压差下提供稳定、低噪声电压的线性稳压器。

## 工作原理
反馈环路调节串联调整管，多余输入功率转化为热。

## 关键参数
输入输出、压差、电流、静态电流、噪声、PSRR、电容和热阻。

## 选型要点
选型时结合最小输入、负载、噪声、待机功耗、散热和电容，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
模拟前端、射频、传感器和数字电路的局部稳压。

## 注意事项
按最差压差和温升校核，并遵守输出电容稳定条件。

## 常见故障与误区
输入余量不足、热保护反复、输出振荡或关断脚悬空。
