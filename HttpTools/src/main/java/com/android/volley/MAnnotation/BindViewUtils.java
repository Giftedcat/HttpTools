package com.android.volley.MAnnotation;

import android.view.View;

import java.lang.reflect.Field;

/**
 * 杭州舞环科技有限公司
 * 作者: 徐诚聪
 * 时间: 2017/5/5
 * 描述:
 */
public class BindViewUtils {

    public static void injectView(Object object, View sourceView){
        Field[] fields=object.getClass().getDeclaredFields();
        if(fields!=null&&fields.length>0){
            for(Field field:fields){
                BindView bindView=field.getAnnotation(BindView.class);
                if(bindView!=null){
                    int viewId=bindView.id();
                    field.setAccessible(true);
                    try {
                        field.set(object,sourceView.findViewById(viewId));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
