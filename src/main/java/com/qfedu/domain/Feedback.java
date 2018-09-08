package com.qfedu.domain;

public class Feedback {
    private Integer id;

    private Integer uid;

    private Integer infotype;

    private String info;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getInfotype() {
        return infotype;
    }

    public void setInfotype(Integer infotype) {
        this.infotype = infotype;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}