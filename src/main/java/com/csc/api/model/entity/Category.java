package com.csc.api.model.entity;

import com.csc.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    private UUID id;
    private String name;
    private Timestamp CreateDate;
    private Timestamp updateDate;
    private Timestamp deleteDate;
    private UUID superCategoryId;


}
