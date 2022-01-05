package com.alphacoder.util;

import com.alphacoder.domain.error.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class PortfolioUtil {
    private PortfolioUtil(){

    }

    public static List<ErrorDto> getErrorDtos(String code, String message) {
        List<ErrorDto> errors= new ArrayList<>();
        ErrorDto error= new ErrorDto();
        error.setCode(code);
        error.setMessage(message);
        errors.add(error);
        return errors;
    }
}
