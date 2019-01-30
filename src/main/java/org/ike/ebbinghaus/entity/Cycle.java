package org.ike.ebbinghaus.entity;

import lombok.Setter;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Value
@Setter
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