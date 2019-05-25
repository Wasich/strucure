package com.example.designer2.strucure;

public class videoModel {
    private int id;
    private String featuredimg;
    private String title;
    private String views;
    private String duration;
    private String videolink;

    public videoModel() {
    }

    public videoModel(int id, String featuredimg, String title, String views, String duration, String videolink) {
        this.id = id;
        this.featuredimg = featuredimg;
        this.title = title;
        this.views = views;
        this.duration = duration;
        this.videolink = videolink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeaturedimg() {
        return featuredimg;
    }

    public void setFeaturedimg(String featuredimg) {
        this.featuredimg = featuredimg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }
}
