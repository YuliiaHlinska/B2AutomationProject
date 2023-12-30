package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportContains;
import com.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T00_login_docuport extends TestBase {

    @Test
    public void test_login_docuport() throws InterruptedException {
        DocuportUtils.login(driver, DocuportContains.CLIENT);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportContains.ADVISOR);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportContains.EMPLOYEE);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportContains.SUPERVISOR);
        DocuportUtils.logOut(driver);

    }




}
