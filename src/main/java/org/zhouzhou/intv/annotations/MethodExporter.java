package org.zhouzhou.intv.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//作用在方法上
@Retention(RetentionPolicy.RUNTIME)//运行时生效
public @interface MethodExporter {
}
