package com.designPattern.filmsystem.observe;

import com.designPattern.filmsystem.adapter.components.ISendEmail;
import com.designPattern.filmsystem.adapter.components.impl.SendEmailImpl;
import com.designPattern.filmsystem.model.Parent;
import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 汪亦涵
 * @date 2022/10/25 12:02
 * @project filmSystem
 * @Title ParentObserver
 * @description TODO
 */
@AllArgsConstructor
public class ParentObserver implements IObserver{

    private Parent parent;

    private long time;

    private String filmName;

    @Override
    public boolean sendEmail() {
        ISendEmail sendEmail = new SendEmailImpl();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm分ss秒");
        String timef = dateFormat.format(new Date(time));
        String msg = parent.getName()+"家长您好, 您的孩子在电影系统中观看"+filmName+"电影共"+
                timef+"。";
        return sendEmail.sendMessage(parent.getPhone(),msg);
    }
}
