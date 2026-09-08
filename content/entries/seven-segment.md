---
id: seven-segment
kind: category
title: 七段数码管
englishName: Seven-Segment Display
aliases: Seven-Segment Display|seven-segment
categoryId: display
summary: 由七个条形 LED 段组成，可显示数字和少量字符。
keywords: 仪表数值|计数器和简单状态显示|多位常用动态扫描
image: images/display.svg
imageAlt: 七段数码管分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: led|74hc595
sourceTitle: 七段数码管官方技术资料
sourcePublisher: Vishay
sourceUrl: https://www.vishay.com/en/optical-sensors/
sourceAccessedAt: 2026-09-07
---
## 简介
由七个条形 LED 段组成，可显示数字和少量字符。

## 工作原理
按段点亮 a 至 g 的组合形成字形，共阳或共阴结构决定驱动极性。

## 关键参数
共阳/共阴、颜色、正向电流电压、位数、亮度、尺寸和占空比。

## 选型要点
选型时结合位数、极性、颜色、亮度、扫描方式和驱动器，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
仪表数值、计数器和简单状态显示，多位常用动态扫描。

## 注意事项
每段需要限流；扫描峰值电流与平均功耗都不能越限。

## 常见故障与误区
共阳共阴弄反、段序错误、无消隐鬼影、限流不当或刷新率太低。
