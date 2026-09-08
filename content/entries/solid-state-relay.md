---
id: solid-state-relay
kind: category
title: 固态继电器
englishName: Solid State Relay
aliases: Solid State Relay|solid-state-relay
categoryId: electromechanical
summary: 用光耦和功率半导体实现无机械触点的隔离负载开关。
keywords: 加热器|灯具|电磁阀和频繁动作负载控制
image: images/electromechanical.svg
imageAlt: 固态继电器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: relay|triac
sourceTitle: 固态继电器官方技术资料
sourcePublisher: Omron
sourceUrl: https://components.omron.com/
sourceAccessedAt: 2026-09-07
---
## 简介
用光耦和功率半导体实现无机械触点的隔离负载开关。

## 工作原理
输入 LED 驱动隔离接收器，再控制双向可控硅、MOSFET 或晶闸管输出。

## 关键参数
输入电流、负载电压电流、通态压降、漏电、浪涌、过零和散热。

## 选型要点
选型时结合交流/直流负载、浪涌、开关频率、漏电和散热，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
加热器、灯具、电磁阀和频繁动作负载控制。

## 注意事项
关断仍有漏电，导通压降会发热；交流型通常不能开直流。

## 常见故障与误区
类型选错、无散热、负载太小不关断、浪涌超限或缺少吸收。
