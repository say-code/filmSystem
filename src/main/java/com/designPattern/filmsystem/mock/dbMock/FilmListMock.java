package com.designPattern.filmsystem.mock.dbMock;

import com.designPattern.filmsystem.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 汪亦涵
 * @date 2022/10/21 21:58
 * @project filmSystem
 * @Title FilmListMock
 * @description 电影 数据库Mock
 */
public class FilmListMock {
    public static final List<Film> FILM_LIST = new ArrayList<Film>(){{
        add(new Film(1,"刀剑神域","normal","1.mp4"));
        add(new Film(2,"喜羊羊与灰太狼","cartoon","2.mp4"));
        add(new Film(3,"熊出没","cartoon","2.mp4"));
        add(new Film(4,"no game no life","normal","2.mp4"));
        add(new Film(5,"砰然心动","normal","2.mp4"));
        add(new Film(6,"小猪佩奇","cartoon","2.mp4"));
        add(new Film(7,"Overload","normal","2.mp4"));
        add(new Film(8,"实力主义至上的教室","normal","2.mp4"));
    }};
}
