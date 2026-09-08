---
id: mosfet
kind: category
title: MOS场效应管
englishName: MOSFET
aliases: MOSFET|mosfet
categoryId: semiconductor
summary: 以栅源电压控制漏极电流，广泛用于放大和高效开关。
keywords: 电源变换|负载开关|电机驱动和模拟开关
image: images/semiconductor.svg
imageAlt: MOS场效应管分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: nmos|pmos
sourceTitle: MOS场效应管参考资料
sourcePublisher: Nexperia
sourceUrl: https://www.nexperia.com/products
sourceAccessedAt: 2026-09-07
---
## 简介
以栅源电压控制漏极电流，广泛用于放大和高效开关。

## 工作原理
栅极电场调制沟道；稳态栅流很小但切换要充放栅电荷。

## 关键参数
VDS、ID、RDS(on)、VGS(th)、栅电荷、SOA、体二极管和热阻。

## 选型要点
选型时结合母线电压、负载、驱动电压、频率、损耗和散热，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
电源变换、负载开关、电机驱动和模拟开关。

## 注意事项
VGS(th) 不是充分导通电压，栅极怕静电且不能悬空。

## 常见故障与误区
栅压不足、米勒误导通、雪崩超限、寄生振荡或过热。
