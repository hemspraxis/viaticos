package com.praxis.bisnet.test.smoke;

import static com.praxis.bisnet.test.common.constants.GroupsConstants.SIGNON_TESORERO;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.SMOKE;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.VIAJES;
import static com.praxis.bisnet.test.common.constants.GroupsConstants.ESTADO_CUENTA;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.bisnet.test.WebDriverSetup;
import com.praxis.bisnet.test.dataprovider.SmokeTestDP;
import com.praxis.bisnet.test.pages.main.LogInPage;
import com.praxis.bisnet.test.pages.main.MainPage;
import com.praxis.bisnet.test.pages.main.viaticos.estadoCuenta.AgregarMovimientosPage;

public class EstadoCuentaSmokeTest extends WebDriverSetup {
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, ESTADO_CUENTA}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON_TESORERO)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage); 
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoPagarAdelanto() {
		testCase("casoPagarAdelanto");
		MainPage mainPage = new MainPage(driver).refreshPage();
        AgregarMovimientosPage agregarMovimientosPage = mainPage.linkToAgregarMovimientos();
        Assert.assertNotNull(agregarMovimientosPage.agregarMovimientos());
        System.out.println("----------------CASO PAGAR ADELANTO COMPLETE---------------------"); 
	}
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, VIAJES})
	public void casoLiquidarSolicitud() {
		testCase("casoLiquidarSolicitud");
		MainPage mainPage = new MainPage(driver).refreshPage();
        AgregarMovimientosPage agregarMovimientosPage = mainPage.linkToAgregarMovimientos();
        Assert.assertNotNull(agregarMovimientosPage.liquidarSolicitud());
        System.out.println("----------------CASO LIQUIDAR SOLICITUD COMPLETE---------------------"); 
	}
}
