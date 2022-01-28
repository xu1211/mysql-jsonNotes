package com.example.jsonnotes.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.jsonnotes.dao.explain;
import com.example.jsonnotes.dao.inventory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InventoryMapper extends BaseMapper<inventory> {

    @Select("EXPLAIN SELECT * FROM inventory WHERE JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) ) = \"hat\";")
    List<explain> testEXPLAIN();

    @Select("EXPLAIN SELECT * FROM inventory ${ew.customSqlSegment}")
    List<explain> selectEolain(@Param(Constants.WRAPPER) Wrapper<inventory> inventoryWrapper);

    @Select("EXPLAIN UPDATE inventory set ${ew.sqlSet} ${ew.customSqlSegment}")
    List<explain> updateEolain(@Param(Constants.WRAPPER) Wrapper<inventory> inventoryWrapper);
}