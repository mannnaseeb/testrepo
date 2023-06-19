//package com.loyaltyservice.exception;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//
//import com.productcatalogue.response.model.Error;
//import com.productcatalogue.response.model.ErrorResponse;
//
//import lombok.extern.slf4j.Slf4j;
//
//@ControllerAdvice
//@Slf4j
//public class ProductExceptionHandler extends ResponseEntityExceptionHandler {
//	private static final Logger logger = LoggerFactory.getLogger(ProductExceptionHandler.class);
//
//	@Autowired
//	private MessageSource messageSource;
//
//	@ExceptionHandler(IllegalArgumentException.class)
//	public final ResponseEntity<Object> handlingIllegalArgumentsException(IllegalArgumentException iae,
//			WebRequest req) {
//
//		return new ResponseEntity<>(iae.getLocalizedMessage(), HttpStatus.NOT_FOUND);
//	}
//
//	//@ExceptionHandler({ GenericException.class })
//	/*
//	 * public ResponseEntity<Error> handleGenericException(GenericException ex,
//	 * WebRequest request, HttpServletResponse response) { String code =
//	 * ex.getErrorCode(); String errorMessage = ex.getCode().name(); Error error =
//	 * new Error(); String errorAuxiliary = messageSource.getMessage(code,
//	 * ex.getParams(), LocaleContextHolder.getLocale()); ErrorResponse errorResponse
//	 * = new ErrorResponse(code, errorMessage, errorAuxiliary);
//	 * error.setError(errorResponse); logger.
//	 * error("ProductExceptionHandler Generic Exception message : {}, Response - {}"
//	 * , errorMessage, errorResponse); return
//	 * ResponseEntity.badRequest().body(error); }
//	 */
//}
