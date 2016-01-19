package com.praxis.bisnet.test.dataprovider;

import org.testng.annotations.DataProvider;
import static com.praxis.bisnet.test.dataprovider.DataProviderReferencesConstants.*;

public class SmokeTestDP {

	@DataProvider(name = SIGNON)
	public static Object [][] signonProvider(){
		return new Object[][] {
				{"crca@praxis.com.mx", "123456"}
		};
	}

	@DataProvider(name = SIGNON_ADMINCC)
	public static Object [][] signonForAdministrador(){
		return new Object[][] {
				{"oraj@praxis.com.mx", "123456"}
		};
	}
	
	@DataProvider(name = SIGNON_ADMINVIA)
	public static Object [][] signonForCotizacion(){
		return new Object[][] {
				{"ragm@praxis.com.mx", "123456"}
		};
	}
	
	@DataProvider(name = SIGNON_TESORERO)
	public static Object [][] signonForEstadoCuenta(){
		return new Object[][] {
				{"sare@praxis.com.mx", "123456"}
		};
	}
}
