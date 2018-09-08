package com.kvn.blade.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 附加参数
 * 
 * @author wzy
 * @date 2017年11月14日 下午3:52:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Addition {
	String value();
}