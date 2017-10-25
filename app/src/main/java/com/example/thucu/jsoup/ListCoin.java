package com.example.thucu.jsoup;

/**
 * Created by thucu on 2017-10-21.
 */

public class ListCoin {
    private String coinImage;
    private String coinTitle;

    public ListCoin(String coinImage, String coinTitle) {
        this.coinImage = coinImage;
        this.coinTitle = coinTitle;
    }

    public String getCoinImage() {
        return coinImage;
    }

    public void setCoinImage(String coinImage) {
        this.coinImage = coinImage;
    }

    public String getCoinTitle() {
        return coinTitle;
    }

    public void setCoinTitle(String coinTitle) {
        this.coinTitle = coinTitle;
    }
}
