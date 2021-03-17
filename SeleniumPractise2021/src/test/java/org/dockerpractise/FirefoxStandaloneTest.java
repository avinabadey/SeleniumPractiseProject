package org.dockerpractise;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxStandaloneTest {

    public static void main(String []args){
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
        capabilities.setCapability("browserName", "firefox");
        RemoteWebDriver remoteWebdriver = new RemoteWebDriver(url, capabilities);
        remoteWebdriver.get("http://www.google.com");
        System.out.println(remoteWebdriver.getTitle());

    }

}
