package com.designPattern.filmsystem.adapter.components;

/**
 * @author 汪亦涵
 * @date 2022/10/22 13:00
 * @project filmSystem
 * @Title ISendEmail
 * @description 向家长发送短信接口 接口层
 */
public interface ISendEmail {

    /**
     * 向特定电话号码发送信息
     * @param phone 待发送人的电话号码
     * @param msg 待发送信息
     * @return 是否发送成功
     */
    boolean sendMessage(String phone, String msg);
}
