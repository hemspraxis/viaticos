package com.praxis.bisnet.test.smoke;

import static com.praxis.bisnet.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SMOKE;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.VIAJES;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.bisnet.test.WebDriverSetup;
import com.praxis.bisnet.test.dataprovider.SmokeTestDP;
import com.praxis.bisnet.test.pages.main.LogInPage;
import com.praxis.bisnet.test.pages.main.MainPage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.MisViajesPage;

public class ViajesEmpleadoSmokeTest extends WebDriverSetup {
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, VIAJES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage);
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoAgregarViajeSencillo() {
        testCase("casoAgregarViajeSencillo");
		MainPage mainPage = new MainPage(driver).refreshPage();
        MisViajesPage misViajesPage = mainPage.linkToMisViajes();
        Assert.assertNotNull(misViajesPage.agregarViajeSencillo());
        Assert.assertNotNull(misViajesPage.solicitarViaje());
        System.out.println("----------------CASO AGREGAR VIAJE SENCILLO COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoAgregarViajeRedondo() {
        testCase("casoAgregarViajeRedondo");
		MainPage mainPage = new MainPage(driver).refreshPage();
        MisViajesPage misViajesPage = mainPage.linkToMisViajes();
        Assert.assertNotNull(misViajesPage.agregarViajeRedondo());
        Assert.assertNotNull(misViajesPage.solicitarViaje());
        System.out.println("----------------CASO AGREGAR VIAJE REDONDO COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoAgregarViajeMultiDestino() {
        testCase("casoAgregarViajeMultiDestino");
		MainPage mainPage = new MainPage(driver).refreshPage();
        MisViajesPage misViajesPage = mainPage.linkToMisViajes();
        Assert.assertNotNull(misViajesPage.agregarViajeMultiDestino());
        Assert.assertNotNull(misViajesPage.solicitarViaje());
        System.out.println("----------------CASO AGREGAR VIAJE MULTIDESTINO COMPLETE---------------------");
	}
	
}
