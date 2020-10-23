package com.testweb.otherTest;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryTest {
    public static void main(String[] args) {

        /*String groups = "8120_iptv;0,8114_iptv;0,8098_iptv;0";
        System.out.println(updateGroups(groups,"1"));

        System.out.println(updateKey("iptv"));
*/
        String str = "[{\"caCode\":\"1234567\",\"areaCode\":\"0001\"},{\"caCode\":\"1234568\",\"areaCode\":\"0002\"},{\"caCode\":\"1234569\",\"areaCode\":\"0003\"}]";

        /*try {
            str = URLEncoder.encode(str, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str);*/

        //System.out.println(updateGroups("1"));
        String str1 = "8120_iptv,8114_iptv,8098_iptv";
        System.out.println(updateGroups(str1,"1"));
        System.out.println(str1.equals(updateGroups(str1,"1")));

        /*int n = -10;
        System.out.println("6===="+Integer.toBinaryString(6));
        System.out.println("-10==="+Integer.toBinaryString(n));

        System.out.println("~15=="+~15);
        System.out.println("~17=="+~17);//-18
        System.out.println("5&6=="+(5&6));//4
        System.out.println("5|6=="+(5|6));//7
        System.out.println("5^6=="+(5^6));//3

        //System.out.println("-6二进制转换为十进制="+Integer.valueOf(Integer.toBinaryString(n),2).toString());
        System.out.println(Integer.numberOfLeadingZeros(6));
        System.out.println("2 >>> 3 =="+(n >>> 3));*/

        /*Long code = 15L;
        if(code.equals(15L)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }*/

        /*String str = "SmartHP_AndroidPhone_Z00_V1.3.2_9e050ab.apk";

        int subStr = str.indexOf("_",str.indexOf("_")+1);

        int lastStr = str.lastIndexOf("_V");

        String endStr = str.substring(lastStr+2,str.lastIndexOf("."));

        System.out.println("第二个下划线的位置："+subStr);

        System.out.println("倒数第二个下划线所在的位置："+lastStr);

        System.out.println("输出指定字符串："+endStr);

        System.out.println(subStr(str));

    }

    public static int subStr(String str){
        Matcher matcher = Pattern.compile("_").matcher(str);
        int number = 0;
        while (matcher.find()){
            number ++;
            if(number == 3){
                break;
            }
        }
        return matcher.start();
    }*/
    }

    /*private static String updateGroups(String groups,String flag) {
        if(flag.equals("1")){
            if(groups.contains(";0")){
                groups = groups.replace(";0","");
            }
        }
        return groups;
    }*/

    private static String updateKey(String key) {
        int len = key.length();
        if(len < 16){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < 16-len ; i++){
                stringBuilder.append("0");
            }
            key = stringBuilder.toString() + key;
        }
        return key;
    }

    private static String updateGroups(String groups,String flag) {
        //String groups = "8120_iptv,8114_iptv,8098_iptv";
        if("1".equals(flag) && StringUtils.isNotBlank(groups)){
            StringBuilder stringBuilder = new StringBuilder();
            String[] g = groups.split(",");
            if(g.length > 0){
                for(String code : g){
                    stringBuilder.append(",");
                    if(code.contains(";")){
                        stringBuilder.append(code);
                    }else{
                        stringBuilder.append(code).append(";").append("0");
                    }
                }
            }
            if(StringUtils.isNotEmpty(stringBuilder.toString())){
                groups = stringBuilder.toString().substring(1);
            }
        }
        return groups;

    }
}
