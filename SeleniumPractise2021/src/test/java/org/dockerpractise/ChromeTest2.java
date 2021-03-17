package org.dockerpractise;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest2 {

    @Test
    public void test2(){
        URL url = null;

        {
            try {
                url = new URL("http://localhost:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
//        ChromeOptions chromeOptions = new ChromeOptions();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        RemoteWebDriver remoteWebdriver = new RemoteWebDriver(url, capabilities);
        remoteWebdriver.get("http://www.gmail.com");
        System.out.println(remoteWebdriver.getTitle());

    }

}
