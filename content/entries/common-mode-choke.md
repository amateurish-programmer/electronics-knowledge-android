---
id: common-mode-choke
kind: category
title: 共模电感
englishName: Common Mode Choke
aliases: Common Mode Choke|common-mode-choke
categoryId: passive
summary: 双绕组磁性器件，用于抑制线上同方向流动的共模高频噪声。
keywords: 电源入口|USB/CAN/RS-485 等差分线的共模 EMI 滤波
image: images/passive.svg
imageAlt: 共模电感分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: inductor|capacitor
sourceTitle: 共模电感参考资料
sourcePublisher: Vishay
sourceUrl: https://www.vishay.com/en/passives/
sourceAccessedAt: 2026-09-07
---
## 简介
双绕组磁性器件，用于抑制线上同方向流动的共模高频噪声。

## 工作原理
共模电流的磁通相加形成高阻抗，正常差模电流磁通大致抵消。

## 关键参数
共模阻抗曲线、额定电流、直流电阻、漏感、耐压和温升。

## 选型要点
选型时结合噪声频段、线路电流、允许压降、安规和尺寸，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
电源入口、USB/CAN/RS-485 等差分线的共模 EMI 滤波。

## 注意事项
器件方向和绕组耦合要正确，不能把差模电感值当共模阻抗。

## 常见故障与误区
选错频段、饱和发热、绕组接反或寄生电容导致高频旁路。
