package com.sagar.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadData {
    @Test(dataProvider = "getData")
    public void readData(String fname, String lname){
        System.out.println(fname + " " + lname);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0] = "sagar";
        data[0][1] = "pooja";
        data[1][0] = "pooji";
        data[1][1] = "vidhu";
        data[2][0] = "poojasagar";
        data[2][1] = "sagarpooja";
        return data;
    }
}
