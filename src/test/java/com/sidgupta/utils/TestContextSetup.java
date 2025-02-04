package com.sidgupta.utils;

import com.sidgupta.BaseTest;

import java.net.MalformedURLException;

public class TestContextSetup {

    public BaseTest baseTest;
    public PageObjectManager pageObjectManager;

    public TestContextSetup() throws MalformedURLException {
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.getDriver());
    }

}
