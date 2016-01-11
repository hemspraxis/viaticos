package com.praxis.bisnet.test.pages.main;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.MAIN_PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.bisnet.test.pages.Page;
import com.praxis.bisnet.test.pages.main.viaticos.comprobaciones.AutorizarComprobacionPage;
import com.praxis.bisnet.test.pages.main.viaticos.comprobaciones.MisComprobacionesPage;
import com.praxis.bisnet.test.pages.main.viaticos.estadoCuenta.AgregarMovimientosPage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.AutorizarCotizacionViajePage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.AutorizarViajePage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.CotizarViajePage;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.MisViajesPage;

public class MainPage extends Page<MainPage>{

	//MODULO VIATICOS
	
	//MODULO VIAJES
	
	//@FindBy(how = How.ID, using = "imgConten4")
	@FindBy(how = How.XPATH, using = "//*[@id=\"imgConten4\"]/img")
	private WebElement menuViaticos;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/a/span[1]")
	private WebElement parentNodeViajes;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/ul/li[1]/a")
	private WebElement misViajes;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/ul/li[2]/a")
	private WebElement autorizarViaje;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/ul/li[3]/a")
	private WebElement autorizarCotizacionViaje;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/ul/li/a")
	private WebElement cotizacion;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/a/span[1]")
	private WebElement parentNodeEstadoCuenta;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[1]/ul/li[2]/a")
	private WebElement agregarMovimiento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[2]/a/span[1]")
	private WebElement parentNodeComprobaciones;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[2]/ul/li/a")
	private WebElement agregarMisComprobaciones;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[2]/ul/li/a")
	private WebElement autorizarComprobacion;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[3]/ul/li[2]/a")
	private WebElement agregarMovimientoEmpleado;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt26:j_idt28\"]/ul/li[3]/a/span[1]")
	private WebElement parentNodeEstadoCuentaEmpleado;
	
	public MainPage(WebDriver driver) {
		super(driver, MAIN_PAGE);
	}

	public MisViajesPage linkToMisViajes(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeViajes);
		action.moveToElement(parentNodeViajes).perform();
		waitForWebElementDisplayed(misViajes);
		action.moveToElement(misViajes).click().perform();
		return new MisViajesPage(driver).loadPage();
	}
	
	public AutorizarViajePage linkToAutorizarViaje(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeViajes);
		action.moveToElement(parentNodeViajes).perform();
		waitForWebElementDisplayed(autorizarViaje);
		action.moveToElement(autorizarViaje).click().perform();
		return new AutorizarViajePage(driver).loadPage();
	}

	public CotizarViajePage linkToCotizarViaje(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeViajes);
		action.moveToElement(parentNodeViajes).perform();
		waitForWebElementDisplayed(cotizacion);
		action.moveToElement(cotizacion).click().perform();
		return new CotizarViajePage(driver).loadPage();
	}
	
	public AutorizarCotizacionViajePage linkToAutorizarCotizacionViaje(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeViajes);
		action.moveToElement(parentNodeViajes).perform();
		waitForWebElementDisplayed(autorizarCotizacionViaje);
		action.moveToElement(autorizarCotizacionViaje).click().perform();
		return new AutorizarCotizacionViajePage(driver).loadPage();
	}
	
	public AgregarMovimientosPage linkToAgregarMovimientos(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeEstadoCuenta);
		action.moveToElement(parentNodeEstadoCuenta).perform();
		waitForWebElementDisplayed(agregarMovimiento);
		action.moveToElement(agregarMovimiento).click().perform();
		return new AgregarMovimientosPage(driver).loadPage();
	}
	
	public MisComprobacionesPage linkToMisComprobaciones(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeComprobaciones);
		action.moveToElement(parentNodeComprobaciones).perform();
		waitForWebElementDisplayed(agregarMisComprobaciones);
		action.moveToElement(agregarMisComprobaciones).click().perform();
		return new MisComprobacionesPage(driver).loadPage();
	}
	
	public AutorizarComprobacionPage linkToAutorizarComprobacion(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeComprobaciones);
		action.moveToElement(parentNodeComprobaciones).perform();
		waitForWebElementDisplayed(autorizarComprobacion);
		action.moveToElement(autorizarComprobacion).click().perform();
		return new AutorizarComprobacionPage(driver).loadPage();
	}
	
	public AgregarMovimientosPage linkToAgregarMovimientosEmpleado(){
		Actions action = new Actions(driver);
		waitForWebElementDisplayed(menuViaticos);
		action.moveToElement(menuViaticos).click().perform();
		waitForWebElementDisplayed(parentNodeEstadoCuentaEmpleado);
		action.moveToElement(parentNodeEstadoCuentaEmpleado).perform();
		waitForWebElementDisplayed(agregarMovimientoEmpleado);
		action.moveToElement(agregarMovimientoEmpleado).click().perform();
		return new AgregarMovimientosPage(driver).loadPage();
	}
}