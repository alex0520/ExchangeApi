package com.colpatria.alozano.exchange.exception;

import com.colpatria.alozano.exchange.validation.ValidationErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.AbstractMap;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * Global Exception handler for MissingServletRequestParameterException.
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleMissingServletRequestPartException(MissingServletRequestParameterException exception) {
    // general exception
    LOG.error("Missing request parameter. ", exception);
    AbstractMap.SimpleEntry<String, String> response =
            new AbstractMap.SimpleEntry<>("message", exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  /**
   * Global Exception handler for HttpMessageNotReadableException.
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
    // general exception
    LOG.error("Missing request body. ", exception);
    AbstractMap.SimpleEntry<String, String> response =
            new AbstractMap.SimpleEntry<>("message", "Required request body is missing");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  /**
   * Global Exception handler for ExchangeException.
   */
  @ExceptionHandler(ExchangeException.class)
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleExchangeException(ExchangeException exception) {
    // general exception
    LOG.debug("ControlledException: Unable to process this request. ", exception);
    AbstractMap.SimpleEntry<String, String> response =
            new AbstractMap.SimpleEntry<>("message", exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  /**
   * Global Exception handler for MethodArgumentNotValidException.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleMethodArgumentNotValidException( MethodArgumentNotValidException exception ) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult()));
  }

  /**
   * Global Exception handler for all exceptions.
   */
  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
    // general exception
    LOG.error("Exception: Unable to process this request. ", exception);
    AbstractMap.SimpleEntry<String, String> response =
            new AbstractMap.SimpleEntry<>("message", "Unable to process this request.");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

}
