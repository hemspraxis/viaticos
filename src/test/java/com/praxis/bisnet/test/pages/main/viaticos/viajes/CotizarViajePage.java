package com.praxis.bisnet.test.pages.main.viaticos.viajes;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.COTIZAR_VIAJE_PAGE;
import static com.praxis.bisnet.test.common.util.RandomData.generateRandomNumberFromAToZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;

public class CotizarViajePage extends Page<CotizarViajePage> {
	
	public CotizarViajePage(WebDriver driver) {
		super(driver, COTIZAR_VIAJE_PAGE);
	}
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt59")
	private WebElement cotizarBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt389")
	private WebElement agregarDetalleBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:dcCiudad_input")
	private WebElement txtCiudadGasto;
	
	@FindBy(how = How.ID, using = "formCotizacion:dcCiudad_panel")
	private WebElement ciudadGastoCompleteList;
	
	@FindBy(how = How.ID, using = "formCotizacion:comboCat_label")
	private WebElement categoriaLstLabel;

	@FindBy(how = How.ID, using = "formCotizacion:comboCat_panel")
	private WebElement categoriaLstPanel;
	
	@FindBy(how = How.ID, using = "formCotizacion:comboTipGasto_label")
	private WebElement subcategoriaLstLabel;
	
	@FindBy(how = How.ID, using = "formCotizacion:comboTipGasto_panel")
	private WebElement subcategoriaLstPanel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formCotizacion:eventos\"]/a[1]/span/span")
	private WebElement eventosBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:monto_input")
	private WebElement txtMonto;
	
	//@FindBy(how = How.ID, using = "formCotizacion:tCorporativa")
	@FindBy(how = How.XPATH, using = "//*[@id=\"formCotizacion:tCorporativa\"]/div[2]/span")
	private WebElement tarjetaCorporativaBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:cotObserva")
	private WebElement txtObservaciones;
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt390")
	private WebElement guardarDetalleBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt355")
	private WebElement guardarCotizacionBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt60")
	private WebElement enviarCotizacionBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:justEnvio")
	private WebElement txtJustificarEnvio;
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt378")
	private WebElement enviarCotizacionFinalBtn;
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt68")
	private WebElement confirmEnvioCotiBtn;
    
    @FindBy(how = How.ID, using = "formCotizacion:messages_container")
    private WebElement messageResponse;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCotizacion:dataTableSolicitud:j_idt110\"]/span[2]")
	private WebElement folioClm;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCotizacion:dataTableSolicitud_data\"]/tr[1]/td[2]")
	private WebElement folioRow;
    
    @FindBy(how = How.ID, using = "formCotizacion:comboAerolinea_label")
    private WebElement aeroLstLabel;
    
    @FindBy(how = How.ID, using = "formCotizacion:comboAerolinea_panel")
    private WebElement aeroLstPanel;
    
    @FindBy(how = How.ID, using = "formCotizacion:dcVuelo")
    private WebElement txtVuelo;
    
    @FindBy(how = How.ID, using = "formCotizacion:otraAer")
    private WebElement txtOtraAero;
    
    @FindBy(how = How.ID, using = "formCotizacion:dcHotel")
    private WebElement txtHotel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt20\"]")
    private WebElement lbEspera;
	
	public String cotizacion() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(folioClm);
			safeClick(folioClm);
			Thread.sleep(1000);
			waitForWebElementNotDisplayed(lbEspera);
			safeClick(folioClm);
			Thread.sleep(1000);
			waitForWebElementNotDisplayed(lbEspera);
			safeClick(folioRow);
			waitForWebElementDisplayed(cotizarBtn);
			safeClick(cotizarBtn);
			for(int i = 1; i <= 3; i++){
				waitForWebElementDisplayed(agregarDetalleBtn);
				safeClick(agregarDetalleBtn);
				waitForWebElementDisplayed(txtCiudadGasto);
				safeSendKeys(txtCiudadGasto, "ciudad");
				safeClick(navigateForWebElement(ciudadGastoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
				int categ = generateRandomNumberFromAToZ(1, 6);
				selectValueOnPrimefacesListInLoop(categoriaLstLabel, categoriaLstPanel, categ);
				int subCateg = generateRandomNumberFromAToZ(1, 3);
				selectValueOnPrimefacesListInLoop(subcategoriaLstLabel, subcategoriaLstPanel, subCateg);
				if(categ == 1 && subCateg == 1) {
					int aeroLin = generateRandomNumberFromAToZ(1, 8);
					selectValueOnPrimefacesList(aeroLstLabel, aeroLstPanel, aeroLin);
					if(aeroLin == 6) {
						safeSendKeys(txtOtraAero, "VUELOS PATITO");
					}
					safeSendKeys(txtVuelo, "7777");
				}
				if(categ == 2 && subCateg == 1) {
					safeSendKeys(txtHotel, "HOTEL CALIFORNIA");
				}
				safeClick(eventosBtn);
				safeSendKeys(txtMonto, "125");
				//safeClick(tarjetaCorporativaBtn);
				safeSendKeys(txtObservaciones, "PRUEBAS COTIZACION");
				safeClick(guardarDetalleBtn);
			}
			waitForWebElementDisplayed(guardarCotizacionBtn);
			safeClick(guardarCotizacionBtn);
			waitForWebElementDisplayed(enviarCotizacionBtn);
			safeClick(enviarCotizacionBtn);
			waitForWebElementDisplayed(txtJustificarEnvio);
			safeSendKeys(txtJustificarEnvio, "COTIZACION DE PRUEBA COMPLETA");
			safeClick(enviarCotizacionFinalBtn);
			waitForWebElementDisplayed(confirmEnvioCotiBtn);
			safeClick(confirmEnvioCotiBtn);
	        Thread.sleep(2000);
			responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
}
