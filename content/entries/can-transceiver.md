---
id: can-transceiver
kind: category
title: CAN收发器
englishName: CAN Transceiver
aliases: CAN Transceiver|can-transceiver
categoryId: interface
summary: 在 CAN 控制器逻辑电平与 CANH/CANL 差分总线间完成物理层转换。
keywords: 汽车和工业设备网络|总线物理两端通常各接匹配终端
image: images/interface.svg
imageAlt: CAN收发器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: tja1050|rs485-transceiver
sourceTitle: CAN收发器参考资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/interface/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
在 CAN 控制器逻辑电平与 CANH/CANL 差分总线间完成物理层转换。

## 工作原理
发送端产生显性/隐性差分电平，接收端按差分电压恢复逻辑信号。

## 关键参数
供电与 I/O 电平、速率、共模、待机、故障耐受、ESD 和延迟。

## 选型要点
选型时结合CAN 速率、节点电压、线长、隔离需求和 EMC，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
汽车和工业设备网络，总线物理两端通常各接匹配终端。

## 注意事项
收发器不负责协议仲裁；分支过长和地电位差会破坏通信。

## 常见故障与误区
CANH/L 反接、终端缺失或过多、电平不兼容或待机脚错误。
