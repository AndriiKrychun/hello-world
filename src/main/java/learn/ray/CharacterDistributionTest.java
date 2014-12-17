package learn.ray;
//package com.serg.bloim;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//import tasks.LeapYear;


public class CharacterDistributionTest {

    CharacterDistribution characterDistribution;

    @Before
    public void setUp() throws Exception {
        characterDistribution = new CharacterDistribution();
    }

    @Test
    public void testGetDistribution() throws Exception {
        Map<Character, Integer> expectedCharDistr = new HashMap<>();
        expectedCharDistr.put('d', 3);
        expectedCharDistr.put('a', 4);
        expectedCharDistr.put('s', 4);
        Map<Character, Integer> actualCharDistr = characterDistribution.getDistribution("asdaddsssaa");
        Assert.assertEquals(expectedCharDistr, actualCharDistr);
    }
}