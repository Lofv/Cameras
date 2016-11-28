import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lofv on 25.11.2016.
 */
public class Podryad {
    final static String url = "http://live.podryad.tv/";
    static ArrayList<String> imgLinks = new ArrayList<String>();
    static ArrayList<String> videoLinks = new ArrayList<String>();
    static ArrayList<String> nameOfCameras = new ArrayList<String>();
    static String imgLink;
    static String videoLink;
    static String nameOfCamera;
    static By imgSource = By.cssSelector("img.camera-overlay");
    static By videoSource = By.cssSelector("a.navbar-brand");
    static By classOfCamers = By.cssSelector("div.camera.col-lg-4.col-md-6.col-sm-12.col-xs-12");


    public static void podryadCamers() {

//        File src = new File("D:/phantomjs/bin/phantomjs.exe");
        File src = new File("C:/Develops/phantomjs/bin/phantomjs.exe");
        System.setProperty("phantomjs.binary.path", src.getAbsolutePath());

        WebDriver driver = new PhantomJSDriver();
        driver.get(url+"vsaas/cameras");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.camera-list-container")));

        List<WebElement> webElements = driver.findElements(classOfCamers);

        for (WebElement webElement : webElements) {

            imgLink = webElement.findElement(imgSource).getAttribute("src");  //ссылка на изображение, которое генерируется для камер каждые пару секунд
            videoLink = webElement.findElement(videoSource).getAttribute("href");//ссылка на камеру
            nameOfCamera = webElement.findElement(videoSource).getText();//названия камер


            imgLinks.add(imgLink);
            videoLinks.add(videoLink);
            nameOfCameras.add(nameOfCamera);

        }

        driver.close(); // после отладки, надо будет перенести это в finally  JavaFX. Чтобы если вдруг будет ошибка, то соединение все равно закрывалось и не жрало память
    }


    public static ArrayList<String> getNameOfCameras() {
        return nameOfCameras;
    }

    public static ArrayList<String> getImgLinks() {
        return imgLinks;
    }

    public static ArrayList<String> getVideoLinks() {
        return videoLinks;
    }


}
