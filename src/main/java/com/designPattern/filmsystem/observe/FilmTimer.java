package com.designPattern.filmsystem.observe;

import com.designPattern.filmsystem.adapter.components.IParent;
import com.designPattern.filmsystem.adapter.components.impl.ParentImpl;
import com.designPattern.filmsystem.model.Parent;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author 汪亦涵
 * @date 2022/10/25 12:18
 * @project filmSystem
 * @Title FilmTimer
 * @description TODO
 */
public class FilmTimer {
    /**
     * 观察者
     */
    private IObserver observer;

    /**
     * 开始计时 影片开始时计算
     * @param session 传入会话，以设置参数
     */
    public void timerStar(HttpSession session){
        long time = Calendar.getInstance().getTimeInMillis();
        session.setAttribute("time", time);
    }

    /**
     * 停止计时并发布通知
     * @param session 传入会话信息以计算事件信息，获取发布对象
     */
    public void timeStop(HttpSession session){
        //计算观影时间
        long time = (long) session.getAttribute("time");
        long stopTime =Calendar.getInstance().getTimeInMillis();
        long decTime = stopTime - time;

        //获取父母信息并创建观察者 （订阅）
        IParent parentImpl = new ParentImpl();
        Parent parent = parentImpl.getMessage((String)session.getAttribute("id")).getData();
        observer = new ParentObserver(parent,decTime,session.getAttribute("filmName").toString());

        //发布
        observer.sendEmail();
    }
}
