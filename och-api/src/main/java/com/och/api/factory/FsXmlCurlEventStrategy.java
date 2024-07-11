package com.och.api.factory;


import com.och.common.domain.FsXmlCurl;

/**
 * xml_curl策略接口
 * @author danmo
 * @date 2023/09/13 22:00
 **/
public interface FsXmlCurlEventStrategy {

   public String eventHandle(FsXmlCurl fsXmlCurl);
}
