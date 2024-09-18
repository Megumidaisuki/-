package com.ruoyi.system.service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.system.domain.WeChatLoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeChatLoginService {

//    老师的id
//    private final String appId = "wxfc2d12eadccbc52f";
    private final String appId = "wx15de2c86b4335c84";
//    老师的secret
//    private final String secret = "3fa39979489cfc12e31360f8d14ca9c5";
    private final String secret = "91ffe0e3b8cf967a58b35c4e74038617";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeChatLoginResponse getSessionKeyOrOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId +
                     "&secret=" + secret +
                     "&js_code=" + code +
                     "&grant_type=authorization_code";
        String response = restTemplate.getForObject(url, String.class);  // 获取响应内容作为String

        ObjectMapper objectMapper = new ObjectMapper();
        WeChatLoginResponse weChatLoginResponse = null;  // 将JSON字符串转换为WeChatLoginResponse对象
        try {
            weChatLoginResponse = objectMapper.readValue(response, WeChatLoginResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return weChatLoginResponse;
//        return restTemplate.getForObject(url, WeChatLoginResponse.class);
    }
}
