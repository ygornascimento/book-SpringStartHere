package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect /* @Aspect annotation isn't a stereotype annotation. Using @Aspect, you tell Spring that the class implements
the definition of an aspect, but Spring won't also create a bean for this class. You need explicitly use one of the
syntaxes to create a bean for your class and allow Spring to manage it this way.*/
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))") // Defines which are the intercepted methods
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute."); // Prints a message in the console before the intercepted method's execution.
        joinPoint.proceed(); // Delegates to the actual intercepted method. Calls the intercepted method.
        logger.info("Method executed."); // Prints a message in the console after the intercepted method's execution.
    }
}
