package com.example.selenium.setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InstanciarPagina {

    public ChromeDriver gerarPagina(String path) {
        // MODIFICAR CAMINHO DO DRIVER
        System.setProperty("webdriver.chrome.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver chrome = new ChromeDriver(options);
        chrome.get(path);
        return chrome;
    }
}
