package com.designPattern.filmsystem.adapter.components.impl;

import com.designPattern.filmsystem.adapter.components.ISendEmail;

import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/22 13:05
 * @project filmSystem
 * @Title SendEmailImpl
 * @description SendEmail 接口实现层
 */
public class SendEmailImpl implements ISendEmail {
    @Override
    public boolean sendMessage(String phone, String msg) {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info("2020144131汪亦涵：正在向 " + phone + " 发送短信"+"\n发布的信息为：" + msg);
        return true;
    }
}
