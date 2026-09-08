---
id: inductor
kind: category
title: 电感器
englishName: Inductor
aliases: Inductor|inductor
categoryId: passive
summary: 以磁场储能并阻碍电流快速变化，用于滤波、储能和阻抗匹配。
keywords: 开关电源储能|LC 滤波|射频匹配和扼流
image: images/passive.svg
imageAlt: 电感器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: common-mode-choke|buck-converter
sourceTitle: 电感器官方技术资料
sourcePublisher: Vishay
sourceUrl: https://www.vishay.com/en/passives/
sourceAccessedAt: 2026-09-07
---
## 简介
以磁场储能并阻碍电流快速变化，用于滤波、储能和阻抗匹配。

## 工作原理
电压满足 v=L·di/dt，电流建立磁通；实际器件有铜阻、磁芯损耗和寄生电容。

## 关键参数
电感量、容差、饱和电流、温升电流、DCR、Q 值、频率和屏蔽。

## 选型要点
选型时结合纹波电流、直流偏置、频率、损耗、温升、尺寸和 EMI，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
开关电源储能、LC 滤波、射频匹配和扼流。

## 注意事项
饱和后电感骤降会使电流失控；额定电流定义要区分饱和和温升。

## 常见故障与误区
只看电感量、忽略偏置降感、磁芯过热、啸叫或自谐振以上使用。
