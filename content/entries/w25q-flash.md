---
id: w25q-flash
kind: model
title: W25Q串行Flash
englishName: W25Q SPI Flash
aliases: W25Q SPI Flash|w25q-flash
categoryId: digital-control
summary: W25Q 系列是 SPI NOR Flash，用于存放固件、资源和较大容量非易失数据。
keywords: 固件升级包|字库|图片|日志和外部程序存储
image: images/digital-control.svg
imageAlt: W25Q串行Flash分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: 24c02|sram
sourceTitle: W25Q串行Flash官方技术资料
sourcePublisher: Winbond
sourceUrl: https://www.winbond.com/hq/product/code-storage-flash-memory/serial-nor-flash/
sourceAccessedAt: 2026-09-07
---
## 简介
W25Q 系列是 SPI NOR Flash，用于存放固件、资源和较大容量非易失数据。

## 工作原理
浮栅/电荷存储阵列按页编程、按扇区擦除，SPI 指令控制地址和状态。

## 关键参数
具体容量、供电、SPI/QSPI 速率、页大小、扇区、擦写寿命和保持时间。

## 选型要点
选型时结合容量、电压、接口宽度、执行速度、寿命、封装和供应商 ID，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
固件升级包、字库、图片、日志和外部程序存储。

## 注意事项
写前通常要擦除，掉电保护和磨损均衡需由上层设计。

## 常见故障与误区
容量地址位数错、未等待 BUSY、跨页写回卷、写保护未解锁或电平不兼容。
