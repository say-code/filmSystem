package com.designPattern.filmsystem.test.adapter;

import com.designPattern.filmsystem.adapter.ApiAdapterImpl;
import com.designPattern.filmsystem.adapter.components.impl.AgeVerifyImpl;
import com.designPattern.filmsystem.adapter.components.impl.ParentImpl;
import org.junit.Test;

/**
 * @author 汪亦涵
 * @date 2022/10/21 16:48
 * @project filmSystem
 * @Title ApiTest
 * @description 用于测试Api接口
 */

// @RunWith(SpringJUnit4ClassRunner.class)
public class ApiTest {

    ParentImpl parent = new ParentImpl();

    AgeVerifyImpl ageVerify = new AgeVerifyImpl();

    ApiAdapterImpl apiAdapter = new ApiAdapterImpl();

    @Test
    public void getMessageTest(){
       parent.getMessage("330181200205250000");
    }


    @Test
    public void  ageVerifyGetMessageTest(){
        ageVerify.getMessage("汪亦涵脑袋.jpg");
    }

    @Test
    public void  apiAdapterTest(){
       apiAdapter.verify("汪亦涵脑袋.jpg");
       apiAdapter.parentGet("330181200205250000");
       apiAdapter.sendEmail("13777556032", "你儿子被我抓了");
    }

}
