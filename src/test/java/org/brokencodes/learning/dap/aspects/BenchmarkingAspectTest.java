package org.brokencodes.learning.dap.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.brokencodes.learning.dap.annotations.Benchmark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.StopWatch;

import static org.mockito.Mockito.*;

class BenchmarkingAspectTest {

    @InjectMocks
    private BenchmarkingAspect sut;

    @Mock
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void benchmark() throws Throwable {

        ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
        when(pjp.proceed()).thenReturn(new Object());
        doNothing().when(stopWatch).start();
        doNothing().when(stopWatch).stop();
        when(stopWatch.getTotalTimeSeconds()).thenReturn(Double.valueOf("10"));
        Benchmark benchmark = mock(Benchmark.class);

        sut.benchmark(pjp, benchmark);

        verify(stopWatch, times(1)).start();
        verify(stopWatch, times(1)).stop();
        verify(stopWatch, times(1)).getTotalTimeSeconds();

    }

}