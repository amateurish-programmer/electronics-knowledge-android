---
id: watchdog
kind: category
title: 看门狗定时器
englishName: Watchdog Timer
aliases: Watchdog Timer|watchdog
categoryId: digital-control
summary: 看门狗在软件未按时喂狗时复位或告警，用于恢复失控系统。
keywords: 嵌入式控制器死机恢复|任务监控和安全状态切换
image: images/digital-control.svg
imageAlt: 看门狗定时器分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: mcu|stm32f103
sourceTitle: 看门狗定时器官方技术资料
sourcePublisher: STMicroelectronics
sourceUrl: https://www.st.com/en/microcontrollers-microprocessors.html
sourceAccessedAt: 2026-09-07
---
## 简介
看门狗在软件未按时喂狗时复位或告警，用于恢复失控系统。

## 工作原理
独立计时器在服务窗口内未收到规定序列就产生复位，窗口型还能检测过早喂狗。

## 关键参数
超时时间、窗口、时钟独立性、复位脉宽、启动状态和故障输出。

## 选型要点
选型时结合故障恢复时间、独立性、窗口需求、低功耗和外部/内部方案，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
嵌入式控制器死机恢复、任务监控和安全状态切换。

## 注意事项
喂狗应由健康检查汇总触发，不能在无条件循环或中断中机械执行。

## 常见故障与误区
启动耗时超限、调试时反复复位、所有任务未纳入健康检查或时钟源同故障。
