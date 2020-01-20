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

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class DiscCounter {

    private Map<Integer, Integer> discCounts = new HashMap<>();

    @Pointcut("execution(* com.ed.springaoplearning.action.CompactDisc.playDisc(int)) && args(discNumber)")
    public void playDisc(int discNumber) {
    }

    @Before("playDisc(discNumber)")
    public void countDisc(int discNumber) {
        int currentCount = discCounts.get(discNumber);
        discCounts.put(discNumber, currentCount + 1);
    }

    public int getCounts(int discNumber) {
        return discCounts.containsKey(discNumber) ? discCounts.get(discNumber) : 0;
    }
}
