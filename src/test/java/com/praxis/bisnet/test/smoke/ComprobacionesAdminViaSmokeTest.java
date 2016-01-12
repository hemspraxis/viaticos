package com.praxis.bisnet.test.smoke;

import static com.praxis.bisnet.test.common.constants.GroupsConstants.COMPROBACIONES;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SIGNON_ADMINVIA;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SMOKE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.bisnet.test.WebDriverSetup;
import com.praxis.bisnet.test.dataprovider.SmokeTestDP;
import com.praxis.bisnet.test.pages.main.LogInPage;
import com.praxis.bisnet.test.pages.main.MainPage;
import com.praxis.bisnet.test.pages.main.viaticos.comprobaciones.MisComprobacionesPage;
import com.praxis.bisnet.test.pages.main.viaticos.comprobaciones.AutorizarComprobacionPage;

public class ComprobacionesAdminViaSmokeTest extends WebDriverSetup  {

	@Test(enabled = true, priority = 1, groups = {SMOKE, COMPROBACIONES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON_ADMINVIA)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage); 
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, COMPROBACIONES})
	public void casoAprobarComprobacion() {
        testCase("casoAprobarComprobacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
        AutorizarComprobacionPage autorizarComprobacionPage = mainPage.linkToAutorizarComprobacion();
        Assert.assertNotNull(autorizarComprobacionPage.autorizarComprobacion());
        System.out.println("----------------CASO APROBAR COMPROBACION COMPLETE---------------------");
	}
}
