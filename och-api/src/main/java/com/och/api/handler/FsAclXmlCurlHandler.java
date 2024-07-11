package com.och.api.handler;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.och.api.factory.FsXmlCurlEventStrategy;
import com.och.common.annotation.XmlCurlEventName;
import com.och.common.constant.SectionNames;
import com.och.common.utils.StringUtils;
import com.och.common.xmlcurl.acl.AclConfiguration;
import com.och.common.xmlcurl.acl.AclList;
import com.och.common.xmlcurl.acl.AclNetworkLists;
import com.och.common.xmlcurl.acl.AclNode;
import com.och.system.domain.entity.FsXmlCurl;
import com.och.system.domain.query.acl.FsAclQuery;
import com.och.system.domain.vo.acl.FsAclNodeVo;
import com.och.system.domain.vo.acl.FsAclVo;
import com.och.system.service.IFsAclService;
import com.och.system.service.IFsConfigService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ACL处理类
 *
 * @author danmo
 * @date 2023/09/13 22:02
 **/
@XmlCurlEventName(value = SectionNames.ACL)
@Slf4j
@Component
public class FsAclXmlCurlHandler implements FsXmlCurlEventStrategy {

    @Autowired
    private IFsAclService iFsAclService;

    @Override
    public String eventHandle(FsXmlCurl fsXmlCurl) {
        StringBuilder xml = new StringBuilder();
        try {
            xml.append(getConfiguration(fsXmlCurl.getKeyValue()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("dialplanHandle: {}", xml);
        return xml.toString().replaceAll("networkLists", "network-lists");
    }

    private String getConfiguration(String keyValue) throws JsonProcessingException {
        AclConfiguration aclConfiguration = new AclConfiguration();
        aclConfiguration.setName(keyValue);
        aclConfiguration.setDescription("Network Lists");
        aclConfiguration.setNetworkLists(getAclNetWorkList());
        return aclConfiguration.toXmlString();
    }

    private AclNetworkLists getAclNetWorkList() {
        AclNetworkLists aclNetworkLists = new AclNetworkLists();
        aclNetworkLists.setList(getAclList());
        return aclNetworkLists;
    }

    private List<AclList> getAclList() {
        List<AclList> aclListList = new LinkedList<>();
        FsAclQuery lfsAclQuery = new FsAclQuery();
        List<FsAclVo> aclServiceList = iFsAclService.getList(lfsAclQuery);
        if (CollectionUtil.isNotEmpty(aclServiceList)) {
            return aclServiceList.stream().map(aclVo -> {
                AclList aclList = new AclList();
                aclList.setName(aclVo.getName());
                aclList.setAclDefault(aclVo.getDefaultType());
                if (CollectionUtil.isNotEmpty(aclVo.getNodeList())) {
                    List<AclNode> aclNodeList = new LinkedList<>();
                    for (FsAclNodeVo lfsAclNodeVo : aclVo.getNodeList()) {
                        AclNode aclNode = new AclNode();
                        aclNode.setType(lfsAclNodeVo.getNodeType());
                        if (StringUtils.isNotBlank(lfsAclNodeVo.getDomain())) {
                            aclNode.setDomain(lfsAclNodeVo.getDomain());
                        }
                        if (StringUtils.isNotBlank(lfsAclNodeVo.getCidr())) {
                            aclNode.setCidr(lfsAclNodeVo.getCidr());
                        }
                        aclNodeList.add(aclNode);
                    }
                    aclList.setNode(aclNodeList);
                }
                return aclList;
            }).collect(Collectors.toList());
        }
        return null;
    }


}
