package com.praxis.bisnet.test.pages.main.viaticos.comprobaciones;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.MIS_COMPROBACIONES_PAGE;
import static com.praxis.bisnet.test.common.util.RandomData.generateRandomNumberFromAToZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;

public class MisComprobacionesPage extends Page<MisComprobacionesPage> {

	public MisComprobacionesPage(WebDriver driver) {
		super(driver, MIS_COMPROBACIONES_PAGE);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formBusquedaSolicitud:dataTableSolicitud_data\"]/tr[1]/td[2]")
	private WebElement folioRow;
	
	@FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt152")
	private WebElement nuevoComprobanteBtn;
	
	@FindBy(how = How.ID, using = "formConceptos:j_idt344")
	private WebElement divConceptos;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formConceptos:j_idt344\"]/div[1]/button[1]")
	private WebElement subirBtn;
	
	@FindBy(how = How.ID, using = "formConceptos:inputFechaComIni_input")
	private WebElement fechaEventoCalendarStarter;
	
	@FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement uiDatepickerDiv;
	
	@FindBy(how = How.ID, using = "formConceptos:fechaEmision_input")
	private WebElement fechaEmisionCalendarStarter;
	
	@FindBy(how = How.ID, using = "formConceptos:folioFactura")
	private WebElement txtFolioFactura;
	
	@FindBy(how = How.ID, using = "formConceptos:comboMoneda_label")
    private WebElement monedaLstLabel;
    
    @FindBy(how = How.ID, using = "formConceptos:comboMoneda_panel")
    private WebElement monedaLstPanel;
    
    @FindBy(how = How.ID, using = "formConceptos:inputTipoCambio_input")
    private WebElement txtTipoCambio;
    
    @FindBy(how = How.ID, using = "formConceptos:comboComprobante_label")
    private WebElement tipoComprobanteLstLabel;
    
    @FindBy(how = How.ID, using = "formConceptos:comboComprobante_panel")
    private WebElement tipoComprobanteLstPanel;
    
    @FindBy(how = How.ID, using = "formConceptos:categoria_label")
    private WebElement categoriaLstLabel;
    
    @FindBy(how = How.ID, using = "formConceptos:categoria_panel")
    private WebElement categoriaLstPanel;
    
    @FindBy(how = How.ID, using = "formConceptos:tipoGasto_label")
    private WebElement subcategoriaLstLabel;
    
    @FindBy(how = How.ID, using = "formConceptos:tipoGasto_panel")
    private WebElement subcategoriaLstPanel;
    
    @FindBy(how = How.ID, using = "formConceptos:tua_input")
    private WebElement txtTua;
    
    @FindBy(how = How.ID, using = "formConceptos:ish_input")
    private WebElement txtIsh;
    
    @FindBy(how = How.ID, using = "formConceptos:comObserva")
    private WebElement txtObservaciones;
    
    @FindBy(how = How.ID, using = "formConceptos:totalEx_input")
    private WebElement txtTotal;
    
    @FindBy(how = How.ID, using = "formConceptos:j_idt340")
    private WebElement guardarComprobanteBtn;
    
    @FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt145")
    private WebElement enviarComprobacionBtn;
    
    @FindBy(how = How.ID, using = "formComprobanteDetalle:j_idt165")
    private WebElement confirmarComprobacionBtn;
    
    @FindBy(how = How.ID, using = "messages_container")
    private WebElement messageResponse;
	
	public String agregarComprobantes() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(folioRow);
			safeClick(folioRow);
			for(int i = 0; i < 3; i++) {
				waitForWebElementDisplayed(nuevoComprobanteBtn);
				safeClick(nuevoComprobanteBtn);
				waitForWebElementDisplayed(divConceptos);
				driver.findElement(By.xpath("//*[@id=\"formConceptos:j_idt344_input\"]")).sendKeys("/home/praxis/Escritorio/comprobantePrueba.jpg");
				Thread.sleep(1000);
				safeClick(subirBtn);
				setDateOnPicker(fechaEventoCalendarStarter, uiDatepickerDiv, "1", "1", "2016");
				setDateOnPicker(fechaEmisionCalendarStarter, uiDatepickerDiv, "1", "1", "2016");
				safeSendKeys(txtFolioFactura, String.valueOf(7777777 + i));
				selectValueOnPrimefacesListInLoop(monedaLstLabel, monedaLstPanel, 5);
				safeSendKeys(txtTipoCambio, "17");
				selectValueOnPrimefacesListInLoop(tipoComprobanteLstLabel, tipoComprobanteLstPanel, 1);
				int cat = generateRandomNumberFromAToZ(1, 6);
				selectValueOnPrimefacesListInLoop(categoriaLstLabel, categoriaLstPanel, cat);
				int subcat = generateRandomNumberFromAToZ(1, 3);
				selectValueOnPrimefacesListInLoop(subcategoriaLstLabel, subcategoriaLstPanel, subcat);
				if (cat == 1 && subcat == 1) {
					safeSendKeys(txtTua, "50");
				}
				if(cat == 2 && subcat == 1) {
					safeSendKeys(txtIsh, "50");
				}
				safeSendKeys(txtObservaciones, "PRUEBAS DE COMPROBACIONES");
				safeSendKeys(txtTotal, "10");
				Thread.sleep(1000);
				safeClick(guardarComprobanteBtn);
				Thread.sleep(2000);
			}
			waitForWebElementDisplayed(enviarComprobacionBtn);
			safeClick(enviarComprobacionBtn);
			waitForWebElementDisplayed(confirmarComprobacionBtn);
			safeClick(confirmarComprobacionBtn);
			Thread.sleep(2000);
			responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			System.out.println("error al crear viaje sencillo");
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
}
