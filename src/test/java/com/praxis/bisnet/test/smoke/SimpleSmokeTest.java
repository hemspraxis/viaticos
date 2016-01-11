package com.praxis.bisnet.test.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.praxis.bisnet.test.WebDriverSetup;
import com.praxis.bisnet.test.dataprovider.SmokeTestDP;
import com.praxis.bisnet.test.pages.main.LogInPage;
import com.praxis.bisnet.test.pages.main.MainPage;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SMOKE;

public class SimpleSmokeTest extends WebDriverSetup {
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, SIGNON}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage);
        System.out.println("----------------SIGN ON COMPLETE---------------------");  
	}
}
 