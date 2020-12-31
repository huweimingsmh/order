package com.orders.utils.code.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class QRCodeUtils {

    public static byte[] createQrCode(int width, int height, String content) {

        // 1、设置二维码的一些参数
        HashMap hints = new HashMap();
        // 1.1设置字符集
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 1.2设置容错等级；因为有了容错，在一定范围内可以把二维码p成你喜欢的样式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 1.3设置外边距;(即白色区域)
        hints.put(EncodeHintType.MARGIN, 1);
        // 2、生成二维码
        try {
            // 2.1定义BitMatrix对象
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            // 2.2、设置二维码存放路径,以及二维码的名字
          //  Path codePath = new File("I:/test/"+ "xx.png").toPath();

            // 2.3、执行生成二维码
          //  MatrixToImageWriter.writeToPath(bitMatrix, "png", codePath);
            BufferedImage bufImage=MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ImageIO.write(bufImage,"png",bos);
            return  bos.toByteArray();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
