package org.graduate.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graduate.example.dto.Code;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultVO {
    private int code;
    private Object data;
    //修改为object
    private String message;

    private static final ResultVO EMPTY=ResultVO.builder().code(200).data(Map.of()).build();

    public static ResultVO ok(){
        return EMPTY;
    }


    public static ResultVO success(Code code, Map<String,Object> data){
        return ResultVO.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .data(data)
                .build();
    }
    public static ResultVO success(Object data) {
        return ResultVO.builder().code(200).data(data).build();
    }
    public static ResultVO error(int code,String message){
        return ResultVO.builder().code(code).message(message).build();

    }
    public static ResultVO error(Code code){
        return ResultVO.builder().code(code.getCode()).message(code.getMessage()).build();
    }
}
