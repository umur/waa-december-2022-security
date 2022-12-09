package edu.miu.springsecurity1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface OffensiveWordValidation {
}
