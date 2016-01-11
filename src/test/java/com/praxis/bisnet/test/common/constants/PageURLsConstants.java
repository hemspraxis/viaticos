package com.praxis.bisnet.test.common.constants;

import com.praxis.bisnet.test.common.SetTestVariables;

public class PageURLsConstants {
public static final String URL                        				= SetTestVariables.configProp.getProperty("viaticos.url");   
    public static final String LOGIN_PAGE                 			= URL + "Bisnet/jsp/common/informationPrices.jspx";
    //public static final String LOGIN_PAGE                 			= URL + "svportal/login.xhtml";
    public static final String MAIN_PAGE                  			= URL + "Bisnet/jsp/sections/consoleUser.jspx";
    //public static final String MAIN_PAGE                  			= URL + "svportal/views/solicitud.xhtml?faces-redirect=true";
    public static final String MIS_VIAJES_PAGE		  	  			= URL + "svportal/views/solicitud.xhtml";
    public static final String AUTORIZAR_VIAJE_PAGE	  	  			= URL + "svportal/views/autorizarSolicitud.xhtml";
    public static final String COTIZAR_VIAJE_PAGE	  	  			= URL + "svportal/views/cotizacion.xhtml";
    public static final String AUTORIZAR_COTIZACION_VIAJE_PAGE	  	= URL + "svportal/views/cotizacion.xhtml";
    public static final String AGREGAR_MOVIMIENTOS_PAGE				= URL + "svportal/views/movimiento.xhtml";
    public static final String MIS_COMPROBACIONES_PAGE				= URL + "svportal/views/comprobante.xhtml";
    public static final String AUTORIZAR_COMPROBACION_PAGE			= URL + "svportal/views/comprobante.xhtml";
}
