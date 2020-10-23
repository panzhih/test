package com.testweb.otherTest;

public class IsChinaese {

    public static void main(String[] args){
        String str = "sadfsdfsdf  sfsddfsdsdff胜多负少打发....。。。。。‘；123点sdsdfSdf sd 是啥地方是的f#$@$#";
        int chCharacter = 0;//中文字符
        int enCharacter = 0;//英文字符
        int spaceCharacter = 0;//空格
        int numberCharacter = 0;//数字
        int otherCharacter = 0;//其他字符

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if ((tmp >= 'A' && tmp <= 'Z') || (tmp >= 'a' && tmp <= 'z')) {
                enCharacter ++;
            } else if ((tmp >= '0') && (tmp <= '9')) {
                numberCharacter ++;
            } else if (tmp ==' ') {
                spaceCharacter ++;
            } else if (isChinese(tmp)) {
                chCharacter ++;
            } else {
                otherCharacter ++;
            }
        }
        System.out.println("字符串:" + str + " "+"\n中文字符有:" + chCharacter+"\n英文字符有:" + enCharacter+"\n数字有:" + numberCharacter+"\n空格有:" + spaceCharacter+"\n其他字符有:" + otherCharacter);
        chCharacter = 0;//中文字符
        enCharacter = 0;//英文字符
        spaceCharacter = 0;//空格
        numberCharacter = 0;//数字
        otherCharacter = 0;//其他字符
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (Character.isLetter(tmp)) {
                enCharacter ++;
            } else if (Character.isDigit(tmp)) {
                numberCharacter ++;
            } else if (tmp ==' ') {
                spaceCharacter ++;
            } else if (isChinese(tmp)) {
                chCharacter ++;
            } else {
                otherCharacter ++;
            }
        }
        System.out.println();
        System.out.println("字符串:" + str + " "+"\n中文字符有:" + chCharacter+"\n英文字符有:" + enCharacter+"\n数字有:" + numberCharacter+"\n空格有:" + spaceCharacter+"\n其他字符有:" + otherCharacter);


    }


    private static boolean isChinese(char ch) {
        //获取此字符的UniCodeBlock
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(ch);
        //  GENERAL_PUNCTUATION 判断中文的“号
        //  CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
        //  HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
        if (       ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
}
