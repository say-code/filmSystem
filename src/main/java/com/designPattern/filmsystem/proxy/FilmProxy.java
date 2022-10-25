package com.designPattern.filmsystem.proxy;

import com.designPattern.filmsystem.adapter.ApiAdapterImpl;
import com.designPattern.filmsystem.adapter.IApiAdapter;
import com.designPattern.filmsystem.model.Film;
import com.designPattern.filmsystem.service.FilmService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/22 14:16
 * @project filmSystem
 * @Title filmProxy
 * @description 基于代理模式的的proxy类，
 * 主要目的是代理各个接口以及数据库查找服务，隐藏真实api接口。
 */


public class FilmProxy {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * filmService中封装了一系列针对数据库的操作
     */
    private final FilmService filmService = new FilmService();

    /**
     * apiAdapter中封装了一些列外部api
     */
    private final IApiAdapter apiAdapter = new ApiAdapterImpl();

    public List<Film> getFilmList(HttpServletRequest request){
        Integer age = (Integer) request.getSession().getAttribute("age");
        return filmService.getFilmList(age);
    }

    /**
     * 代理年龄数据接口，请求年龄数据并转发请求，获取电影数据
     * @param img 人脸图片
     * @param request 从前端传入的请求，用于获取session并设置数据
     * @param response 用于请求转发
     */
    public void ageVerify(String img, HttpServletRequest request, HttpServletResponse response){
        //请求年龄
        Integer age= apiAdapter.verify(img).getData();
        request.getSession().setAttribute("age",age);
        logger.info("2020144131汪亦涵: 已解析年龄 <"+ age +"> 正在请求电影列表...");

        //转发请求
        RequestDispatcher dispatcher = request.getRequestDispatcher("/film/list");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
