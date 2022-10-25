package com.designPattern.filmsystem.adapter.components.impl;

import com.designPattern.filmsystem.adapter.components.IAgeVerify;
import com.designPattern.filmsystem.mock.apiMock.AgeVerifyMock;
import com.designPattern.filmsystem.model.ApiMessage;
import com.designPattern.filmsystem.model.Parent;
import lombok.extern.java.Log;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 汪亦涵
 * @date 2022/10/21 16:43
 * @project filmSystem
 * @Title AgeVerify
 * @description 验证年龄的具体实现类 数据从Mock中获取
 */
public class AgeVerifyImpl implements IAgeVerify {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public ApiMessage<Integer> getMessage(String img) {
            logger.info("2020144131汪亦涵：已获取人脸数据: "+img+"\t正在向api发起请求...");
            Map<String, Object> data =AgeVerifyMock.DATA;
            ApiMessage<Integer> apiMessage = new ApiMessage<>();
            logger.info("2020144131汪亦涵：已从api获取数据: "+data);
            if (data != null){
                apiMessage.setIsSuccess(true);
                apiMessage.setCode((Integer) data.get("code"));
                apiMessage.setData((Integer) data.get("data"));
            }else{
                apiMessage.setIsSuccess(false);
            }

            logger.info("2020144131汪亦涵：已兼容数据为" + apiMessage);
            return apiMessage;
    }
}
