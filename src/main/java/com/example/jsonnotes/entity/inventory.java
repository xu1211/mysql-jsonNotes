package com.example.jsonnotes.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("inventory")
public class inventory {
    //@TableField(typeHandler = JacksonTypeHandler.class)
    private String items;

    private Integer id;
}
