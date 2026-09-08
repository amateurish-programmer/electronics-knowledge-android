---
id: voltage-reference
kind: category
title: 电压基准
englishName: Voltage Reference
aliases: Voltage Reference|voltage-reference
categoryId: analog-power
summary: 提供低漂移、低噪声的基准电压，决定精密 ADC、DAC 和控制环路的尺度。
keywords: ADC/DAC 参考|校准源|精密比较阈值和测量基准
image: images/analog-power.svg
imageAlt: 电压基准分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: adc|tl431
sourceTitle: 电压基准参考资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
提供低漂移、低噪声的基准电压，决定精密 ADC、DAC 和控制环路的尺度。

## 工作原理
带隙、埋藏齐纳或其他结构产生对电源和温度不敏感的稳定电压。

## 关键参数
初始精度、温漂、长期漂移、噪声、负载调整、静态电流和启动。

## 选型要点
选型时结合目标精度、温区、噪声、负载、功耗和封装应力，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
ADC/DAC 参考、校准源、精密比较阈值和测量基准。

## 注意事项
布局需隔离热源和数字噪声，输出电容必须符合稳定性要求。

## 常见故障与误区
只看初始精度、忽略温漂和焊接应力、负载过大或滤波电容导致振荡。
