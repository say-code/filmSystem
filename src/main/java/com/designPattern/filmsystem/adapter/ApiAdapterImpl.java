package com.designPattern.filmsystem.adapter;

import com.designPattern.filmsystem.adapter.IApiAdapter;
import com.designPattern.filmsystem.adapter.components.IAgeVerify;
import com.designPattern.filmsystem.adapter.components.IParent;
import com.designPattern.filmsystem.adapter.components.ISendEmail;
import com.designPattern.filmsystem.adapter.components.impl.AgeVerifyImpl;
import com.designPattern.filmsystem.adapter.components.impl.ParentImpl;
import com.designPattern.filmsystem.adapter.components.impl.SendEmailImpl;
import com.designPattern.filmsystem.model.ApiMessage;
import com.designPattern.filmsystem.model.Parent;

import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/21 20:45
 * @project filmSystem
 * @Title ApiAdapterImpl
 * @description api适配器具体实现类
 */
public class ApiAdapterImpl implements IApiAdapter {

    private IAgeVerify ageVerify;

    private IParent parent;

    private ISendEmail sendEmail;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public ApiMessage<Integer> verify(String img) {
        ageVerify = new AgeVerifyImpl();
        logger.info("2020144131汪亦涵：已装载人脸年龄验证接口 - "+ ageVerify.getClass().getSimpleName());
        return ageVerify.getMessage(img);
    }

    @Override
    public ApiMessage<Parent> parentGet(String id) {
        parent = new ParentImpl();
        logger.info("2020144131汪亦涵：已装载父母信息查询接口 - "+ parent.getClass().getSimpleName());
        return parent.getMessage(id);
    }

    @Override
    public boolean sendEmail(String phone, String msg) {
        sendEmail = new SendEmailImpl();
        logger.info("2020144131汪亦涵：已装载信息发送接口 - "+ sendEmail.getClass().getSimpleName());
        return sendEmail.sendMessage(phone, msg);
    }
}
