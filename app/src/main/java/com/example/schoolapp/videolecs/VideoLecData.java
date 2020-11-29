package com.example.schoolapp.videolecs;

public class VideoLecData {

    private String title;
    private String keyword;

    public VideoLecData() {
    }

    public VideoLecData(String title, String keyword) {
        this.title = title;
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
