package hello.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import static jakarta.servlet.RequestDispatcher.*;

@Slf4j
@Controller
public class ErrorPageController {
    @RequestMapping("/error-page/404")
    public String errorPage404(HttpServletRequest request, HttpServletResponse response) {
        log.info("errorPage 404");
        return "error-page/500";
    }

    @RequestMapping("/error-page/500")
    public String errorPage500(HttpServletRequest request, HttpServletResponse response) {
        log.info("errorPage 500");
        return "error-page/500";
    }
    @RequestMapping(value = "/error-page/500", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> errorPage500Api(HttpServletRequest request, HttpServletResponse response){
        log.info("API ErrorPage 500");

        Map<String,Object> result = new HashMap<>();
        Exception ex = (Exception) request.getAttribute(ERROR_EXCEPTION);
        result.put("status",request.getAttribute(ERROR_STATUS_CODE));
        result.put("message",ex.getMessage());

        return null;
    }

    private void printErrorInfo(HttpServletRequest request){
    log.info("ERROR_EXCEPTIOPN:{}", request.getAttribute(ERROR_EXCEPTION));
    log.info("request.getAttribute(ERROR_EXCEPTION_TYPE) = {}", request.getAttribute(ERROR_EXCEPTION_TYPE));
    log.info("request.getAttribute(ERROR_MESSAGE) = {}", request.getAttribute(ERROR_MESSAGE));
    log.info("request.getAttribute(ERROR_REQUEST_URI) = {}", request.getAttribute(ERROR_REQUEST_URI));
    log.info("request.getAttribute(ERROR_SERVLET_NAME) = {}", request.getAttribute(ERROR_SERVLET_NAME));
    log.info("request.getAttribute(ERROR_STATUS_CODE) = {}", request.getAttribute(ERROR_STATUS_CODE));
    log.info("request.getDispatcherType() = {}", request.getDispatcherType());
    }
}
