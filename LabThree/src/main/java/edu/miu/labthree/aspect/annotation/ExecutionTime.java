package edu.miu.labthree.aspect.annotation;

import edu.miu.labthree.service.ActivityLogService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface  ExecutionTime {


}
