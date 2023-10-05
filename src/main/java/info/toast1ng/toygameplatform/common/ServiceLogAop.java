package info.toast1ng.toygameplatform.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLogAop {
    @Before("execution(* info.toast1ng.toygameplatform.*.application.service.*.*(..))")
    public void beforeParameterLog(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();
        builder.append(joinPoint.getTarget().getClass().getSimpleName()).append(".");
        builder.append(joinPoint.getSignature().getName()).append("(");

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            builder.append(arg).append(",");
        }

        builder.append(")");
        log.info(builder.toString());
    }

}
