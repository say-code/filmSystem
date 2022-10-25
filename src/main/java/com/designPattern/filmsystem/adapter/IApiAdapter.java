package com.designPattern.filmsystem.adapter;

import com.designPattern.filmsystem.model.ApiMessage;
import com.designPattern.filmsystem.model.Parent;

/**
 * @author 汪亦涵
 * @date 2022/10/21 10:57
 * @project filmSystem
 * @Title IApiAdapter
 * @description api适配的接口类 定义了适配器共有的方法
 */
public interface IApiAdapter {
    /**
     *  验证人脸年龄
     * @param img 图片信息
     * @return apiMessage
     */
    ApiMessage<Integer> verify(String img);

    /**
     * 获取父母信息
     * @param id 身份证信息
     * @return apiMessage
     */
    ApiMessage<Parent> parentGet(String id);

    /**
     * 向特定电话号码发送信息
     * @param phone 待发送人的电话号码
     * @param msg 待发送信息
     * @return 是否发送成功
     */
    boolean sendEmail(String phone, String msg);
}
