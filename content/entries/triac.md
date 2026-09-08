---
id: triac
kind: category
title: 双向晶闸管
englishName: TRIAC
aliases: TRIAC|triac
categoryId: semiconductor
summary: 双向可控硅可在交流两个半周触发导通，常用于交流功率控制。
keywords: 调光|加热|风机调速和固态继电器输出
image: images/semiconductor.svg
imageAlt: 双向晶闸管分类示意图
imageAttribution: 电子专业知识库项目自绘
imageLicense: CC-BY-4.0
relatedIds: scr|solid-state-relay
sourceTitle: 双向晶闸管官方技术资料
sourcePublisher: Nexperia
sourceUrl: https://www.nexperia.com/products
sourceAccessedAt: 2026-09-07
---
## 简介
双向可控硅可在交流两个半周触发导通，常用于交流功率控制。

## 工作原理
门极触发后主端子间锁存导通，电流过零并低于维持电流时关断。

## 关键参数
重复耐压、通态电流、浪涌、门极灵敏度、保持电流、dv/dt 和换相。

## 选型要点
选型时结合交流峰值、负载类型、触发象限、散热和 EMI，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
调光、加热、风机调速和固态继电器输出。

## 注意事项
感性负载换相困难，需吸收网络；控制市电必须隔离并满足安规。

## 常见故障与误区
dv/dt 误触发、保持电流不足闪烁、象限触发不当或散热差。
