package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setup() throws MalformedURLException {
//        System.out.println("=== Memulai Session Baru ===");
        DriverManager.initializeDriver();
    }

    @After
    public void teardown() {
//        System.out.println("=== Menutup Session ===");
        DriverManager.quitDriver();
    }
}