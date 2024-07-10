package com.och.common.captcha;

import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * 验证图片
 *
 * @author danmo
 * @date 2024-02-23 15:18
 **/
@Data
public class VerifyImage {

    //原图
    BufferedImage srcImage;
    //抠图后的图
    BufferedImage cutImage;
    //滑块坐标点
    Integer XPosition;
    Integer YPosition;

    public VerifyImage(BufferedImage srcImage, BufferedImage cutImage, Integer XPosition, Integer YPosition) {
        this.srcImage = srcImage;
        this.cutImage = cutImage;
        this.XPosition = XPosition;
        this.YPosition = YPosition;
    }
}
