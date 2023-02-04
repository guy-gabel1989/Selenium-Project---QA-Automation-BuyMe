package BaseFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance()  {

        if (driver == null){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }
            return driver;
    }

    private static String getData (String keyName) throws Exception{
        File fXmlFile = new File("C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Automation test-BuyMe\\src\\main\\resources\\Data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
