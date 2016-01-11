package com.praxis.bisnet.test.pages.main.viaticos.viajes;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.MIS_VIAJES_PAGE;
import static com.praxis.bisnet.test.common.util.RandomData.generateRandomNumberFromAToZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;
import com.praxis.bisnet.test.pages.main.viaticos.viajes.MisViajesPage;

public class MisViajesPage extends Page<MisViajesPage> {
	
	public MisViajesPage(WebDriver driver) {
		super(driver, MIS_VIAJES_PAGE);
	}
	
	@FindBy(how = How.ID, using = "formSolicitud:j_idt72")
	private WebElement nuevoBtn;
	
	@FindBy(how = How.ID, using = "formSolicitud:j_idt77")
	private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formSolicitud:comboEmpresa_label")
    private WebElement empresaLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboEmpresa_panel")
    private WebElement empresaLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboDepartamento_input")
    private WebElement txtDepto;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboDepartamento_panel")
    private WebElement deptoCompleteList;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboProyecto_input")
    private WebElement txtProyecto;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboProyecto_panel")
    private WebElement proyectoCompleteList;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboRespAprobacion_label")
    private WebElement aprobacionLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:comboRespAprobacion_panel")
    private WebElement aprobacionLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:compoMotivo_label")
    private WebElement motivoLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:compoMotivo_panel")
    private WebElement motivoLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:campoCBancaria_label")
    private WebElement cuentaLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:campoCBancaria_panel")
    private WebElement cuentaLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:tv_label")
    private WebElement tipoLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:tv_panel")
    private WebElement tipoLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:inputComent")
    private WebElement txtComentarios;
    
    @FindBy(how = How.ID, using = "formSolicitud:tipoTransporteSencillo_label")
    private WebElement transporteLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:tipoTransporteSencillo_panel")
    private WebElement transporteLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:aerolineas_label")
    private WebElement aeroLstLabel;
    
    @FindBy(how = How.ID, using = "formSolicitud:aerolineas_panel")
    private WebElement aeroLstPanel;
    
    @FindBy(how = How.ID, using = "formSolicitud:origenSencillo_input")
    private WebElement txtOrigen;
    
    @FindBy(how = How.ID, using = "formSolicitud:origenSencillo_panel")
    private WebElement origenCompleteList;
    
    @FindBy(how = How.ID, using = "formSolicitud:destinoSencillo_input")
    private WebElement txtDestino;
    
    @FindBy(how = How.ID, using = "formSolicitud:destinoSencillo_panel")
    private WebElement destinoCompleteList;
    
    @FindBy(how = How.ID, using = "formSolicitud:fechaSalidaSencillo_input")
    private WebElement fechaSalidaCalendarStarter;
    
    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement uiDatepickerDiv;
    
