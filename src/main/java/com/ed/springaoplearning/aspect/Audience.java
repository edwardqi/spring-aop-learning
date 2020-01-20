/*
 * © Copyright 2017-2019 Micro Focus or one of its affiliates.
 *
 * The only warranties for products and services of Micro Focus and its
 * affiliates and licensors (“Micro Focus”) are as may be set forth in
 * the express warranty statements accompanying such products and services.
 * Nothing herein should be construed as constituting an additional warranty.
 * Micro Focus shall not be liable for technical or editorial errors or
 * omissions contained herein. The information contained herein is subject
 * to change without notice.
 *
 * Except as specifically indicated otherwise, this document contains
 * confidential information and a valid license is required for possession,
 * use or copying. If this work is provided to the U.S. Government, consistent
 * with FAR 12.211 and 12.212, Commercial Computer Software, Computer Software
 * Documentation, and Technical Data for Commercial Items are licensed to the
 * U.S. Government under vendor's standard commercial license.
 */
package com.ed.springaoplearning.aspect;

import org.aspectj.lang.annotation.*;

/**
 * Audience是一个切面，也是一个POJO
 */
@Aspect
public class Audience {

    @Pointcut("execution(* com.ed.springaoplearning.action.Performance.perform(..))")
    public void performance() {
    }

    /**
     * 通知方法在目标方法调用之前执行
     */
    @Before("performance()")
    public void takeSeats() {
        System.out.println("sit down");
    }

    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("keep silence");
    }

    /**
     * 通知方法在目标方法返回之后执行
     */
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("Clap!");
    }

    /**
     * 通知方法在目标方法抛出异常后执行
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("demand a refund");
    }
}
