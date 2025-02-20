package org.graduate.example.utils;


import com.alibaba.fastjson2.JSON;
import org.graduate.example.dox.Message;

public class MessageUtils {

    /**
     * 构造 WebSocket 消息
     * @param from 发送者
     * @param data 消息内容
     * @return JSON 格式的消息
     */
    public static String getMessage( String from,String data) {
        Message message = new Message( from, data);
        return JSON.toJSONString(message);  // 将 Message 转换为 JSON 字符串
    }
}
