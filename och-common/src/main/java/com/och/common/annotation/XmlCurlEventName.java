package com.och.common.annotation;

import java.lang.annotation.*;

/**
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XmlCurlEventName {

    String value();
}
