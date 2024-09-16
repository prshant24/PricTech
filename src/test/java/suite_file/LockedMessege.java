package suite_file;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClasspric;
import com.crm.pom.Pric_pom;
@Listeners(com.crm.listeners.Create_Locked_Mesg.class)
public class LockedMessege extends BaseClasspric
{
	@Test
	public void create_mesg() throws InterruptedException, IOException
	{
 
     	 Pric_pom pom = new Pric_pom(driver);
		 
		Thread.sleep(8000);                  
		pom.locked.click();
		Thread.sleep(4000);
		pom.create.click();
		pom.amount.sendKeys("99");
		pom.visible_Mesg.sendKeys("Books");
		pom.preminumContent.sendKeys("The Books are Currently On A 10% Offer just grab the festivel offer");
		pom.submit.click();
		pom.Home.click();
 
		
		

		
	}

}
