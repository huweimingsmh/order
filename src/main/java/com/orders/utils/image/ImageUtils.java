package com.orders.utils.image;

import java.util.Base64;

public class ImageUtils {

    //将图片按BASE64编码转换为字符
    public static String toBase64Str(byte[] data){
        Base64.Encoder encoder = Base64.getEncoder();
       return  encoder.encodeToString(data);
    }


}
