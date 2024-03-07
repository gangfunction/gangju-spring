package hello.exception.exhandler.advice;

import hello.exception.api.ApiExceptionController;
import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalAccessException e)
    {
        log.error("[exceptionHandler] ex ",e);
        return new ErrorResult("BAD",e.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(ExecutionControl.UserException e){
        log.error("",e);
        ErrorResult errorResult=new ErrorResult("USER-EX",e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
    }
    public ErrorResult exHandler(Exception e){
        log.error("[exceptionHandler] ex",e);
        return new ErrorResult("EX","내부 오류");
    }


}
