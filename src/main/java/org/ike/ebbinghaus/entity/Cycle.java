package org.ike.ebbinghaus.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Cycle {
    private Integer id;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private Integer unit;

    private Integer increment;

    private BigDecimal capacity;
}