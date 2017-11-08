package com.example.tangjiting.miniweather;

import com.example.tangjiting.bean.TodayWeather;

/**
 * Created by tangjiting on 2017/11/8.
 */

public interface IWeather {
    //这里可以定义一些本地程序与服务之间通讯的方法,即调用服务中的方法。
    void callQueryWeather(String cityCode, int arg);

    TodayWeather callParseXML(String xmldata);
}
