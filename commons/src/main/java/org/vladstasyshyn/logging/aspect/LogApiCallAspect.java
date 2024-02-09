package org.vladstasyshyn.logging.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vladstasyshyn.logging.document.ApiCallDocument;
import org.vladstasyshyn.logging.implementation.LogApiCall;
import org.vladstasyshyn.logging.repository.ApiCallRepository;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class LogApiCallAspect {

    @Autowired
    private ApiCallRepository repository;

    @Around("@annotation(apiCall)")
    public Object logApiCallInfo(ProceedingJoinPoint joinPoint, LogApiCall apiCall) throws Throwable {
        Object result;
        long startTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            ApiCallDocument document = new ApiCallDocument()
                    .setExecutionTimestamp(LocalDateTime.now())
                    .setExecutionTimeMs(executionTime)
                    .setMethodName(joinPoint.getSignature().getName())
                    .setClassName(joinPoint.getSignature().getDeclaringTypeName());

            repository.insert(document);
        }

        return result;
    }

}
