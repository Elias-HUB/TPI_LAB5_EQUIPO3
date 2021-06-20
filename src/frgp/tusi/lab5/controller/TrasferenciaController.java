package frgp.tusi.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrasferenciaController {
	
	@RequestMapping("transferencia")
	public ModelAndView transferencia() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("listarTransferencias")
	public ModelAndView listarTransferencias() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
