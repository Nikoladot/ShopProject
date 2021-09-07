package cubes.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping(value = "errors")
	public String getErrorPage(HttpServletRequest request, Model model) {
		
		int statusCode = getErrorCode(request);
		model.addAttribute("statusCode", statusCode);
		
		switch(statusCode) {
		
		case 400:

			model.addAttribute("errorMessage", "Postovani, poslali ste los http Reqeuest");
		
		break;
		
		case 404:

		model.addAttribute("errorMessage", "Postovani, uneli ste adresu koja ne postoji na nasem sajtu");
	
		break;
	
	default:
		
		model.addAttribute("errorMessage", "Postovani, doslo je do greske!!");
		
		break;
		}
		
		return "error-page";
	}

	
	private int getErrorCode(HttpServletRequest httprequest) {
		
		return (Integer)httprequest.getAttribute("javax.servlet.error.status_code");
	}
}
