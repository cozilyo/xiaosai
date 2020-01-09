package com.cozi.xiaosai.pojo.dataorigin.sysParams;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class LogoIconParams {
    private Integer imageId;
    private String userName;
    private String title;
    private String href;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "LogoIconParams{" +
                "imageId=" + imageId +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
