package com.och.system.domain.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2024-02-23 14:26
 **/
@Schema
@Data
public class SysSimpleUserVo {

    /**
     * 用户ID
     */

    @Schema(description = "用户ID")
    private Long userId;

    /**
     * 用户账号
     */
    @Schema(description = "用户账号")
    private String userName;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String nickName;

}
