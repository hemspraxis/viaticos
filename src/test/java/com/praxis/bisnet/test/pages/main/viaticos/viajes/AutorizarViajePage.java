package com.praxis.bisnet.test.pages.main.viaticos.viajes;

import static com.praxis.bisnet.test.common.constants.PageURLsConstants.AUTORIZAR_VIAJE_PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.bisnet.test.pages.Page;

public class AutorizarViajePage extends Page<AutorizarViajePage> {
	
	public AutorizarViajePage(WebDriver driver) {
		super(driver, AUTORIZAR_VIAJE_PAGE);
	}
	
	@FindBy(how = How.ID, using = "formSolicitud:j_idt64")
	private WebElement autorizarBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formSolicitud:fieldsetDataTableSolicitud:dataTableSolicitud_data\"]/tr[1]/td[2]")
	private WebElement lastTravel;
	
	@FindBy(how = How.ID, using = "formSolicitud:j_idt69")
	private WebElement confSolBtn;
    
    @FindBy(how = How.ID, using = "formSolicitud:messages_container")
    private WebElement messageResponse;
	
	public String autorizarViaje() {
		String responseMessage = null;
		try {
			waitForWebElementDisplayed(lastTravel);
			safeClick(lastTravel);
	        waitForWebElementDisplayed(autorizarBtn);
			safeClick(autorizarBtn);
	        waitForWebElementDisplayed(confSolBtn);
	        safeClick(confSolBtn);
	        Thread.sleep(2000);
	        responseMessage = safeGetLabel(navigateForWebElement(messageResponse));
	} catch (Exception e) {
		e.printStackTrace();
	}
		System.out.println("about to send: " + responseMessage);
		return responseMessage;
	}
}
