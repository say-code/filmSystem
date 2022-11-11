package com.designPattern.filmsystem.proxy;

import com.designPattern.filmsystem.model.Film;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 汪亦涵
 * @date 2022/10/27 20:47
 * @project filmSystem
 * @Title IFilmProxy
 * @description 电影代理的接口层，定义了代理层应当实现的规范，利于代理层扩展
 */
public interface IFilmProxy {

    /**
     * 获取电影列表
     * @param request 传入请求用于获取参数
     * @return 电影列表
     */
    List<Film> getFilmList(HttpServletRequest request);

    /**
     * 代理年龄数据接口，请求年龄数据并转发请求，获取电影数据
     * @param img 人脸图片
     * @param request 从前端传入的请求，用于获取session并设置数据
     * @param response 用于请求转发
     */
    void ageVerify(String img, HttpServletRequest request, HttpServletResponse response);
}
