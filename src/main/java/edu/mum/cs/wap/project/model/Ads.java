package edu.mum.cs.wap.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adsId;
    private String adsTitle;
    private String imageURL;

    public Ads() {
    }

    public Ads(String adsTitle, String imageURL) {
        this.adsTitle = adsTitle;
        this.imageURL = imageURL;
    }

    public int getAdsId() {
        return adsId;
    }

    public void setAdsId(int adsId) {
        this.adsId = adsId;
    }

    public String getAdsTitle() {
        return adsTitle;
    }

    public void setAdsTitle(String adsTitle) {
        this.adsTitle = adsTitle;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
