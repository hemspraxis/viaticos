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
import com.praxis.bisnet.test.pages.main.viaticos.estadoCuenta.AgregarMovimientosPage;

public class EstadoCuentaEmpleadoSmokeTest extends WebDriverSetup {

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
	public void casoAjustarPago() {
		testCase("casoAjustarPago");
		MainPage mainPage = new MainPage(driver).refreshPage();
        AgregarMovimientosPage agregarMovimientosPage = mainPage.linkToAgregarMovimientosEmpleado();
        Assert.assertNotNull(agregarMovimientosPage.pagarReembolso());
        System.out.println("----------------CASO AJUSTAR PAGO COMPLETE---------------------"); 
	}
}
