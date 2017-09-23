package com.example.xyverous.mvpapplication.Jobs;

/**
 * Created by xyverous on 23/09/2017.
 */

public class Hero {

    private String heroName;
    private String heroImage;

    public Hero(String heroName, String heroImage){
        this.heroName = heroName;
        this.heroImage = heroImage;
    }

    public Hero(){
        this.heroName = "";
        this.heroImage = "";
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;
    }
    public String getHeroName(){
        return this.heroName;
    }

    public void setHeroImage(String heroImage){
        this.heroImage = heroImage;
    }

    public String getHeroImage() {
        return heroImage;
    }
}
