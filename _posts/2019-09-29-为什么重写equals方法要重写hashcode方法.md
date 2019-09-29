---
layout: post
title: 为什么重写equals方法要重写hashcode方法
subtitle: 奇技淫巧
date: 2019-09-29
author: fengjp
catalog: true
tags:
    - 
---

#   为什么重写equals方法要重写hashcode方法


##  equals 方法

在 Object 类中，实现了一个 equals() 方法，这个方法用来判定两个对象是否相等。但仔细看这个类，实际上是比较 __两个对象的地址是否一样__ 。

equals() 方法

1、在没有重写时，用于比较两个对象的内存地址是否相等  
2、在子类重写后，可按照开发者意愿来比较两个对象是否一致。

```java
@Override
public boolean equals(Object obj){
    // 判空
    if(obj == null){  
        return false;  
    }
        
    // 比较内存地址
    if(this == obj){  
        return true;  
    }  

    // 判断类型是否一致
    if(this.getClass() != obj.getClass()){
        return false;
    }  
    // 比较对象的属性是否一致
    Person person = (Person)obj;
    return name.equals(person.name) && age==person.age;
} 
```






[https://www.cnblogs.com/skywang12345/p/3324958.html](https://www.cnblogs.com/skywang12345/p/3324958.html)