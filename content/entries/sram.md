---
id: sram
kind: category
title: 静态随机存储器
englishName: SRAM
aliases: SRAM|sram
categoryId: digital-control
summary: 静态随机存储器以双稳态单元保存数据，掉电后内容丢失。
keywords: 高速缓存|帧缓冲|采集缓存和 MCU 外扩 RAM
image: images/digital-control.svg
imageAlt: 静态随机存储器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: w25q-flash|24c02
sourceTitle: 静态随机存储器官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/logic-voltage-translation/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
静态随机存储器以双稳态单元保存数据，掉电后内容丢失。

## 工作原理
交叉耦合晶体管形成锁存单元，只要供电存在就无需刷新。

## 关键参数
容量、组织、供电、访问时间、待机电流、接口时序和封装。

## 选型要点
选型时结合容量、总线宽度、速度、功耗、电平和数据保持，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
高速缓存、帧缓冲、采集缓存和 MCU 外扩 RAM。

## 注意事项
地址、数据和控制线必须满足时序，备用电池保持需评估漏电。

## 常见故障与误区
读写使能冲突、总线争用、地址线错位、上电未初始化或越界访问。
