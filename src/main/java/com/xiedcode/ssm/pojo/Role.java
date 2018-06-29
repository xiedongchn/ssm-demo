package com.xiedcode.ssm.pojo;

import java.io.Serializable;

/**
 * 角色POJO(plain old java object)
 *
 * @author xd
 * Created on 2018/6/18 21:50
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 1729147932676719263L;

    private Long id;
    private String name;
    private String note;

    /*setter and getter*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