    @FindBy(how = How.ID, using = "formSolicitud:fechaRegresoRedondo_input")
    private WebElement fechaRegresoCalendarStarter;
    
    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement uiDatepickerDiv2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formSolicitud:tipoHorarioSalida\"]/tbody/tr/td[3]/div/div[2]/span")
    private WebElement rangoSalidaRadioBtn;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formSolicitud:tipoHorarioRegreso\"]/tbody/tr/td[3]/div/div[2]/span")
    private WebElement rangoRegresoRadioBtn;
    
    @FindBy(how = How.ID, using = "formSolicitud:horaSalidaInicial_input")
    private WebElement horaSalidaIniCalendarStarter;
    
    @FindBy(how = How.ID, using = "formSolicitud:horaSalidaFinal_input")
    private WebElement horaSalidaFinCalendarStarter;
    
    @FindBy(how = How.ID, using = "formSolicitud:horaRegresoInicial_input")
    private WebElement horaRegresoIniCalendarStarter;
    
    @FindBy(how = How.ID, using = "formSolicitud:horaRegresoFinal_input")
    private WebElement horaRegresoFinCalendarStarter;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[3]/a")
    private WebElement horaSalidaIni;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[5]/a")
    private WebElement horaSalidaFin;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[1]/table/tbody/tr[4]/td[4]/a")
    private WebElement horaRegresoIni;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[1]/table/tbody/tr[4]/td[6]/a")
    private WebElement horaRegresoFin;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formSolicitud:fieldsetDataTableSolicitud:dataTableSolicitud_data\"]/tr[1]/td[2]")
    private WebElement lastTravel;
    
    @FindBy(how = How.ID, using = "formSolicitud:j_idt80")
    private WebElement solicitarBtn;
    
    @FindBy(how = How.ID, using = "formSolicitud:j_idt85")
    private WebElement confSolBtn;
    
    @FindBy(how = How.ID, using = "formSolicitud:j_idt218")
    private WebElement nuevoViajeBtn;
    
    @FindBy(how = How.ID, using = "formSolicitud:j_idt88")
    private WebElement agregarViajeBtn;
    
    @FindBy(how = How.ID, using = "formSolicitud:messages_container")
    private WebElement messageResponse;
    
	public String agregarViajeSencillo() {
		String responseMessage = null;
		waitForWebElementDisplayed(nuevoBtn);
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(guardarBtn);
		try {
			Thread.sleep(1000);
			waitForWebElementDisplayed(empresaLstLabel);
			selectValueOnPrimefacesListInLoop(empresaLstLabel, empresaLstPanel, generateRandomNumberFromAToZ(1, 30));
			safeSendKeys(txtDepto, "direcci");
	        safeClick(navigateForWebElement(deptoCompleteList, "ul:0", "li:0"));
	        safeSendKeys(txtProyecto, "PX141");
	        safeClick(navigateForWebElement(proyectoCompleteList, "ul:0", "li:0"));
	        selectValueOnPrimefacesListInLoop(aprobacionLstLabel, aprobacionLstPanel, 3);
	        Thread.sleep(2000);
	        selectValueOnPrimefacesListInLoop(motivoLstLabel, motivoLstPanel, generateRandomNumberFromAToZ(1, 10));
	        selectValueOnPrimefacesListInLoop(cuentaLstLabel, cuentaLstPanel, 1);
	        selectValueOnPrimefacesListInLoop(tipoLstLabel, tipoLstPanel, 1);
	        safeSendKeys(txtComentarios, "PRUEBAS AUTOMATIZADAS");
	        int tipoTransp = generateRandomNumberFromAToZ(1, 4);
	        selectValueOnPrimefacesListInLoop(transporteLstLabel, transporteLstPanel, tipoTransp);
	        if (tipoTransp == 3) {
	        	selectValueOnPrimefacesListInLoop(aeroLstLabel, aeroLstPanel, generateRandomNumberFromAToZ(1, 8));
	        }
	        safeSendKeys(txtOrigen, "ciudad");
	        safeClick(navigateForWebElement(origenCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
	        safeSendKeys(txtDestino, "central");
	        safeClick(navigateForWebElement(destinoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
	        setDateOnPicker(fechaSalidaCalendarStarter, uiDatepickerDiv, "1", "1", "2016");
	        safeClick(rangoSalidaRadioBtn);
	        safeClick(horaSalidaIniCalendarStarter);
	        safeClick(horaSalidaIni);
	        safeClick(horaSalidaFinCalendarStarter);
	        safeClick(horaSalidaFin);
	        safeClick(guardarBtn);
	        Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
	
	public String agregarViajeRedondo() {
		String responseMessage = null;
		waitForWebElementDisplayed(nuevoBtn);
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(guardarBtn);
		try {
			Thread.sleep(1000);
			waitForWebElementDisplayed(empresaLstLabel);
			selectValueOnPrimefacesListInLoop(empresaLstLabel, empresaLstPanel, generateRandomNumberFromAToZ(1, 30));
			safeSendKeys(txtDepto, "admin");
	        safeClick(navigateForWebElement(deptoCompleteList, "ul:0", "li:0"));
	        safeSendKeys(txtProyecto, "PX141");
	        safeClick(navigateForWebElement(proyectoCompleteList, "ul:0", "li:1"));
	        selectValueOnPrimefacesListInLoop(aprobacionLstLabel, aprobacionLstPanel, 3);
	        Thread.sleep(2000);
	        selectValueOnPrimefacesListInLoop(motivoLstLabel, motivoLstPanel, generateRandomNumberFromAToZ(1, 10));
	        selectValueOnPrimefacesListInLoop(cuentaLstLabel, cuentaLstPanel, 1);
	        selectValueOnPrimefacesListInLoop(tipoLstLabel, tipoLstPanel, 2);
	        safeSendKeys(txtComentarios, "PRUEBAS AUTOMATIZADAS");
	        int tipoTransp = generateRandomNumberFromAToZ(1, 4);
	        selectValueOnPrimefacesListInLoop(transporteLstLabel, transporteLstPanel, tipoTransp);
	        if (tipoTransp == 3) {
	        	selectValueOnPrimefacesListInLoop(aeroLstLabel, aeroLstPanel, generateRandomNumberFromAToZ(1, 8));
	        }
	        safeSendKeys(txtOrigen, "ciudad");
	        safeClick(navigateForWebElement(origenCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
	        safeSendKeys(txtDestino, "central");
	        safeClick(navigateForWebElement(destinoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
	        setDateOnPicker(fechaSalidaCalendarStarter, uiDatepickerDiv, "1", "1", "2016");
	        safeClick(rangoSalidaRadioBtn);
	        safeClick(horaSalidaIniCalendarStarter);
	        safeClick(horaSalidaIni);
	        safeClick(horaSalidaFinCalendarStarter);
	        safeClick(horaSalidaFin);
	        setDateOnPicker(fechaRegresoCalendarStarter, uiDatepickerDiv2, "3", "3", "2016");
	        safeClick(rangoRegresoRadioBtn);
	        safeClick(horaRegresoIniCalendarStarter);
	        safeClick(horaRegresoIni);
	        safeClick(horaRegresoFinCalendarStarter);
	        safeClick(horaRegresoFin);
	        safeClick(guardarBtn);
	        Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
	
	public String agregarViajeMultiDestino() {
		String responseMessage = null;
		waitForWebElementDisplayed(nuevoBtn);
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(guardarBtn);
		try {
			Thread.sleep(1000);
			waitForWebElementDisplayed(empresaLstLabel);
			selectValueOnPrimefacesListInLoop(empresaLstLabel, empresaLstPanel, generateRandomNumberFromAToZ(1, 30));
			safeSendKeys(txtDepto, "direcci");
	        safeClick(navigateForWebElement(deptoCompleteList, "ul:0", "li:0"));
	        safeSendKeys(txtProyecto, "PX141");
	        safeClick(navigateForWebElement(proyectoCompleteList, "ul:0", "li:0"));
	        selectValueOnPrimefacesListInLoop(aprobacionLstLabel, aprobacionLstPanel, 3);
	        Thread.sleep(2000);
	        selectValueOnPrimefacesListInLoop(motivoLstLabel, motivoLstPanel, generateRandomNumberFromAToZ(1, 10));
	        selectValueOnPrimefacesListInLoop(cuentaLstLabel, cuentaLstPanel, 1);
	        selectValueOnPrimefacesListInLoop(tipoLstLabel, tipoLstPanel, 3);
	        safeSendKeys(txtComentarios, "PRUEBAS AUTOMATIZADAS");
	        
	        for(int i = 1; i <= 3; i++) {
		        waitForWebElementDisplayed(nuevoViajeBtn);
		        safeClick(nuevoViajeBtn);
		        waitForWebElementDisplayed(agregarViajeBtn);
		        int tipoTransp = generateRandomNumberFromAToZ(1, 4);
		        selectValueOnPrimefacesListInLoop(transporteLstLabel, transporteLstPanel, tipoTransp);
		        if (tipoTransp == 3) {
		        	selectValueOnPrimefacesListInLoop(aeroLstLabel, aeroLstPanel, generateRandomNumberFromAToZ(1, 8));
		        }
		        safeSendKeys(txtOrigen, "ciudad");
		        safeClick(navigateForWebElement(origenCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
		        safeSendKeys(txtDestino, "central");
		        safeClick(navigateForWebElement(destinoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
		        setDateOnPicker(fechaSalidaCalendarStarter, uiDatepickerDiv, "1", "1", "2016");
		        safeClick(rangoSalidaRadioBtn);
		        safeClick(horaSalidaIniCalendarStarter);
		        safeClick(horaSalidaIni);
		        safeClick(horaSalidaFinCalendarStarter);
		        safeClick(horaSalidaFin);
		        safeClick(agregarViajeBtn);
	        }
	        waitForWebElementDisplayed(guardarBtn);
	        safeClick(guardarBtn);
	        Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}

	public String solicitarViaje() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(lastTravel);
	        safeClick(lastTravel);
	        waitForWebElementDisplayed(solicitarBtn);
	        safeClick(solicitarBtn);
	        waitForWebElementDisplayed(confSolBtn);
	        safeClick(confSolBtn);
	        waitForWebElementDisplayed(messageResponse);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
	        Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
	
}
