package com.designPattern.filmsystem.service;

import com.designPattern.filmsystem.config.AgeLimit;
import com.designPattern.filmsystem.dao.FilmDao;
import com.designPattern.filmsystem.model.Film;
import org.apache.catalina.session.StandardSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.List;
import java.util.logging.Logger;


/**
 * @author 汪亦涵
 * @date 2022/10/22 1:50
 * @project filmSystem
 * @Title filmService
 * @description 电影查询 服务层
 */
@Service
public class FilmService {

    private FilmDao filmDao = new FilmDao();

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private String ageToType(Integer age){
        if ( age< AgeLimit.FIRST_LIMIT ){
            logger.info("2020144131汪亦涵：年龄为"+age+"，只能看儿童电影");
            return "cartoon";
        }else{
            logger.info("2020144131汪亦涵：年龄为"+age+", 可以看所有的电影");
            return "normal";
        }
    }

    public List<Film> getFilmList(Integer age){
        String type =ageToType(age);
        return filmDao.selectFilmByType(type);
    }

    public Film selectFilmById(Integer filmId){
        return filmDao.selectFilmById(filmId);
    }


}
