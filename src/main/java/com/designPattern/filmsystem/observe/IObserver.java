package com.designPattern.filmsystem.observe;

/**
 * @author 汪亦涵
 * @date 2022/10/25 11:33
 * @project filmSystem
 * @Title Observer
 * @description 观察者的接口类，所有观察者都应当具有该方法以便被观察者进行发布
 */

public interface IObserver {

    /**
     * 用于发布通知
     * @return 是否发布成功
     */
    boolean sendEmail();
}
