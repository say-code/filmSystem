package com.designPattern.filmsystem.adapter.components.impl;

import com.designPattern.filmsystem.adapter.components.IParent;
import com.designPattern.filmsystem.mock.apiMock.ParentApiMock;
import com.designPattern.filmsystem.model.ApiMessage;
import com.designPattern.filmsystem.model.Parent;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/21 11:15
 * @project filmSystem
 * @Title ParentImpl
 * @description 获取父母信息的具体实现类 数据从Mock获取
 */
public class ParentImpl implements IParent {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public ApiMessage<Parent> getMessage(String id) {
        logger.info("2020144131汪亦涵: 正在使用"+id+"向api请求数据...");

        // 从mock获取数据，真实情况应当从相应api获取数据
        Map<String, Object> result = ParentApiMock.DATA;
        logger.info("2020144131汪亦涵：已从api获取数据:" + result.values());
        ApiMessage<Parent> apiMessage = new ApiMessage<>();
        //如果从api获取的数据不为null则转换成apiMessage
        if (result != null){
            apiMessage.setIsSuccess(true);
            apiMessage.setCode((Integer)result.get("code"));
            apiMessage.setData((Parent)result.get("data"));
        }
        else {
            apiMessage.setIsSuccess(false);
        }
        logger.info("2020144131汪亦涵：已兼容数据为" + apiMessage);
        return apiMessage;
    }
}
