package com.xas.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xas.exception.CategoryNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
	private final Logger logger=Logger.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(SQLException.class)
	public String handleSqlException(HttpServletRequest request, Exception ex) {
		logger.error("SQL Exception occured "+request.getRequestURL());

		return "/errorPages/database_error";
	}
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e) {

     System.out.println(e.getCause().getMessage());
        return "redirect:/uploadStatus";

    }

	@ExceptionHandler(CategoryNotFoundException.class)
	public String handleCategoryNotFoundException(HttpServletRequest request,Exception ex) {
		System.out.println(ex);
		return "/errorPages/404";
	}
	@ExceptionHandler(Exception.class)
	public String handleGenericException(Exception ex) {
		System.out.println(ex);
		return "/errorPages/404";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRunTimeEx(Exception ex) {
		System.out.println(ex);
		return "/errorPages/500";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String handleNumberFormatEx(Exception ex) {
		System.out.println(ex);
		return "/errorPages/404";
	}
}
