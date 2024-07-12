package com.och.common.annotation;


import com.och.common.enums.ProcessEnum;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EslProcessName {

    ProcessEnum value();
}
