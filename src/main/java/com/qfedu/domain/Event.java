package com.qfedu.domain;

import java.util.Date;

public class Event {
    private Integer id;

    private Integer uid;

    private String eventname;

    private Integer eid;

    private Date targettime;

    private Date createtime;

    private Integer repetitions;

    private Date warntime;

    private Integer top;

    private Date toptime;

    private Integer bgid;

    private String info;

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

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getTargettime() {
        return targettime;
    }

    public void setTargettime(Date targettime) {
        this.targettime = targettime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Date getWarntime() {
        return warntime;
    }

    public void setWarntime(Date warntime) {
        this.warntime = warntime;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Date getToptime() {
        return toptime;
    }

    public void setToptime(Date toptime) {
        this.toptime = toptime;
    }

    public Integer getBgid() {
        return bgid;
    }

    public void setBgid(Integer bgid) {
        this.bgid = bgid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}