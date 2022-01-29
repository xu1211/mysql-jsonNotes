package com.example.jsonnotes.entity;

import lombok.Data;

@Data
public class explain {
    private Integer id;
    private String select_type;
    private String table;
    private String partitions;
    private String type;
    private String possible_keys;
    private String key;
    private Integer key_len;
    private String ref;
    private Integer rows;
    private String filtered;
    private String Extra;
}
