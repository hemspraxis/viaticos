package com.praxis.bisnet.test.smoke;

import static com.praxis.bisnet.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SMOKE;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.COMPROBACIONES;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.bisnet.test.WebDriverSetup;
import com.praxis.bisnet.test.dataprovider.SmokeTestDP;
import com.praxis.bisnet.test.pages.main.LogInPage;
import com.praxis.bisnet.test.pages.main.MainPage;
import com.praxis.bisnet.test.pages.main.viaticos.comprobaciones.MisComprobacionesPage;

public class ComprobacionesEmpleadoSmokeTest extends WebDriverSetup {

	@Test(enabled = true, priority = 1, groups = {SMOKE, COMPROBACIONES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage);
        System.out.println("----------------SIGN ON COMPLETE---------------------");  
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, COMPROBACIONES})
	public void casoAgregarComprobacion() {
        testCase("casoAgregarComprobacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
        MisComprobacionesPage misComprobacionesPage = mainPage.linkToMisComprobaciones();
        Assert.assertNotNull(misComprobacionesPage.agregarComprobantes());
        System.out.println("----------------CASO AGREGAR COMPROBACION COMPLETE---------------------");
	}
}
