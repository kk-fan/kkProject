package com.example.demo1.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @Auther: ddj
 * @Date: 2019/1/13 10:27
 * @Description: 基础实体类
 */
public class BaseModel {

    @Id
    @Column(name = "Id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator="UUID")
    private String id;

    public String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void setId(String id) {
        this.id = id;
    }
}
