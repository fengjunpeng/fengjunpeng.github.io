---
layout: post
title:  Collection
subtitle:   Collection
date:   2019-09-29
author: fengjp
catalog:    true
tags:
    - java
---


#   Collection

主要集中在 java.util.* 包里面。主要看 List、Set 和 Queue。

List 主要提供便捷的访问，有序的可重复的，通过索引来操作。

 Set 不允许包含重复的元素，无序的，将元素以 Key 的形式保存在 Map 中。如可以将 IP 放入 Set 中，统计访问的次数，HashSet 底层是哈希表，TreeSet 底层是二叉树。TreeSet 用到两种方法实现排序，一种是 __自然顺序__ ，对象的类实现 Comparable 接口，无参构造，另一种是比较器接口 Comparator ，带参构造
 
  Queue 主要和消息队列有关，应用于并发相关的场景。