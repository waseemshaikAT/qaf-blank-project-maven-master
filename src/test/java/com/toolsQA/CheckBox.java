package com.toolsQA;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Validator;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.StringJoiner;

import static com.qmetry.qaf.automation.step.client.RuntimeScenarioFactory.scenario;
import static java.lang.Thread.sleep;

public class CheckBox extends WebDriverTestBase {

    @Test(priority = 1)
    public void openToolsQAApp(){
        scenario().given("I launch tool qa page",()->{
            getDriver().get("https://demoqa.com/checkbox");
        }).then("",()->{
            String title = getDriver().getTitle();
            Validator.verifyThat("title of the page",title, Matchers.equalTo("ToolsQA"));
        }).execute();
    }

    @Test(priority = 2)
    public void checkBox(){
        scenario().given("I am tools qa check box page",()->{
        }).when("",()-> {
            QAFExtendedWebElement toggle = new QAFExtendedWebElement(By.xpath("//button[@title='Toggle']"));
            QAFExtendedWebElement desktop = new QAFExtendedWebElement(By.xpath("//span[text()='Desktop']//ancestor::span//span[@class='rct-checkbox']"));
            QAFExtendedWebElement document = new QAFExtendedWebElement(By.xpath("//span[text()='Documents']//ancestor::span//span[@class='rct-checkbox']"));
            QAFExtendedWebElement download = new QAFExtendedWebElement(By.xpath("//span[text()='Downloads']//ancestor::span//span[@class='rct-checkbox']"));
            toggle.click();
            try {
                sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            desktop.click();
            try {
                sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            document.click();
            try {
                sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            download.click();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).then("verify",()->{
            List<WebElement> result= getDriver().findElements(By.xpath("//div[@id='result']//span"));
            StringJoiner tst = new StringJoiner(" ");
            result.forEach(element ->
                    tst.add(element.getText()));
            Validator.verifyThat("result", tst.toString(), Matchers.equalTo("You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile"));
        }).execute();
    }
}
