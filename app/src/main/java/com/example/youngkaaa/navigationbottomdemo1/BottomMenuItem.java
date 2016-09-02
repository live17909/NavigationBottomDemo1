package com.example.youngkaaa.navigationbottomdemo1;

/**
 * Created by : youngkaaa on 2016/8/31.
 * Contact me : 645326280@qq.com
 */
public class BottomMenuItem {
    private int id;
    private String title;
    private int inActiveResId;
    private int activeResId;

    public BottomMenuItem(String title,int inActiveResId,int activeResId){
        this.title=title;
        this.inActiveResId=inActiveResId;
        this.activeResId=activeResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getActiveResId() {
        return activeResId;
    }

    public void setActiveResId(int activeResId) {
        this.activeResId = activeResId;
    }

    public void setInActiveResId(int inActiveResId) {
        this.inActiveResId = inActiveResId;
    }

    public int getInActiveResId() {
        return inActiveResId;
    }
}
