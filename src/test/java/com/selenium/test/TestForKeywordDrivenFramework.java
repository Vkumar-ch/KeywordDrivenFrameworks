package com.selenium.test;

import com.selenium.base.BaseClass;
import com.selenium.base.keyword.KeywordEngine;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestForKeywordDrivenFramework extends BaseClass {
    @Test
    public void keywordDrivenForInsta() throws IOException {
        KeywordEngine keywordEngine = new KeywordEngine();
        keywordEngine.keywordEngineExecute();
    }

}
