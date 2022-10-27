package com.designPattern.filmsystem.controller;

import com.designPattern.filmsystem.config.AgeLimit;
import com.designPattern.filmsystem.model.Film;
import com.designPattern.filmsystem.observe.FilmTimer;
import com.designPattern.filmsystem.proxy.FilmProxy;
import com.designPattern.filmsystem.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/22 16:41
 * @project filmSystem
 * @Title filmController
 * @description 基于MVC模式的控制层，用于处理用户请求并返回相应数据
 * 此类主要负责验证用户年龄，返回相应的用户列表
 */

@Controller
@RequestMapping("/film")
public class FilmController {

    FilmProxy filmProxy = new FilmProxy();

    FilmService filmService = new FilmService();

    FilmTimer filmTimer = new FilmTimer();

    Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * 用于请求电影列表
     * @param request 此时session中应当包含年龄
     * @param model 用于thymeleaf解析
     * @return 跳转请求
     */
    @PostMapping("/list")
    public String getFilmList(HttpServletRequest request, Model model){
        logger.info("2020144131汪亦涵：用户正在请求电影列表");
        model.addAttribute("filmList",filmProxy.getFilmList(request));
        return "movieChoice";
    }

    /**
     * 年龄验证
     * @param img 人脸图像
     * @param id 用于身份验证
     * @param request 用于获取session并设置参数
     * @param response 用于proxy转发请求
     */
    @PostMapping("/verify")
    public void ageVerify(@RequestParam("img") String img,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("id",id);
        logger.info("2020144131汪亦涵：用户正在请求年龄验证");
        filmProxy.ageVerify(img,request,response);
    }

    /**
     * 用于获取电影资源，同时计时器也会在此处启动
     * @param filmId 电影Id
     * @param model 用于thymeleaf解析
     * @param request 用于获取session并设置参数
     * @return 跳转请求
     */
    @PostMapping("/filmGet")
    public String getFilm(@RequestParam("filmId") String filmId,Model model,HttpServletRequest request){
        Film film = filmService.selectFilmById(Integer.valueOf(filmId));
        logger.info("2020144131汪亦涵：用户正在请求"+film.getName()+"的电影数据。");
        filmTimer.timerStar(request.getSession());
        request.getSession().setAttribute("filmName", film.getName());
        model.addAttribute("filmUrl", film.getFilmUrl());
        return "player";
    }

    /**
     * 电影结束触发的动作
     * @param request 用于获取session
     * @return 转发请求
     */
    @GetMapping("filmOver")
    public String filmOver(HttpServletRequest request){
        logger.info("2020144131汪亦涵：用户正在请求结束电影会话");
        int age = (int) request.getSession().getAttribute("age");
        if (age < AgeLimit.SECOND_LEVEL){
            logger.info("2020144131汪亦涵：用户年龄小于设定年龄，需要通知家长");
            filmTimer.timeStop(request.getSession());
        }
        return "README";
    }
}
