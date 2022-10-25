package com.designPattern.filmsystem.adapter.components;

import com.designPattern.filmsystem.model.ApiMessage;
import com.designPattern.filmsystem.model.Parent;

/**
 * @author 汪亦涵
 * @date 2022/10/21 11:08
 * @project filmSystem
 * @Title IParent
 * @description 获取家长信息接口 接口层
 */
public interface IParent{
    /**
     * 向api发起请求，并处理成ApiMessage的格式返回
     * @param id 身份证信息，用来查询父母数据
     * @return ApiMessage格式的数据
     */
    ApiMessage<Parent> getMessage(String id);
}
