package cn.edu.gxu.constant;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.constant
 * @date 2021/3/13 22:12
 * @Description
 */
public class ResponseException {
    public String errCode;
    public String errMsg;
    public Exception exception;

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
