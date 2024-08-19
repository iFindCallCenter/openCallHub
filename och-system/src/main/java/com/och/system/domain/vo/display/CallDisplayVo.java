package com.och.system.domain.vo.display;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月26日 13:44
 */
@Schema
@Data
public class CallDisplayVo {

    /**
     * 主键
     */

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "归属组ID")
    private Long groupId;

    /**
     * 电话号码
     */
    @Schema(description = "电话号码")
    private String phone;

    /**
     * 号码类型 1-主叫显号 2-被叫显号
     */
    @Schema(description = "号码类型 1-主叫显号 2-被叫显号")
    private Integer type;

    /**
     * 归属地
     */
    @Schema(description = "归属地")
    private String area;
}
