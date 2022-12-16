// package edu.miu.springsecurity1.aop;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;

// import javax.servlet.http.HttpServletRequest;

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.stereotype.Component;

// import lombok.RequiredArgsConstructor;

// @Aspect
// @Component
// @RequiredArgsConstructor
// public class WaaOffensiveWords {

//     private final HttpServletRequest httpServletRequest;

//     @Pointcut("@within(edu.miu.springsecurity1.controller)")
//     public void allMethodsOfControllerPackage() {};

//     @Around("allMethodsOfControllerPackage()")
//     public Object filterOffensiveWords(ProceedingJoinPoint pjoinpoint) {
//         if (httpServletRequest.getMethod().equals("POST") || httpServletRequest.getMethod().equals("PUT")) {
//             try {
//                 BufferedReader reader = httpServletRequest.getReader();
//                 String bodyOfRequest = reader.lines().collect(Collectors.joining());

//                 if (bodyOfRequest.contains("spring")) {
//                     String replaced = bodyOfRequest.replace("spring", "******");
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//                 System.out.println(e.getMessage());
//             }
//         }
//         return null;
//     }

// }
