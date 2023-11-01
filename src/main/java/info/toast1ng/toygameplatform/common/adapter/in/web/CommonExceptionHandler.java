package info.toast1ng.toygameplatform.common.adapter.in.web;

import info.toast1ng.toygameplatform.common.error.CustomException;
import info.toast1ng.toygameplatform.common.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleCommonException(Exception e) {
        log.error("에러");
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("에러");
        e.printStackTrace();
        return new ResponseEntity<>(ErrorResponse.of(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("에러");
        e.printStackTrace();
        return new ResponseEntity<>(ErrorResponse.of(ErrorCode.VALIDATION_FAIL, e.getBindingResult()), HttpStatus.BAD_REQUEST);
    }
}
