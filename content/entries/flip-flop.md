---
id: flip-flop
kind: category
title: 触发器
englishName: Flip-Flop
aliases: Flip-Flop|flip-flop
categoryId: digital-control
summary: 触发器保存一位数字状态，是寄存器、计数器和状态机的基础。
keywords: 数据寄存|同步|分频|计数和状态保存
image: images/digital-control.svg
imageAlt: 触发器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: counter|logic-gate
sourceTitle: 触发器参考资料
sourcePublisher: Texas Instruments
sourceUrl: https://www.ti.com/logic-voltage-translation/overview.html
sourceAccessedAt: 2026-09-07
---
## 简介
触发器保存一位数字状态，是寄存器、计数器和状态机的基础。

## 工作原理
交叉反馈逻辑形成两个稳定状态，并在时钟或控制条件满足时更新。

## 关键参数
类型、触发边沿、建立保持时间、时钟频率、异步置位复位和延迟。

## 选型要点
选型时结合功能类型、时序裕量、逻辑电平、复位需求和亚稳态指标，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
数据寄存、同步、分频、计数和状态保存。

## 注意事项
异步输入进入时钟域需同步；建立保持违例可能导致亚稳态。

## 常见故障与误区
时钟与数据时序不足、异步端悬空、复位极性错误或门控时钟产生毛刺。
