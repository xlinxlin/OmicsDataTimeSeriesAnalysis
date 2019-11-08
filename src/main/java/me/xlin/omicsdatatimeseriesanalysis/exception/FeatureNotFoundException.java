package me.xlin.omicsdatatimeseriesanalysis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FeatureNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public FeatureNotFoundException(String exception) {
    super(exception);
  }

}