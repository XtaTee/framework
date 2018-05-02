package jac.dev.trigger.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jacryd
 * **/

//This controller is the one where all the http request to the 
//corresponding service will be received'

@Service
public class ContentController {

	@RequestMapping(value = "/xtatees/products", headers = "key=val", method = RequestMethod.GET)
	@ResponseBody
	public String getProducts(){		
		/**
		 * reuest params we query from our data source and then return result set
		 **/
		return "Wola";
	}
}
