---
id: charge-pump
kind: category
title: 电荷泵
englishName: Charge Pump
aliases: Charge Pump|charge-pump
categoryId: analog-power
summary: 利用开关电容传递电荷，实现升压、反相或倍压的小功率电源。
keywords: 产生负压|接口偏置|小电流倍压和无电感辅助电源
image: images/analog-power.svg
imageAlt: 电荷泵分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: boost-converter|dac
sourceTitle: 电荷泵官方技术资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/power-management/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
利用开关电容传递电荷，实现升压、反相或倍压的小功率电源。

## 工作原理
飞跨电容在不同开关相位连接输入和输出，通过电荷重分配变换电压。

## 关键参数
输入、倍率、输出电流、频率、输出阻抗、纹波、效率和电容要求。

## 选型要点
选型时结合目标极性与倍率、负载、纹波、启动和电容尺寸，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
产生负压、接口偏置、小电流倍压和无电感辅助电源。

## 注意事项
输出随开关电阻和 ESR 下垂，需评估空载和启动行为。

## 常见故障与误区
飞跨电容接错、容量耐压不足、过载压降或极性错误。
