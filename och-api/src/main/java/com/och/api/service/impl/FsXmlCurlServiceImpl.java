package com.och.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.och.api.factory.FsXmlCurlEventStrategyFactory;
import com.och.api.service.IFsXmlCurlService;
import com.och.security.utils.XmlCurlUtil;
import com.och.common.domain.FsXmlCurl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;

;

/**
 * @author danmo
 * @date 2023年09月14日 14:07
 */
@Slf4j
@Service
public class FsXmlCurlServiceImpl implements IFsXmlCurlService {

    @Autowired
    private FsXmlCurlEventStrategyFactory fsXmlCurlEventStrategyFactory;

    @Override
    public String xmlHandle(HttpServletRequest request) {
        FsXmlCurl xmlCurl = XmlCurlUtil.decodeThenParse(request);
        log.info("xmlCurl接口请求: [{}] [{}]", xmlCurl.getSection(), JSONObject.toJSONString(xmlCurl));
        String section = xmlCurl.getSection();
        if (StringUtils.isBlank(section)) {
            return "";
        }
        String keyValue = xmlCurl.getKeyValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<document type=\"freeswitch/xml\">");
        stringBuilder.append("<section name=\"").append(section).append("\">");
        try {
            String type = section.toUpperCase(Locale.ROOT);
            if(Objects.equals(section,"configuration")){
                type = (section + ":" + keyValue).toUpperCase(Locale.ROOT);
            }
            stringBuilder.append(fsXmlCurlEventStrategyFactory.getResource(type, xmlCurl));
        } catch (Throwable e) {
            log.info("获取fs配置异常 msg:{}", e.getMessage(), e);
        }
        stringBuilder.append("</section>\n" +
                "</document>");
        log.info("xmlCurl接口请求结果: [{}] [{}] [{}]", xmlCurl.getSection(), JSONObject.toJSONString(xmlCurl), stringBuilder);
        return stringBuilder.toString();
    }
}
