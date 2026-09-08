---
id: buzzer
kind: category
title: 蜂鸣器
englishName: Buzzer
aliases: Buzzer|buzzer
categoryId: display
summary: 把电信号转成声音，分为内置振荡器的有源型和需交流驱动的无源型。
keywords: 告警|按键反馈和状态提示|MCU 电流不足时加晶体管驱动
image: images/display.svg
imageAlt: 蜂鸣器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: speaker|led
sourceTitle: 蜂鸣器官方技术资料
sourcePublisher: Vishay
sourceUrl: https://www.vishay.com/en/optical-sensors/
sourceAccessedAt: 2026-09-07
---
## 简介
把电信号转成声音，分为内置振荡器的有源型和需交流驱动的无源型。

## 工作原理
压电片或电磁线圈在交变驱动下振动，有源型内部另含振荡器。

## 关键参数
有源/无源、额定电压、频率、声压、电流、极性和安装。

## 选型要点
选型时结合提示音、音量、供电、功耗、驱动方式和环境，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
告警、按键反馈和状态提示，MCU 电流不足时加晶体管驱动。

## 注意事项
电磁式需处理感应电压，压电式应在合适频率附近驱动。

## 常见故障与误区
无源型接直流无声、极性错误、GPIO 过流或频率不合适。
