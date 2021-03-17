package org.dockerpractise;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest1 {

    @BeforeTest
    public void setup(){
        try {
            DockerUtil.startDocker();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown(){
        try {
            DockerUtil.stopDocker();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
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
        remoteWebdriver.get("http://www.google.com");
        System.out.println(remoteWebdriver.getTitle());

    }

}
