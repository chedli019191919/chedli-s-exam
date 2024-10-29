package tn.esprit.eventsproject.configtest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import tn.esprit.eventsproject.config.PerformanceAspect;


public class TestPerformanceAspect {
    private PerformanceAspect performanceAspect;
    private ProceedingJoinPoint pjp;
  @BeforeEach
    public void setUp(){
      performanceAspect = new PerformanceAspect();
      pjp = mock(ProceedingJoinPoint.class);

    }
    @Test
    public void testProfile() throws Throwable {

        Object expectedValue = "result";
        when(pjp.proceed()).thenReturn(expectedValue);
        when(pjp.getSignature()).thenReturn(mock(org.aspectj.lang.Signature.class));


        Object result = performanceAspect.profile(pjp);


        assertEquals(expectedValue, result);
        verify(pjp).proceed();
    }

}
