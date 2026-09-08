---
id: pnp-transistor
kind: category
title: PNP三极管
englishName: PNP Transistor
aliases: PNP Transistor|pnp-transistor
categoryId: semiconductor
summary: 基极低于发射极时导通的 PNP 双极型晶体管，常用于高边控制。
keywords: 高边开关|互补放大|电流镜和电平转换
image: images/semiconductor.svg
imageAlt: PNP三极管分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: bjt|npn-transistor
sourceTitle: PNP三极管参考资料
sourcePublisher: Nexperia
sourceUrl: https://www.nexperia.com/products
sourceAccessedAt: 2026-09-07
---
## 简介
基极低于发射极时导通的 PNP 双极型晶体管，常用于高边控制。

## 工作原理
发射极向基区注入空穴，形成从发射极到集电极的受控电流。

## 关键参数
VCEO、IC、hFE、VCE(sat)、基极电流、功耗、频率和 SOA。

## 选型要点
选型时结合高边电压、负载、强迫 β、驱动方式和散热，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
高边开关、互补放大、电流镜和电平转换。

## 注意事项
驱动参考点是发射极，逻辑低电平需保证不使基极结过流。

## 常见故障与误区
E/C 接反、基极无电阻、无法完全关断或与 NPN 极性混淆。
