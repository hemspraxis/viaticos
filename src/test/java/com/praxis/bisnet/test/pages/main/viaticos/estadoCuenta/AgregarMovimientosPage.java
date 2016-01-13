package com.praxis.bisnet.test.pages.main.viaticos.estadoCuenta;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.AGREGAR_MOVIMIENTOS_PAGE;
import static com.praxis.bisnet.test.common.util.RandomData.generateRandomNumberFromAToZ;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;

public class AgregarMovimientosPage extends Page<AgregarMovimientosPage> {

	public AgregarMovimientosPage(WebDriver driver) {
		super(driver, AGREGAR_MOVIMIENTOS_PAGE);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formMovimiento:dataTableSolicitud_data\"]/tr[1]/td[1]")
	private WebElement folioRow;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formMovimiento:dataTableSolicitud_data\"]/tr[1]/td[2]")
	private WebElement folioRowEmpleado;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formMovimiento:dataTableSolicitud:j_idt106\"]/span[1]")
	private WebElement folioClmEmpleado;
	
	@FindBy(how = How.ID, using = "formMovimiento:j_idt58")
	private WebElement nuevoMovimientoBtn;
	
	@FindBy(how = How.ID, using = "formMovimiento:inputFechaMov_input")
	private WebElement fechaMovimientoCalendarStarter;
	
	@FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement uiDatepickerDiv;
	
	@FindBy(how = How.ID, using = "formMovimiento:comboMovimiento_label")
    private WebElement tipoLstLabel;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboMovimiento_panel")
    private WebElement tipoLstPanel;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboFormaPago_label")
    private WebElement formaPagoLstLabel;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboFormaPago_panel")
    private WebElement formaPagoLstPanel;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboBanco_label")
    private WebElement bancoLstLabel;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboBanco_panel")
    private WebElement bancoLstPanel;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboBanco_input")
    private WebElement txtBanco;
    
    @FindBy(how = How.ID, using = "formMovimiento:comboBanco_panel")
    private WebElement bancoCompleteList;
    
    @FindBy(how = How.ID, using = "formMovimiento:inputFormaPago")
    private WebElement txtReferencia;
    
    @FindBy(how = How.ID, using = "formMovimiento:inputSwift")
    private WebElement txtSwift;
    
    @FindBy(how = How.ID, using = "formMovimiento:inputMonto_input")
    private WebElement txtMonto;
    
    @FindBy(how = How.ID, using = "formMovimiento:movObserva")
    private WebElement txtObservaciones;
    
    @FindBy(how = How.ID, using = "formMovimiento:j_idt216")
    private WebElement guardarBtn;
    
    @FindBy(how = How.ID, using = "formMovimiento:j_idt57")
    private WebElement enviarNotificacionBtn;
    
    @FindBy(how = How.ID, using = "formMovimiento:j_idt178")
    private WebElement montoAutorizadoLbl;
    
    @FindBy(how = How.ID, using = "formMovimiento:j_idt210")
    private WebElement saldoLbl;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formMovimiento:j_idt255\"]/div[1]/button[1]")
	private WebElement subirBtn;
    
    @FindBy(how = How.ID, using = "formMovimiento:j_idt59")
    private WebElement liquidarSolicitudBtn;
    
    @FindBy(how = How.ID, using = "formMovimiento:j_idt64")
    private WebElement confirLiquidarSolicitudBtn;
    
    @FindBy(how = How.ID, using = "formMovimiento:messages_container")
    private WebElement messageResponse;
    
   
	public String agregarMovimientos() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(folioRow);
			safeClick(folioRow);
			waitForWebElementDisplayed(nuevoMovimientoBtn);
			safeClick(nuevoMovimientoBtn);
			setDateOnPicker(fechaMovimientoCalendarStarter, uiDatepickerDiv, "2", "2", "2016");
			selectValueOnPrimefacesListInLoop(tipoLstLabel, tipoLstPanel, 1);
			selectValueOnPrimefacesListInLoop(formaPagoLstLabel, formaPagoLstPanel, generateRandomNumberFromAToZ(1, 4));
			//selectValueOnPrimefacesListInLoop(bancoLstLabel, bancoLstPanel, generateRandomNumberFromAToZ(1, 100));
			safeSendKeys(txtBanco, "ban");
	        safeClick(navigateForWebElement(bancoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
			safeSendKeys(txtReferencia, "87654321");
			//safeSendKeys(txtSwift, "5555");
			
			int inicio = montoAutorizadoLbl.getText().indexOf("$");
	    	int fin = montoAutorizadoLbl.getText().indexOf(".", inicio + 1);
	    	String numero = montoAutorizadoLbl.getText().substring(inicio + 1, fin);
	    	
	    	String cadena = numero;
			int largo = cadena.length();
			String monto = "";
			for(int i = 0; i < largo; i++) { 
				if (Character.isDigit(cadena.charAt(i)))
					monto = monto + cadena.charAt(i);
			} 
			safeSendKeys(txtMonto, monto);
	    	
			safeSendKeys(txtObservaciones, "PRUEBA ANTICIPO");
			safeClick(guardarBtn);
			waitForWebElementDisplayed(enviarNotificacionBtn);
			safeClick(enviarNotificacionBtn);
			Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
	
	
	public String pagarReembolso() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(folioClmEmpleado);
			safeClick(folioClmEmpleado);
			Thread.sleep(2000);
			safeClick(folioClmEmpleado);
			Thread.sleep(2000);
			safeClick(folioRowEmpleado);
			waitForWebElementDisplayed(nuevoMovimientoBtn);
			safeClick(nuevoMovimientoBtn);
			setDateOnPicker(fechaMovimientoCalendarStarter, uiDatepickerDiv, "2", "2", "2016");
			selectValueOnPrimefacesListInLoop(tipoLstLabel, tipoLstPanel, 1);
			selectValueOnPrimefacesListInLoop(formaPagoLstLabel, formaPagoLstPanel, generateRandomNumberFromAToZ(1, 4));
			//selectValueOnPrimefacesListInLoop(bancoLstLabel, bancoLstPanel, generateRandomNumberFromAToZ(1, 100));
			safeSendKeys(txtBanco, "ban");
	        safeClick(navigateForWebElement(bancoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
			safeSendKeys(txtReferencia, "876543210");
			//safeSendKeys(txtSwift, "4444");
			
			int inicio = saldoLbl.getText().indexOf("$");
	    	int fin = saldoLbl.getText().indexOf(".", inicio + 1);
	    	String numero = saldoLbl.getText().substring(inicio + 1, fin);
	    	
	    	String cadena = numero;
			int largo = cadena.length();
			String monto = "";
			for(int i = 0; i < largo; i++) { 
				if (Character.isDigit(cadena.charAt(i)))
					monto = monto + cadena.charAt(i);
			} 
			safeSendKeys(txtMonto, monto);
	    	
			safeSendKeys(txtObservaciones, "PRUEBA RECUPERACION DE VIATICOS");
			driver.findElement(By.xpath("//*[@id=\"formMovimiento:j_idt255_input\"]")).sendKeys("/home/praxis/Escritorio/comprobantePrueba.jpg");
			Thread.sleep(1000);
			safeClick(subirBtn);
			safeClick(guardarBtn);
			Thread.sleep(2000);
			
			int inicio2 = saldoLbl.getText().indexOf("$");
	    	int fin2 = saldoLbl.getText().indexOf(".", inicio2 + 1);
	    	String numero2 = saldoLbl.getText().substring(inicio2 + 1, fin2);
	    	
	    	String cadena2 = numero2;
			int largo2 = cadena2.length();
			String monto2 = "";
			for(int j = 0; j < largo2; j++) { 
				if (Character.isDigit(cadena2.charAt(j)))
					monto2 = monto2 + cadena2.charAt(j);
			}
			
			if(Double.parseDouble(monto2) <= 0) {
				waitForWebElementDisplayed(enviarNotificacionBtn);
				safeClick(enviarNotificacionBtn);
			}
			Thread.sleep(2000);
			responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
	
	public String liquidarSolicitud() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(folioClmEmpleado);
			safeClick(folioClmEmpleado);
			Thread.sleep(10000);
			safeClick(folioClmEmpleado);
			Thread.sleep(10000);
			safeClick(folioRowEmpleado);
			waitForWebElementDisplayed(saldoLbl);
			
			int inicio = saldoLbl.getText().indexOf("$");
	    	int fin = saldoLbl.getText().indexOf(".", inicio + 1);
	    	String numero = saldoLbl.getText().substring(inicio + 1, fin);
	    	
	    	String cadena = numero;
			int largo = cadena.length();
			String monto = "";
			for(int i = 0; i < largo; i++) { 
				if (Character.isDigit(cadena.charAt(i)))
					monto = monto + cadena.charAt(i);
			} 
			
			if(Double.parseDouble(monto) > 0) {
				waitForWebElementDisplayed(nuevoMovimientoBtn);
				safeClick(nuevoMovimientoBtn);
				setDateOnPicker(fechaMovimientoCalendarStarter, uiDatepickerDiv, "2", "2", "2016");
				selectValueOnPrimefacesListInLoop(tipoLstLabel, tipoLstPanel, 2);
				selectValueOnPrimefacesListInLoop(formaPagoLstLabel, formaPagoLstPanel, generateRandomNumberFromAToZ(1, 4));
				//selectValueOnPrimefacesListInLoop(bancoLstLabel, bancoLstPanel, generateRandomNumberFromAToZ(1, 100));
				safeSendKeys(txtBanco, "ban");
		        safeClick(navigateForWebElement(bancoCompleteList, "ul:0", ("li:" + generateRandomNumberFromAToZ(0, 9))));
				safeSendKeys(txtReferencia, "876543210");
				//safeSendKeys(txtSwift, "3333");
				
				safeSendKeys(txtMonto, monto);
		    	
				safeSendKeys(txtObservaciones, "PRUEBA REEMBOLSO DE VIATICOS");
				driver.findElement(By.xpath("//*[@id=\"formMovimiento:j_idt255_input\"]")).sendKeys("/home/praxis/Escritorio/comprobantePrueba.jpg");
				Thread.sleep(1000);
				safeClick(subirBtn);
				safeClick(guardarBtn);
				//waitForWebElementDisplayed(enviarNotificacionBtn);
				//safeClick(enviarNotificacionBtn);
			}
			safeClick(liquidarSolicitudBtn);
			waitForWebElementDisplayed(confirLiquidarSolicitudBtn);
			safeClick(confirLiquidarSolicitudBtn);
			Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
}
