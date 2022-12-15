package miu.edu.springsecuritylab6.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface OffensiveWord {
}
