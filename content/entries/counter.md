---
id: counter
kind: category
title: 数字计数器
englishName: Digital Counter
aliases: Digital Counter|counter
categoryId: digital-control
summary: 数字计数器按时钟事件改变状态，可实现事件计数、分频和序列控制。
keywords: 频率分频|脉冲累计|地址扫描和时序状态生成
image: images/digital-control.svg
imageAlt: 数字计数器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: cd4017|flip-flop
sourceTitle: 数字计数器参考资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/logic-voltage-translation/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
数字计数器按时钟事件改变状态，可实现事件计数、分频和序列控制。

## 工作原理
触发器级联或同步组合逻辑保存二进制/十进制状态，并在有效边沿更新。

## 关键参数
计数模数、最高时钟、同步方式、复位/使能时序、输出编码和传播延迟。

## 选型要点
选型时结合计数范围、速度、同步性、级联和上电复位，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
频率分频、脉冲累计、地址扫描和时序状态生成。

## 注意事项
异步纹波计数器中间位会短暂跳变，不宜直接译码高速控制。

## 常见故障与误区
复位极性错误、时钟毛刺多计数、跨时钟域未同步或溢出未处理。
