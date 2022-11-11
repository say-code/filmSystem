package com.designPattern.filmsystem.mock.apiMock;

import com.designPattern.filmsystem.model.Parent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 汪亦涵
 * @date 2022/10/21 20:14
 * @project filmSystem
 * @Title AgeVerifyMock
 * @description 年龄信息 Mock服务
 */
public class AgeVerifyMock {
    public final static Map<String, Object> DATA= new HashMap<String, Object>(){{
        put("code",200);
        put("data", 19);
    }};
}
