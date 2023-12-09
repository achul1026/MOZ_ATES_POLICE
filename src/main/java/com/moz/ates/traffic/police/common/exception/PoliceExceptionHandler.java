package com.moz.ates.traffic.police.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.moz.ates.traffic.common.support.exception.CommonException;
import com.moz.ates.traffic.common.support.exception.ErrorResponse;
import com.moz.ates.traffic.common.support.exception.NoLoginException;

@ControllerAdvice
@RestControllerAdvice
public class PoliceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exceptionHandler(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ErrorPage");
		mav.addObject("message", e.getMessage());
		return mav;
	}
	
	// LoginCheckException
	@ExceptionHandler(value = NoLoginException.class)
	public String loginChkExceptionHandler(NoLoginException ne) {
		return "Login";
	}
	
	// customRuntimeException 
	@ExceptionHandler(value = CommonException.class)
	public ResponseEntity<ErrorResponse> policeExceptionHandler(CommonException ce, String message) {
		ErrorResponse response = new ErrorResponse(ce.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(ce.getErrorCode().getStatus()));
	}
}
