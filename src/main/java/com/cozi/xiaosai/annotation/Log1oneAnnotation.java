package com.cozi.xiaosai.annotation;

import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.enums.OperationObjects;
import com.cozi.xiaosai.enums.OperationType;
import org.omg.CORBA.UNKNOWN;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiaosai
 * @Date 2019-12-11 14:22
 * @Version 1.0
 */

/**
 * 注解使用说明：此注解主要是为了日志管理建立
 * 注意：
 * 1.使用在controller层的方法上
 * 2.方法的参数中必须包含HttpServletRequest request,[为了能获取到请求中的token]
 * 3.只能用于登陆以后
 */

@Target({ElementType.METHOD}) // 作用在方法上
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented // 说明该注解将被包含在javadoc中
public @interface Log1oneAnnotation {

    OperationType operationType()default OperationType.UNKNOWN;//操作类型

    OperationObjects operands()default OperationObjects.UNKNOWN;//操作对象

    String msg()default "";//操作描述
}
