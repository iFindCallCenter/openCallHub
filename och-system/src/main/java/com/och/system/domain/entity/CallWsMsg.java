package com.och.system.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * websocket坐席消息
 * @author: danmo
 * @date: 2024/08/31 14:06
 */
@Schema
@Data
public class CallWsMsg {

    @Schema(description = "呼叫ID")
    private Long callId;

    @Schema(description = "呼叫方向 1-呼入 2-呼出")
    private Integer direction;

    @Schema(description = "主叫号码")
    private String caller;

    @Schema(description = "被叫号码")
    private String callee;

    @Schema(description = "状态 0-空闲 1-忙碌 2-正在呼叫 3-被叫振铃 4-主叫振铃 5-通话中 6-结束通话")
    private Integer status;

    @Schema(description = "消息类型 1-坐席状态")
    private Integer msgType;

    @Schema(description = "消息内容")
    private String content;
}
