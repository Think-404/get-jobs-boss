package org.originit.operator.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.originit.model.DriverSetting;
import org.originit.model.LoginSetting;
import org.originit.operator.ResumeSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BossResumeSub implements ResumeSub {
    @Autowired
    private DriverSetting driverSetting;
    @Autowired
    private LoginSetting loginSetting;
    private String name;
    private String path;
    private EdgeDriver driver;
    private WebDriverWait wait15s;
    private String loginUrl;
    public BossResumeSub() {
    }

    @Override
    @SneakyThrows
    public void login() {
        name = driverSetting.getName();
        path = driverSetting.getPath();
        loginUrl=loginSetting.getUrl();
        System.setProperty(name, path);
        driver= new EdgeDriver();
        wait15s = new WebDriverWait(driver, 15000);
        driver.get(loginUrl);
        //等待二维码css元素加载
        wait15s.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='btn" +
                "-sign-switch ewm-switch']")));
        //点击二维码登录
        driver.findElement(By.cssSelector("[class*='btn-sign-switch ewm-switch']")).click();
        log.info("等待登陆..");
        wait15s.until(ExpectedConditions.presenceOfElementLocated(By.className("nav-figure")));
    }

    @Override
    public ResumeSub city(String[] cities) {
        return null;
    }

    @Override
    public ResumeSub salary(int min, int max) {
        return null;
    }

    @Override
    public ResumeSub experience(String[] experiences) {
        return null;
    }

    @Override
    public ResumeSub jobType(String[] types) {
        return null;
    }

    @Override
    public ResumeSub page(int pageNum) {
        return null;
    }

    @Override
    public void startResumeSubmission() {

    }
}