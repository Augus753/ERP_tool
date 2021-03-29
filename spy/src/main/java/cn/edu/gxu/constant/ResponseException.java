package cn.edu.gxu.constant;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.constant
 * @date 2021/3/13 22:12
 * @Description
 */
public class ResponseException extends Exception {
    public String errCode;
    public String errMsg;
    public Exception exception;

    public ResponseException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ResponseException(enums.defineException exception) {
        this.errCode = exception.errCode;
        this.errMsg = exception.errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
