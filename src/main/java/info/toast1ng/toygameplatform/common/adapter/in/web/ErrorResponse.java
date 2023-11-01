package info.toast1ng.toygameplatform.common.adapter.in.web;

import info.toast1ng.toygameplatform.common.error.CustomException;
import info.toast1ng.toygameplatform.common.error.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private int code;
    private String msg;
    private List<BindErrorMessage> errors;

    private ErrorResponse(final ErrorCode code, final List<BindErrorMessage> errors) {
        this.code = code.getCode();
        this.msg = "올바르지 않은 입력값입니다.";
        this.errors = errors;
    }

    private ErrorResponse(final ErrorCode code, final String msg) {
        this.code = code.getCode();
        this.msg = msg;
        this.errors = new ArrayList<>();
    }

    public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
        return new ErrorResponse(code, BindErrorMessage.of(bindingResult));
    }

    public static ErrorResponse of(final CustomException e) {
        return new ErrorResponse(e.getCode(), e.getMessage());
    }

    public static ErrorResponse of(final ErrorCode code, final List<BindErrorMessage> errors) {
        return new ErrorResponse(code, errors);
    }

    public static ErrorResponse of(MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : e.getValue().toString();
        final List<ErrorResponse.BindErrorMessage> errors = ErrorResponse.BindErrorMessage.of(e.getName(), value, e.getErrorCode());
        return new ErrorResponse(ErrorCode.VALIDATION_FAIL, errors);
    }

    @Getter
    public static class BindErrorMessage {
        private String field;
        private String value;
        private String reason;

        private BindErrorMessage(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<BindErrorMessage> of(final String field, final String value, final String reason) {
            List<BindErrorMessage> fieldErrors = new ArrayList<>();
            fieldErrors.add(new BindErrorMessage(field, value, reason));
            return fieldErrors;
        }

        private static List<BindErrorMessage> of(final BindingResult bindingResult) {
            final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new BindErrorMessage(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}
