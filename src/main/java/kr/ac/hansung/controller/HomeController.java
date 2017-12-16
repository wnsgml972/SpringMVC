package kr.ac.hansung.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// == 	private static final Logger logger = (Logger) LoggerFactory.getLogger("kr.ac.hansung.controller.HomeController");
	
	//main Home
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(HttpServletRequest request, Locale locale, Model model) {		

		//log level
		logger.trace("trace level: Welcome home! The client locale is {}", locale);
		logger.debug("debug level: Welcome home! The client locale is {}", locale);
		logger.info("info level: Welcome home! The client locale is {}", locale);
		logger.warn("warn level: Welcome home! The client locale is {}", locale);
		logger.error("error level: Welcome home! The client locale is {}", locale);
		
		String url = request.getRequestURI().toString();
		String clientIpAddress = request.getRemoteAddr();
		
		logger.info("Request URL: " + url);
		logger.info("Client IP: " + clientIpAddress);
				
		
		return "home";
	}	
}
