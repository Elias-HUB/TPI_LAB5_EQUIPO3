package frgp.tusi.lab5.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.tusi.lab5.model.Cuenta;
import frgp.tusi.lab5.model.Movimiento;
import frgp.tusi.lab5.model.Transferencia;
import frgp.tusi.lab5.serviceImpl.CuentaServiceImpl;
import frgp.tusi.lab5.serviceImpl.TransferenciaServiceImpl;

@Controller
public class TrasferenciaController {
	
	private TransferenciaServiceImpl transferenciaService;
	private CuentaServiceImpl cuentaService; 
	private HttpSession session;
	
	@RequestMapping("transferencia")
	public ModelAndView transferencia() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("transferencia");
		return mv;
	}
	
	@RequestMapping("listarTransferencias")
	public ModelAndView listarTransferencias() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("crearTransferencia")
	public ModelAndView crearTransferencia(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		session = request.getSession();
		Transferencia transferencia = new Transferencia();
		Cuenta cuentaDestino = new Cuenta();
		Cuenta cuentaOrigen = new Cuenta();
		Movimiento movimientoOrigen = new Movimiento();
		try {
			if(ValidarRequestTransferencia(request)){
				cuentaDestino = cuentaService.buscar(request.getParameter("txtDestino"));
				movimientoOrigen.setImporte(Double.parseDouble(request.getParameter("txtImporte")));
				transferencia.setCuentaDestino(cuentaDestino);
				transferencia.setMovimientoOrigen(movimientoOrigen);
				
				transferenciaService.crear(transferencia);
			
			}
			else {
				mv = new ModelAndView("redirect:transferencia.html");
				mv.setViewName("transferencia");
			}
		}
		catch(Exception ex) {
			
			
		}		
		return mv;
	}

	private boolean ValidarRequestTransferencia(HttpServletRequest request) {
			String cbuDestino = request.getParameter("txtDestino").trim();
			String importe = request.getParameter("importe").trim();
			
			if (cbuDestino == null || cbuDestino == "") {
				session.setAttribute("failure", "No se ingresó CBU para la cuenta destino.");
		        return false;
		    }
		    try {
		        double d = Double.parseDouble(cbuDestino);
		    } 
		    catch (NumberFormatException nfe) {
		    	session.setAttribute("failure", "El CBU de destino debe tener sólo números.");
		        return false;
		    }
		    if (importe == null || importe == "") {
				session.setAttribute("failure", "No se ingresó importe.");
		        return false;
		    }
		    try {
		        double d = Double.parseDouble(cbuDestino);
		        if (d <= 0) {
		        	session.setAttribute("failure", "El importe a transferir debe ser mayor que cero.");
			        return false;
		        }
		        	
		    } catch (NumberFormatException nfe) {
		    	session.setAttribute("failure", "El importe debe tener sólo números.");
		        return false;
		    }
		    return true;		    
	}

}
