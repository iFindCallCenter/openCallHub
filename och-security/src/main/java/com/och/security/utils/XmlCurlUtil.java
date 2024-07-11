package com.och.security.utils;

import com.alibaba.fastjson.JSONObject;
import com.och.system.domain.entity.FsXmlCurl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

;

/**
 * xml_curl参数转换
 *
 * @author danmo
 * @date 2023/09/13 22:00
 **/
public class XmlCurlUtil {
    /**
     * @param request a {@link HttpServletRequest} object.
     * @return a {@link FsXmlCurl} object.
     */
    public static FsXmlCurl decodeThenParse(final HttpServletRequest request) {
        Map<String, String> metadata = getAllRequestParam(request);
        FsXmlCurl xmlCurl = JSONObject.parseObject(JSONObject.toJSONString(metadata), FsXmlCurl.class);
        xmlCurl.setMetadata(metadata);
        return xmlCurl;
    }

    public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new ConcurrentHashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                //如果字段的值为空，判断若值为空，则删除这个字段>
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }
}
