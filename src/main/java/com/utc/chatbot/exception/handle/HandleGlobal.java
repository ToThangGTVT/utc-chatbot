package com.utc.chatbot.exception.handle;

import com.utc.chatbot.entity.sys.ExceptionMessage;
import com.utc.chatbot.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class HandleGlobal {

    @Autowired
    private ExceptionService exceptionService;

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public void handleConflict(HttpServletRequest req, Exception e) {
        exceptionService.save(new ExceptionMessage(Arrays.toString(e.getStackTrace())));
    }
}
