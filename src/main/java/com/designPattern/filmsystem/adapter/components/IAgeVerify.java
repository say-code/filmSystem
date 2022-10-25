package com.designPattern.filmsystem.adapter.components;

import com.designPattern.filmsystem.model.ApiMessage;

/**
 * @author 汪亦涵
 * @date 2022/10/21 11:07
 * @project filmSystem
 * @Title IAgeVerify
 * @description 年龄验证接口 接口层
 */
public interface IAgeVerify{
    /**
     * 向api发起请求，并处理成ApiMessage的格式返回
     * @param img 图片信息
     * @return ApiMessage格式的数据
     */
    ApiMessage<Integer> getMessage(String img);
}
