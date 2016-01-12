package com.praxis.bisnet.test.smoke;

import static com.praxis.bisnet.test.common.constants.GroupsConstants.SIGNON_ADMINCC;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SMOKE;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.VIAJES;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.bisnet.test.WebDriverSetup;
import com.praxis.bisnet.test.dataprovider.SmokeTestDP;
import com.praxis.bisnet.test.pages.main.LogInPage;
import com.praxis.bisnet.test.pages.main.MainPage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.AutorizarCotizacionViajePage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.AutorizarViajePage;

public class ViajesAdminCCSmokeTest extends WebDriverSetup {
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, VIAJES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON_ADMINCC)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage);
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoAutorizarViaje() {
		testCase("casoAutorizarViaje");
		MainPage mainPage = new MainPage(driver).refreshPage();
        AutorizarViajePage autorizarViajePage = mainPage.linkToAutorizarViaje();
        Assert.assertNotNull(autorizarViajePage.autorizarViaje());
        System.out.println("----------------CASO AUTORIZAR VIAJE COMPLETE---------------------"); 
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoAutorizarCotizacionViaje() {
		testCase("casoAutorizarCotizacionViaje");
		MainPage mainPage = new MainPage(driver).refreshPage();
        AutorizarCotizacionViajePage autorizarCotizacionViajePage = mainPage.linkToAutorizarCotizacionViaje();
        Assert.assertNotNull(autorizarCotizacionViajePage.autorizarCotizacionViaje());
        System.out.println("----------------CASO AUTORIZAR COTIZACION VIAJE COMPLETE---------------------"); 
	}

}
