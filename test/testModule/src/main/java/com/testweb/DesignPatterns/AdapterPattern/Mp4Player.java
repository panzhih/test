package com.testweb.DesignPatterns.AdapterPattern;

public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("player mp4");
    }
}
