package com.ldblockchain.sls.comm.result;

import com.ldblockchain.sls.comm.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 平台通用返回结果
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseResult implements Result {

    private static final long serialVersionUID = 874200365941306385L;

    private Integer code;

    private String msg;

    private Object data;

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }


    public static ResponseResult failure(ResultCode resultCode) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResponseResult failure(ResultCode resultCode, Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    public static ResponseResult failure(Integer code, String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    private void setData(Object data) {
        this.data = data;
    }

//    public static ResponseResult failure(String message) {
//        ResponseResult result = new ResponseResult();
//        result.setCode(ResultCode.PARAM_IS_INVALID.code());
//        result.setMsg(message);
//        return result;
//    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

}
