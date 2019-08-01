package com.sgic.automation.orangehrm.TestData;

import com.sgic.automation.orangehrm.utils.ExcelDataConfig;
import com.sgic.automation.orangehrm.utils.PageBase;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class LoginJPData extends ExcelDataConfig {
    private static final Logger LOGGER = Logger.getLogger(LoginJPData.class);
    public LoginJPData() {super
            ("src\\test\\resources\\ExcelSheet\\OrangeHrm.xlsx");

    }
    @DataProvider(name = "loginValid")
    public Object[][] loginValid() {

        int rows = getRowCount("loginValid");
        int col = getColumnCount("loginValid");

        LOGGER.info("row = "+ rows + " columns = "+ col);

        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = getData("loginValid", i, j);
            }
        }
        return data;
    }
}
