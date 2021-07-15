package com.example.desafioquality.exception.handler;

import com.example.desafioquality.dto.ErrorProprietyFormDto;
import com.example.desafioquality.exception.PropertyNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiControllerAdvice {

    private final MessageSource messageSource;

    public ApiControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorProprietyFormDto> handle(MethodArgumentNotValidException exception){
        List<ErrorProprietyFormDto> dto = new ArrayList();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorProprietyFormDto erro = new ErrorProprietyFormDto(e.getField(), message);
            dto.add(erro);
        });
        return dto;
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String handle(PropertyNotFoundException exception){
        return exception.getMessage();
    }

}