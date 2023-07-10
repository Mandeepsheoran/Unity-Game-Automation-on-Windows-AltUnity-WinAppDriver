package org.igt.pompages;

import org.igt.drivers.Driver;

import com.alttester.AltDriver;

public class BasePage {
    private AltDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public AltDriver getDriver() {
        return driver;
    }

    public void setDriver() {
        this.driver = Driver.getDriver();
    }
}
