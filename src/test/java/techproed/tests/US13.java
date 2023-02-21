package techproed.tests;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePageUS13;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US13 {
    @Test
    public void pozitiveTestUS13TC1() throws IOException, InterruptedException {
        techproed.utilities.ReusableMethods.loginSingIn("fermin.kymoni@foundtoo.com", "@Abc123");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        HomePageUS13 homePage = new HomePageUS13();
        homePage.myAccount.click();
        techproed.utilities.ReusableMethods.waitFor(2);

       // ReusableMethods.clickByJS(homePage.adresses);
      //  ReusableMethods.waitFor(2);

     //   ReusableMethods.clickByJS(homePage.addButonu);
     //   ReusableMethods.waitFor(2);


        homePage.adresses.click();
        ReusableMethods.waitFor(2);

        homePage.addButonu.click();
        ReusableMethods.waitFor(2);

        homePage.firstName.sendKeys(ConfigReader.getProperty("firstName"));
        ReusableMethods.waitFor(2);

        homePage.lastName.sendKeys(ConfigReader.getProperty("lastName"));
        ReusableMethods.waitFor(2);

        Select select = new Select(homePage.country);
        select.selectByVisibleText("Germany");
        ReusableMethods.waitFor(2);

        homePage.streetAddress.sendKeys(ConfigReader.getProperty("streetAddress"));
        ReusableMethods.waitFor(2);

        homePage.townCity.sendKeys(ConfigReader.getProperty("townCity"));
        ReusableMethods.waitFor(2);

        select.selectByVisibleText("Bremen");
        ReusableMethods.waitFor(2);

        homePage.postCode.sendKeys(ConfigReader.getProperty("postCode"));
        ReusableMethods.waitFor(2);


        Assert.assertEquals(homePage.accountChangeMessage.getText(), "Address changed successfully.");
        ReusableMethods.getScreenshot("Pozitif");
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }

}


