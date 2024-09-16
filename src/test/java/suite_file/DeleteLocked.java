package suite_file;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClasspric;
import com.crm.pom.Pric_pom;

public class DeleteLocked extends BaseClasspric
{
	@Test
	public void delete_mesg() throws InterruptedException, IOException
	{
 
     	Pric_pom pom = new Pric_pom(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(8000);
		pom.locked.click();
		Thread.sleep(4000);
		pom.create.click();
		pom.amount.sendKeys("112");
		pom.visible_Mesg.sendKeys("Books");
		pom.preminumContent.sendKeys("The Books are Currently On A 10% Offer just grab the festivel offer");
		pom.submit.click();
		pom.delete_icon.click();
		Thread.sleep(6000);
		pom.delete_button.click();
		driver.navigate().refresh();
		
		pom.Home.click();
		
		
}

}
