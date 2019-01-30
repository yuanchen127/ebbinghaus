package org.ike.ebbinghaus.entity;

import lombok.*;

import java.util.Date;

@Data
public class Resource {
    private Integer id;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String content;

    private Date firstTime;

    private Date lastTime;

    private String memory;

    private String note;
}