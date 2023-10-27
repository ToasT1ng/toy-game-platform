package info.toast1ng.toygameplatform.common;

public enum ErrorCode {
    WRONG_HEADER(-1),
    VALIDATION_FAIL(-2),
    PASSWORD_NOT_MATCH(-3),
    RESOURCE_NOT_ENOUGH(-4);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
