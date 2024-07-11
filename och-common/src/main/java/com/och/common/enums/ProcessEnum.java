package com.och.common.enums;

import lombok.Getter;

@Getter
public enum ProcessEnum {

    NORANL,
    /**
     * 呼叫另外一侧
     */
    CALL_OTHER(),

    /**
     * 桥接
     */
    CALL_BRIDGE(),

    /**
     * 咨询坐席
     */
    CONSULT_AGENT(),

    /**
     * 咨询外线
     */
    CONSULT_CALLOUT(),

    /**
     * 转到坐席
     */
    CALL_AGENT(),

    /**
     * 完成转接
     */
    TRANSFER_SUCCESS(),

    /**
     * 转接后桥接
     */
    TRANSFER_BRIDGE(),

    /**
     * 电话转接
     */
    TRANSFER_CALL(),

    /**
     * 耳语电话
     */
    _WHISPER_CALL(),

    /**
     * 进callin
     */
    CALLIN(),

    /**
     * 进技能组
     */
    GROUP(),

    /**
     * 进ivr
     */
    IVR(),

    /**
     * 挂机处理
     */
    HANGUP(),

    /**
     * 放音queue
     */
    QUEUE_PLAY(),

    /**
     * 溢出队列
     */
    QUEUE_OVERFLOW_GROUP(),
    /**
     * 溢出进IVR
     */
    QUEUE_OVERFLOW_IVR(),
    /**
     * 溢出进vdn
     */
    QUEUE_OVERFLOW_VDN(),

    /**
     * 停止放音
     */
    QUEUE_PLAY_STOP();
}
