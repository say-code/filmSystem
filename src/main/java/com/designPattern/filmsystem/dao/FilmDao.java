package com.designPattern.filmsystem.dao;

import com.designPattern.filmsystem.mock.dbMock.FilmListMock;
import com.designPattern.filmsystem.model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/21 21:51
 * @project filmSystem
 * @Title FilmDao
 * @description 基于MVC模式的DAO层，用于向数据库查找电影数据，并返回，
 * 此处并未连接真实数据库，采用Mock来返回数据
 */
public class FilmDao {

     public static final String NOR_TYPE = "normal";
     private final Logger logger = Logger.getLogger(this.getClass().getName());

     /**
      * 根据type来返回电影数据
      * @param type 电影类型
      * @return 电影列表
      */
     public List<Film> selectFilmByType(String type){
          List<Film> films = FilmListMock.FILM_LIST;
          if (NOR_TYPE.equals(type)){
               return films;
          }
          List<Film> filmsCopy = new ArrayList<>(films);
          films.forEach(film -> {
               if (NOR_TYPE.equals(film.getType())){
                    filmsCopy.remove(film);
               }
          });
          logger.info("2020144131汪亦涵：已获取列表 —— " + filmsCopy);
          return filmsCopy;
     }

     /**
      * 根据Id查找影片
      * @param filmId 影片的ID
      * @return 影片bean
      */
     public Film selectFilmById(Integer filmId){
          List<Film> films = FilmListMock.FILM_LIST;
          for (Film film: films) {
               if (filmId.equals(film.getId())) {
                    return film;
               }
          }
          return null;
     }
}
