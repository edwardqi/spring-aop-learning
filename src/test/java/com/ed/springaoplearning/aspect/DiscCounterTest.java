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

import com.ed.springaoplearning.action.CompactDisc;
import com.ed.springaoplearning.config.AopLearningConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopLearningConfig.class)
public class DiscCounterTest {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private DiscCounter counter;

    @Test
    public void testDiscCounter() {
        compactDisc.playDisc(11);
        compactDisc.playDisc(11);
        compactDisc.playDisc(22);
        compactDisc.playDisc(33);
        compactDisc.playDisc(33);
        compactDisc.playDisc(33);
        compactDisc.playDisc(33);
        Assert.assertEquals(2, counter.getCounts(11));
    }
}
