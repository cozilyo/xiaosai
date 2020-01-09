package com.cozi.xiaosai.pojo.dataorigin.sys;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class LogoIconPojo {
    private Integer id;
    private String title;
    private String image;
    private String href;
    private Integer isChecked;
    private Integer isAlter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Integer getIsAlter() {
        return isAlter;
    }

    public void setIsAlter(Integer isAlter) {
        this.isAlter = isAlter;
    }

    @Override
    public String toString() {
        return "LogoIconPojo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", href='" + href + '\'' +
                ", isChecked=" + isChecked +
                ", isAlter=" + isAlter +
                '}';
    }
}
