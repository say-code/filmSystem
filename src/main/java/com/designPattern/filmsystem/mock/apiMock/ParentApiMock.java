package com.designPattern.filmsystem.mock.apiMock;

import com.designPattern.filmsystem.model.Parent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 汪亦涵
 * @date 2022/10/21 16:14
 * @project filmSystem
 * @Title ParentApiMock
 * @description 父母信息 MOCK服务
 */
public class ParentApiMock {
    public final static Map<String, Object> DATA= new HashMap<String, Object>(){{
       put("code",200);
       put("data",new Parent("汪小帅","13777556032"));
    }};
}
