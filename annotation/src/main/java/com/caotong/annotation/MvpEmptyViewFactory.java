package com.caotong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)//编译期 注解
@Target(ElementType.TYPE)//类 接口 注解
public @interface MvpEmptyViewFactory {
}
