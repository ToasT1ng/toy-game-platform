package info.toast1ng.toygameplatform.common.adapter.in.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import info.toast1ng.toygameplatform.common.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleCommonException(Exception e) {
        log.error("에러");
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        log.error("에러");
        e.printStackTrace();
        return new ResponseEntity<>(generateResponseJsonString(e), HttpStatus.BAD_REQUEST);
    }

    public String generateResponseJsonString(CustomException e) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", e.getCode().getCode());
        jsonObject.addProperty("msg", e.getMessage());
        return new Gson().toJson(jsonObject);
    }
}
