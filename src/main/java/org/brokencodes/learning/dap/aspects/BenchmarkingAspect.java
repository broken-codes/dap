package org.brokencodes.learning.dap.aspects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.brokencodes.learning.dap.annotations.Benchmark;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class BenchmarkingAspect {

    private final StopWatch stopWatch;

    @Around("@annotation(benchmark)")
    public void benchmark(ProceedingJoinPoint proceedingJoinPoint, Benchmark benchmark) throws Throwable {

        stopWatch.start();
        proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.info("Total time taken for running the algorithm: {}", stopWatch.getTotalTimeSeconds());
    }

}
