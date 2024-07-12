
package com.och.common.annotation;


import com.och.common.enums.RouteTypeEnum;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EslRouteName {

    RouteTypeEnum value();
}
