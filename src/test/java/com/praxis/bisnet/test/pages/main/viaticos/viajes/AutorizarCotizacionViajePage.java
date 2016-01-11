package com.praxis.bisnet.test.pages.main.viaticos.viajes;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.AUTORIZAR_COTIZACION_VIAJE_PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;

public class AutorizarCotizacionViajePage extends Page<AutorizarCotizacionViajePage> {
	
	public AutorizarCotizacionViajePage(WebDriver driver) {
		super(driver, AUTORIZAR_COTIZACION_VIAJE_PAGE);
	}
	
	@FindBy(how = How.ID, using = "formCotizacion:j_idt61")
	private WebElement autorizarCotizacionBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formCotizacion:dataTableSolicitud_data\"]/tr[1]/td[2]")
	private WebElement lastTravel;
    
    @FindBy(how = How.ID, using = "formCotizacion:messages_container")
    private WebElement messageResponse;
	
	public String autorizarCotizacionViaje() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(lastTravel);
			safeClick(lastTravel);
	        waitForWebElementDisplayed(autorizarCotizacionBtn);
			safeClick(autorizarCotizacionBtn);
	        Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
	} catch (Exception e) {
		e.printStackTrace();
	}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
}
