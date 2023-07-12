package com.csc.api.model.entity;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuperCategory {
    private UUID id;
    private String name;
    private Timestamp createDate;
    private Timestamp deleteDate;
    private Timestamp updateDate;

}
