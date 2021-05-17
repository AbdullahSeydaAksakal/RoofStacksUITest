package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;



public class Test1 {

    public static void main(String[] args) {

        // propertyleri verdik
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        // ChromeDriverı oluştur
        WebDriver driver = new ChromeDriver();
        // Bekleme oluştur
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //Google git
        driver.get("https://www.google.com/");
        // Tarayıcıyı büyüt
        driver.manage().window().maximize();
        // Search textboxını bul
        WebElement nameElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        // Roof Stack Yazılım yaz
        nameElement.sendKeys("Roof Stack Yazılım");
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/img"))).click();
        // Butona tıkla
        nameElement.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        // Elementi görene kadar bekle ve siteye  "RoofStacks" sitesine git
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#rso > div:nth-child(3) > div > div > div.yuRUbf > a > h3"))).click();
        // Görünene kadar bekle ve Kariyer sayfasına git
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/nav/div/div[2]/ul/li[4]/a"))).click();
        // Görünene kadar bekle ve Product sayfasına git
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div/div[2]/div/ul/li[2]/div/a/h4"))).click();
        // Görünene kadar bekle ve  Lead Product Tester sayfasına git
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div/div[3]/div/ul/li[3]/div/a/p"))).click();
        // Görünene Lead Product Tester yazısı gelene kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div/div/h3")));
        // Sayfanın gelip gelmediği kontrol edilir
        String actualString  = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/h3")).getText();
        String expectedString = "Lead Product Tester";
        assertTrue(actualString.contains(expectedString));
        // SendCV Butonu görene kadar bekle ve görünce tıkla
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[3]/div/div[2]/div/div[1]/div/a/h3/small"))).click();
       // Görünene kadar bekle ve  Dosya yükleme pop up'ına git
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[1]/h4"))).click();
        // Sayfanın gelip gelmediği kontrol edilir
        String ActualTrue = driver.findElement(By.xpath("/html/body/main/div[4]/div[2]/div/div[1]/h4")).getText();
        String ExpectedTrue  = "File upload form";
        assertTrue(ActualTrue.contains(ExpectedTrue));
        // Bekle ve "abdullahseydaaksakal@gmail.com" yazısı yaz
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/form/input[3]"))).sendKeys("abdullahseydaaksakal@gmail.com");
        // Bekle ve Cv ekle
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/form/input[4]"))).sendKeys("D:\\Dosyalarim\\Kendimle ilgili\\Cv\\Güncel Cv\\SeydaAksakal.pdf");
        // Bekle ve Cv yi upload et
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/form/input[5]"))).click();
        // Notificationsu görene kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
        // Cv nin yüklendiğine dair bildirimi gör
        String NotificationsActualTrue = driver.findElement(By.id("toast-container")).getText();
        String NotificationsExpectedTrue = "You have successfully upload file.";
        assertTrue(NotificationsActualTrue.contains(NotificationsExpectedTrue));
       // Sayfayı kapat
       driver.quit();

    }


}

