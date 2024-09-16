package suite_file;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.BaseClass.AmountRandomNumber;
import com.crm.BaseClass.BaseClasspric;
import com.crm.pom.Pric_pom;

public class Edge_Error_Handling extends BaseClasspric
{
	@Test
	public void error_handle() throws InterruptedException, IOException
	{
		 
     	 Pric_pom pom = new Pric_pom(driver);
		Thread.sleep(8000);
		pom.locked.click();
		Thread.sleep(4000);
		pom.create.click();
		int no = AmountRandomNumber.random(); 
		String val = String.valueOf(no);
		pom.amount.sendKeys(val);
		pom.visible_Mesg.sendKeys("Books");
		pom.preminumContent.sendKeys("The Book are Currently On A 10% Offer just grab the festivel offer");
		pom.submit.click();
		Thread.sleep(3000);
		assertTrue(pom.price.getText().contains(val),"verifyed");
		
		pom.Home.click();
		
}

}
