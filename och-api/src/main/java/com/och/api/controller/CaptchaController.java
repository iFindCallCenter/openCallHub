package com.och.api.controller;

import com.och.common.base.BaseController;
import com.och.common.base.ResResult;
import com.och.common.captcha.VerifyImage;
import com.och.common.utils.VerifyImageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


/**
 * @author danmo
 * @date 2024-02-23 16:38
 **/
@Tag(name = "验证码")
@RestController
@RequestMapping("/captcha/v1")
public class CaptchaController extends BaseController {
    /**
     * 返回裁剪后的图及坐标
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     */
    @Operation(summary = "返回裁剪后的图及坐标", method = "GET")
    @GetMapping("getCutImage")
    public void getCutImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        //设置响应的信息类型
        httpServletResponse.setContentType("image/png");
        //定义一个Ant模式通配符的Resource查找器，可以用来查找类路径下或者文件系统中的资源。
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //得到图片文件夹中所有路径
        Resource[] resources = resolver.getResources("classpath*:/images/*");
        int ranNum = new Random().nextInt(resources.length - 1);
        //通过随机的图片路径得到验证码图片
        VerifyImage verifyImage = VerifyImageUtils.getVerifyImage(resources[ranNum].getInputStream());
        ByteArrayOutputStream baosCutImage = new ByteArrayOutputStream();
        ImageIO.write(verifyImage.getCutImage(), "png", baosCutImage);
        baosCutImage.flush();
        byte[] imageInByteCutImage = baosCutImage.toByteArray();
        baosCutImage.close();

        //session处理
        HttpSession mySession = httpServletRequest.getSession();
        mySession.setAttribute("ImageX", verifyImage.getXPosition());
        mySession.setAttribute("ImageY", verifyImage.getYPosition());
        System.out.println("ImageX:" + mySession.getAttribute("ImageX"));
        System.out.println("ImageY:" + mySession.getAttribute("ImageY"));

        OutputStream stream = httpServletResponse.getOutputStream();
        stream.write(imageInByteCutImage);
        //清空
        stream.flush();
        //关闭
        stream.close();
    }

    /**
     * 返回原图
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     */
    @Operation(summary = "返回原图", method = "GET")
    @GetMapping("getSrcImage")
    public void getSrcImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        //设置响应的信息类型
        httpServletResponse.setContentType("image/png");
        //定义一个Ant模式通配符的Resource查找器，可以用来查找类路径下或者文件系统中的资源。
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //得到图片文件夹中所有路径
        Resource[] resources = resolver.getResources("classpath*:/images/*");
        int ranNum = new Random().nextInt(resources.length);
        //通过随机的图片路径得到验证码图片
        VerifyImage verifyImage = VerifyImageUtils.getVerifyImage(resources[ranNum].getInputStream());
        ByteArrayOutputStream baosSrcImage = new ByteArrayOutputStream();
        ImageIO.write(verifyImage.getSrcImage(), "png", baosSrcImage);
        baosSrcImage.flush();
        byte[] imageInByteSrcImage = baosSrcImage.toByteArray();
        baosSrcImage.close();
        OutputStream stream = httpServletResponse.getOutputStream();
        stream.write(imageInByteSrcImage);
        stream.flush();
        //        清空
        stream.flush();
        //        关闭
        stream.close();

    }

    /**
     * 得到图片验证的坐标，进行有效性校对
     *
     * @param x
     * @param y
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @Operation(summary = "得到图片验证的坐标，进行有效性校对", method = "GET")
    @GetMapping("verifyImage")
    public ResResult<String> verifyImage(String x, String y, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession httpSession = httpServletRequest.getSession();
        String ImageX = String.valueOf(httpSession.getAttribute("ImageX"));
        String ImageY = String.valueOf(httpSession.getAttribute("ImageY"));
        //计算验证图片坐标的误差值
        int absX = Math.abs(Integer.parseInt(x) - Integer.parseInt(ImageX));
        int absY = Math.abs(Integer.parseInt(y) - Integer.parseInt(ImageY));
        if (absX < 6 && absY < 6) {
            return success("验证码正确");
        }
        return error("验证码错误");
    }
}
