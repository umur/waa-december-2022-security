package com.miu.springsecurity.aspects.offensivewords;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface OffensiveWordFilter {
}
