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

##  hashCode 方法

hashCode 方法作用是获得 hash 码，实际上是一个 int 型的整数，用来表示对象在散列表中的索引的位置。散列表存储的是键值对，通过键可以快速获得值。

如果两个对象相等，那么他们的 hashCode 必然相等。但是反之不一定相等。

##  equals 和 hashCode 方法

如果没有涉及到散列表，是没必要重写 hashCode 方法。

### 1、不会创建散列表的情况

就是和 hashtable hashmap hashset 没有一点关系的，重写 equals 方法就行

重写四步走

1、判空

2、判类

3、判等于

4、判内容

### 2、创建散列表情况

两个对象内容一样，但是地址不一样。用 equals 判断出来，两个对象相等，所以按理说两个对象的 hashCode 一定相等。实际上这两个对象的 hashCode 不一定相等。

重写 hashCode 可以这样，用其属性字段的 hashCode 异或其他属性字段的 hashCode 。


[https://www.cnblogs.com/skywang12345/p/3324958.html](https://www.cnblogs.com/skywang12345/p/3324958.html)