package com.och.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


/**
 * 号码路由网关配置关联表(CallRouteRel)表实体类
 *
 * @author danmo
 * @since 2023-10-18 14:55:14
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("call_route_rel")
public class CallRouteRel extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 499310692477559147L;
   
    /**
     *  
     */

    @Schema(description = "")
    @TableId(type = IdType.AUTO)
    private Long id;


     
    /**
     *  排序字段 
     */
    @Schema(description = "排序字段")
    @TableField("order_num")
    private Integer orderNum;
    
    
     
    /**
     *  号码路由ID 
     */
    @Schema(description = "号码路由ID")
    @TableField("call_route_id")
    private Long callRouteId;
    
    
     
    /**
     *  网关配置ID 
     */
    @Schema(description = "网关配置ID")
    @TableField("gateway_config_id")
    private String gatewayConfigId;


}

