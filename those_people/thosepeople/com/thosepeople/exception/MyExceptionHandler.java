package com.thosepeople.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author chenzhuo
 *
 */
public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse reponse, Object handler, Exception ex) {
		
		return null;
	}

}
