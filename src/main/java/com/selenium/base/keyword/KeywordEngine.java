package com.selenium.base.keyword;

import com.selenium.base.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class KeywordEngine extends BaseClass {
    public Workbook book;
    WebElement element;
    public Sheet sheet;
    public String instaScenario = "C:\\Users\\hp\\IdeaProjects\\KeywordDrivenFrameworks\\src\\main\\resources\\insta_sheet.xlsx";

    public void keywordEngineExecute() throws IOException, FileNotFoundException,RuntimeException {
        FileInputStream file = new FileInputStream(instaScenario);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet("Login");
        int k = 0;
        String locatorType = null;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
            String locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
            String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
            String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
        }
        switch (locatorType){
            case "id" :
                element = driver.findElement(By.id(locatorValue));
                if (action.equalsIgnoreCase("sendkeys")){
                    element.sendKeys(value);
                } else if (action.equalsIgnoreCase("click")) {
                    element.click();
                }else if (action.equalsIgnoreCase("isDisplayed")){
                    element.isDisplayed();
                }
                locatorType = null;
                break;
            case "xpath" :
                element = driver.findElement(By.xpath(locatorValue));
                if (action.equalsIgnoreCase("sendkeys")){
                    element.sendKeys(value);
                } else if (action.equalsIgnoreCase("click")) {
                    element.click();
                }else if (action.equalsIgnoreCase("isDisplayed")){
                    element.isDisplayed();
                }
                locatorType = null;
                break;
            default: break;
        }

    }
}
