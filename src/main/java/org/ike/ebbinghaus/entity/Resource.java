package org.ike.ebbinghaus.entity;

import lombok.Setter;
import lombok.Value;

import java.util.Date;

@Value
@Setter
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