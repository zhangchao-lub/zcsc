package com.dachaoge.controller;

import java.io.UnsupportedEncodingException;

/**
 * @author czhang@mindpointeye.com
 * @Date 2020/4/2 18:13
 */
public class UrlUtil {
    /**
     * url转码、解码
     *
     * @author lifq
     * @date 2015-3-17 下午04:09:35
     */
        private final static String ENCODE = "GBK";

        /**
         * URL 解码
         *
         * @return String
         * @author lifq
         * @date 2015-3-17 下午04:09:51
         */
        public static String getURLDecoderString(String str) {
            String result = "";
            if (null == str) {
                return "";
            }
            try {
                result = java.net.URLDecoder.decode(str, ENCODE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return result;
        }

        /**
         * URL 转码
         *
         * @return String
         * @author lifq
         * @date 2015-3-17 下午04:10:28
         */
        public static String getURLEncoderString(String str) {
            String result = "";
            if (null == str) {
                return "";
            }
            try {
                result = java.net.URLEncoder.encode(str, ENCODE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return result;
        }


}
