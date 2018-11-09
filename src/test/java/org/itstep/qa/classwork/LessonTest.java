package org.itstep.qa.classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LessonTest {

    WebDriver driver;

    @BeforeClass
    public void initSebdriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void startUp(){
        driver.navigate().to("http://hflabs.github.io/suggestions-demo/");
    }

    @AfterClass
    public void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void openPageTest(){
        //проверка открытия сайта
        WebElement pageHeader = driver.findElement(By.cssSelector(".page-header"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Не найден заголовок страницы");
    }

    @Test
    public void sendMessageTest() {
        //проверка открытия сайта
        WebElement pageHeader = driver.findElement(By.cssSelector(".page-header"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Не найден заголовок страницы");
        //находим и заполняем поле Фамилия
        WebElement field = driver.findElement(By.id("fullname-surname"));
        field.sendKeys("Петров");
        //находим и заполняем поле Имя
        field = driver.findElement(By.id("fullname-name"));
        field.sendKeys("Пётр");
        //находим и заполняем поле Отчество
        field = driver.findElement(By.id("fullname-patronymic"));
        field.sendKeys("Петрович");
        //находим и заполняем поле Емейл
        field = driver.findElement(By.id("email"));
        field.sendKeys("reg@reg.ru");
        //находим и заполняем поле Сообщения
        field = driver.findElement(By.id("message"));
        field.sendKeys("123jjh");
        //находим и нажимаем на кнопку Отправить
        field = driver.findElement(By.xpath("//*[@id=\"feedback-form\"]/div[5]/button"));
        field.click();
        //проверяем на результат
        //добавляем ожидание
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement feedback = driver.findElement(By.id("feedback-message"));
        Assert.assertTrue(feedback.isDisplayed(), "Не найден результат отправки сообщения");
        WebElement feedbackButton = driver.findElement(By.xpath("//*[@id=\"feedback-message\"]/p[2]/button"));
        Assert.assertTrue(feedbackButton.isDisplayed(), "Не найдена кнопка в результате");
        String controlValue = "Хорошо, я понял";
        Assert.assertEquals(feedbackButton.getText(), controlValue, "Текст в кнопке не соответствует = " +controlValue);

    }
}
