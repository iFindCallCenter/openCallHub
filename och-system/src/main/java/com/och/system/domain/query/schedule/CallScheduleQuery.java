package com.och.system.domain.query.schedule;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @since 2024-08-09 17:14:50
 **/
@Schema
@Data
public class CallScheduleQuery extends BaseQuery {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private Long id;

    private List<Long> ids;
    /**
     * 日程名称
     */
    @Schema(description = "日程名称")
    private String name;


    /**
     * 优先级 0-10
     */
    @Schema(description = "优先级 0-10")
    private Integer level;


    /**
     * 0-指定时间 1-相对时间
     */
    @Schema(description = "0-指定时间 1-相对时间")
    private Integer type;


    /**
     * 开始日期
     */
    @Schema(description = "开始日期")
    private String startDay;


    /**
     * 结束日期
     */
    @Schema(description = "结束日期")
    private String endDay;


    /**
     * 开始时间
     */
    @Schema(description = "开始时间")
    private String startTimes;


    /**
     * 结束时间
     */
    @Schema(description = "结束时间")
    private String endTimes;


    /**
     * 1-星期一 2-星期二 3-星期三 4-星期四 5-星期五 6-星期六 7-星期日
     */
    @Schema(description = "1-星期一 2-星期二 3-星期三 4-星期四 5-星期五 6-星期六 7-星期日")
    private Integer workCycle;
}
