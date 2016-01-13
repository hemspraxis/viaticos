package com.praxis.bisnet.test.pages.main.viaticos.comprobaciones;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.AUTORIZAR_COMPROBACION_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;

public class AutorizarComprobacionPage extends Page<AutorizarComprobacionPage> {

	public AutorizarComprobacionPage(WebDriver driver) {
		super(driver, AUTORIZAR_COMPROBACION_PAGE);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formBusquedaSolicitud:dataTableSolicitud:j_idt101\"]/span[1]")
	private WebElement folioColumn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formBusquedaSolicitud:dataTableSolicitud_data\"]/tr[1]/td[2]")
	private WebElement folioRow;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:comprob")
    private WebElement tBody;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt148")
    private WebElement actualizarBtn;
	
	@FindBy(how = How.ID, using = "formConceptos:monAceptado_input")
    private WebElement txtMontoAceptado;
	
	@FindBy(how = How.ID, using = "formConceptos:j_idt340")
    private WebElement guardarBtn;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt150")
    private WebElement aprobarComprobanteBtn;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:comObservacionesAprob")
    private WebElement txtMotivoAprobacion;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt298")
    private WebElement aprobacionBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formComprobanteDetalle:comprob_data\"]/tr/td[1]")
	private WebElement comprobanteRow;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt146")
    private WebElement aprobarComprobacionBtn;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt165")
    private WebElement confirmarComprobacionBtn;
    
    @FindBy(how = How.ID, using = "messages_container")
    private WebElement messageResponse;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt20\"]")
    private WebElement lbEspera;
	
	public String autorizarComprobacion() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(folioColumn);
			safeClick(folioColumn);
			Thread.sleep(1000);
			waitForWebElementNotDisplayed(lbEspera);
			safeClick(folioColumn);
			Thread.sleep(1000);
			waitForWebElementNotDisplayed(lbEspera);
			safeClick(folioRow);
			for (int i = 1; i <= 3; i++) {
				waitForWebElementDisplayed(tBody);
				safeClick(comprobanteRow);
				waitForWebElementDisplayed(actualizarBtn);
				safeClick(actualizarBtn);
				waitForWebElementDisplayed(txtMontoAceptado);
				safeSendKeys(txtMontoAceptado, "170");
				safeClick(guardarBtn);
				waitForWebElementDisplayed(tBody);
				safeClick(comprobanteRow);
				waitForWebElementDisplayed(aprobarComprobanteBtn);
				safeClick(aprobarComprobanteBtn);
				waitForWebElementDisplayed(txtMotivoAprobacion);
				safeSendKeys(txtMotivoAprobacion, "COMPROBANTE DE PRUEBA " + i + " CORRECTO");
				safeClick(aprobacionBtn);
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
			waitForWebElementDisplayed(aprobarComprobacionBtn);
			safeClick(aprobarComprobacionBtn);
			waitForWebElementDisplayed(confirmarComprobacionBtn);
			safeClick(confirmarComprobacionBtn);
			Thread.sleep(2000);
			responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
}
