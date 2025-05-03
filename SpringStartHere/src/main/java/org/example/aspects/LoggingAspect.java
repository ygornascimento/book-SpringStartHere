package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.model.Comment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect /* @Aspect annotation isn't a stereotype annotation. Using @Aspect, you tell Spring that the class implements
the definition of an aspect, but Spring won't also create a bean for this class. You need explicitly use one of the
syntaxes to create a bean for your class and allow Spring to manage it this way.*/
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))") // Defines which are the intercepted methods
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Obteins the name and parameters of the intercepted method.
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        // Logs the name and parameters of the intercepted method.
        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute.");

        // Calls the intercepted method. We send a different comment instance as a value to the method's parameter.
        Comment comment = new Comment();
        comment.setText("Some other text!");
        Object[] newArguments = {comment};
        Object returnedByMethod = joinPoint.proceed(newArguments);

        logger.info("Method executed and returned " + returnedByMethod);

        // Returns the value returned by the intercepted method.
        return "FAILED";
    }
}
