package com.designPattern.filmsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 汪亦涵
 * @date 2022/10/21 21:44
 * @project filmSystem
 * @Title Film
 * @description 基于MVC模式的model层，作为JavaBean，描述了电影类的主要属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    private Integer id;

    private String name;

    /**
     * type为 cartoon 或 normal
     */
    private String type;

    private String filmUrl;
}
