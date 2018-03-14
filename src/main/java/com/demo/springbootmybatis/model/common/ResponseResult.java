package com.demo.springbootmybatis.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@ApiModel
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 3449934794766090510L;

    @ApiModelProperty("状态")
    private int status = 200;

    @ApiModelProperty("消息")
    private String message = "成功";

    @ApiModelProperty("结果")
    private T data;
}
