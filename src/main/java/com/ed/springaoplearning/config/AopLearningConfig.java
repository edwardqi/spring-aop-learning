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
package com.ed.springaoplearning.config;

import com.ed.springaoplearning.action.CompactDisc;
import com.ed.springaoplearning.aspect.Audience;
import com.ed.springaoplearning.aspect.DiscCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// 启用AspectJ注解的自动代理，AspectJ自动代理会为使用@Aspect注解的bean创建一个代理
// XML方式 -- <aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
@ComponentScan
public class AopLearningConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public DiscCounter discCounter() {
        return new DiscCounter();
    }

    @Bean
    public CompactDisc compactDisc() {
        return new CompactDisc();
    }
}
