package cn.siwen.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
   private Integer code;
   private String message;
   private T data;

    public CommonResult(int i, String message, T t) {
       this.code=i;
       this.message=message;
       this.data=t;
    }

    public CommonResult(int i, String message) {
        this.code=i;
        this.message=message;
        this.data=null;
    }

   /* public CommonResult(Integer code,String message){
        this(code,message,null);
    }*/

   /* public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data=null;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }*/
}
