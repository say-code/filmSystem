package com.designPattern.filmsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 汪亦涵
 * @date 2022/10/21 17:46
 * @project filmSystem
 * @Title Parent
 * @description 于MVC模式的model层，作为JavaBean，描述了父母类的主要属性
 */
@Data
@AllArgsConstructor
public class Parent {

    private String name;

    private String phone;
}
