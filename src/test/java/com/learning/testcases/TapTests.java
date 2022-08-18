package com.learning.testcases;

import com.learning.driver.DriverManager;
import com.learning.facade.DragDropFacade;
import com.learning.facade.FakerFacade;
import com.learning.pages.DragAndDropPageNative;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sreej
 */
public class TapTests extends BaseTest{


    @Test(dataProvider = "getData")
    public void tapTest(Map<String,String> map) throws IOException {

        new DragDropFacade().navigateToDragAndDropPage();
        String successMessage = new DragAndDropPageNative().performDragAndDrop().successMessage();
        Assertions.assertThat(successMessage).isEqualTo("Dropped!");
        FakerFacade.getBuildingNumber();
    }

    @DataProvider(parallel = true)
    public Object[] getData(){

        Map<String,String> map=new HashMap<>();
        map.put("device","Google Pixel 3");
        map.put("os_version","9.0");

//        Map<String,String> map1=new HashMap<>();
//        map1.put("device","Samsung Galaxy S10e");
//        map1.put("os_version","9.0");

        List<Map<String,String>> list=new ArrayList<>();
        list.add(map);
//        list.add(map1);

        return list.toArray();
    }

    @Test
    public void swipeTest() throws MalformedURLException {

        DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Views')]")).click();

        //String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

    }






}
