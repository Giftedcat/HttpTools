package com.android.volley.MAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 杭州舞环科技有限公司
 * 作者: 徐诚聪
 * 时间: 2017/5/5
 * 描述: 运行时注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    int id();
}
