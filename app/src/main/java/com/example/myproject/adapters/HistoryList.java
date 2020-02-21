package com.example.myproject.adapters;

public class HistoryList {
    
    private int networkImage;
    
    private String networkName;

    private String date;
    
    public HistoryList(int networkImage, String networkName, String date) {
        this.networkImage = networkImage;
        this.networkName = networkName;
        this.date = date;
    }

    public int getNetworkImage() {
        return networkImage;
    }

    public void setNetworkImage(int networkImage) {
        this.networkImage = networkImage;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
