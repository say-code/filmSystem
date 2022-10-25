package com.designPattern.filmsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 汪亦涵
 * @date 2022/10/21 10:58
 * @project filmSystem
 * @Title ApiMessage
 * @description 基于MVC模式的model层，作为JavaBean，规定了Api传回数据得转换格式
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiMessage<T> {
    /**
     *  状态码 默认200
     */
    private Integer code = 200;

    /**
     * 存储传输得数据
     */
    private T data;

    /**
     * 消息提示，一般为空即可
     */
    private String msg;

    /**
     * api是否请求成功
     */
    private Boolean isSuccess;
}
