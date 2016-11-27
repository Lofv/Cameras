
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.List;

/**
 * Created by Lofv on 25.11.2016.
 */
public class Podryad {


    public void podryadCamers() {

        File src =new File("D:/phantomjs/bin/phantomjs.exe");
        System.setProperty("phantomjs.binary.path",src.getAbsolutePath());


        WebDriver driver = new PhantomJSDriver();
        driver.get("http://live.podryad.tv/vsaas/cameras");


        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.camera-list-container")));


        By classOfCamers=By.cssSelector("div.camera.col-lg-4.col-md-6.col-sm-12.col-xs-12");
        List<WebElement> webElements= driver.findElements(classOfCamers);

        for (WebElement webElement : webElements) {




            By imgSource=By.cssSelector("img.camera-overlay");
            By videoSource=By.cssSelector("a.navbar-brand");

            String imgLink= webElement.findElement(imgSource).getAttribute("src");  //ссылка на изображение, которое генерируется для камер каждые пару секунд
            String videoLink=webElement.findElement(videoSource).getAttribute("href");//ссылка на камеру
            String nameOfCamera=webElement.findElement(videoSource).getText();//названия камер

            System.out.println(nameOfCamera);
            System.out.println(imgLink);
            System.out.println(videoLink);


        }
    }
}
