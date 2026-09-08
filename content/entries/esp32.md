---
id: esp32
kind: model
title: ESP32无线微控制器
englishName: ESP32 SoC
aliases: ESP32 SoC|esp32
categoryId: digital-control
summary: 集成 Wi‑Fi、Bluetooth 和丰富外设的 32 位 SoC，适合联网嵌入式设备。
keywords: 物联网节点|无线网关|传感采集和人机交互
image: images/digital-control.svg
imageAlt: ESP32无线微控制器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: mcu|atmega328p
sourceTitle: ESP32无线微控制器官方技术资料
sourcePublisher: Espressif
sourceUrl: https://www.espressif.com/en/products/socs/esp32
sourceAccessedAt: 2026-09-07
---
## 简介
集成 Wi‑Fi、Bluetooth 和丰富外设的 32 位 SoC，适合联网嵌入式设备。

## 工作原理
双核或单核处理器运行固件，片上射频、存储接口和外设通过系统总线协同。

## 关键参数
具体系列、Flash/PSRAM、GPIO 复用、射频、功耗、供电峰值和安全启动。

## 选型要点
选型时结合无线制式、算力、存储、低功耗、天线、温度和认证，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
物联网节点、无线网关、传感采集和人机交互。

## 注意事项
3.3 V 电源需承受射频峰值电流，天线净空和射频布局必须按指南。

## 常见故障与误区
供电压降复位、启动绑带脚冲突、天线被铜遮挡或误用非 5 V 容忍 GPIO。
