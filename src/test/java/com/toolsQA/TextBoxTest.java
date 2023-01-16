package com.toolsQA;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.step.client.RuntimeScenarioFactory.scenario;

public class TextBoxTest extends WebDriverTestCase {

    //web u = new WebUtilities();


    QAFWebElement fullName = new QAFExtendedWebElement(By.xpath("//input[@id='userName']"));
    QAFWebElement email = new QAFExtendedWebElement(By.xpath("//input[@id='userEmail']"));
    QAFWebElement currentAddress = new QAFExtendedWebElement(By.xpath("//textarea[@id='currentAddress']"));
    QAFWebElement PermanentAddress = new QAFExtendedWebElement(By.xpath("//textarea[@id='permanentAddress']"));
    QAFWebElement SubmitButton = new QAFExtendedWebElement(By.xpath("//button[@id='submit']"));

    QAFWebElement verifyfullName = new QAFExtendedWebElement(By.xpath("//p[@id='name']"));
    QAFWebElement verifyemail = new QAFExtendedWebElement(By.xpath("//p[@id='email']"));
    QAFWebElement verifycurrentAddress = new QAFExtendedWebElement(By.xpath("//p[@id='currentAddress']"));
    QAFWebElement verifyPermanentAddress = new QAFExtendedWebElement(By.xpath("//p[@id='permanentAddress']"));
    QAFWebElement verifyTitle = new QAFExtendedWebElement(By.xpath("//title[text()='ToolsQA']"));

    @Test(priority = 1)
    public void openToolQAapplication(){
        scenario().given("I launch tool QA page",()->{
            getDriver().get("https://demoqa.com/text-box");
        }).then("I verify page",()->{
            String title = getDriver().getTitle();
            Validator.verifyThat("title of the page",title, Matchers.equalTo("ToolsQA"));
        }).execute();
    }

    @Test(priority = 2)
    public void textboxForm(){

    scenario().given("I am tools qa text box page",()->{

    }).when("",()->{
        fullName.sendKeys("waseem shaik");
        email.sendKeys("shaik@gmail.com");
        currentAddress.sendKeys("3-4-358, gandhi nagar");
        PermanentAddress.sendKeys("same as current address");
        SubmitButton.click();
        try {
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }).then("",()->{

    }).execute();

    }
}
