package com.testweb.DesignPatterns.AdapterPattern;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("player Vic");
    }

    @Override
    public void playMp4(String fileName) {

    }
}
