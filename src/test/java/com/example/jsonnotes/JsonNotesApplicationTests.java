package com.example.jsonnotes;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jsonnotes.entity.inventory;
import com.example.jsonnotes.mapper.InventoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JsonNotesApplicationTests {

    @Resource
    private InventoryMapper InventoryMapper;

    @Test
    public void selectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<inventory> inventoryList = InventoryMapper.selectList(null);
        inventoryList.forEach(System.out::println);
    }

    @Test
    public void selectPage() {
        System.out.println(("----- selectPage method test ------"));
        Page<inventory> page = new Page<>(1, 3);
        Page<inventory> inventoryList = InventoryMapper.selectPage(page, null);
        inventoryList.getRecords().forEach(System.out::println);
    }

    @Test
    public void creatInventoryJsonIndex() {
        System.out.println(("----- creatInventoryJsonIndex method test ------"));
        InventoryMapper.creatInventoryJsonIndex("test1","JSON_VALUE(items, \'$.test1\' RETURNING char(64) )");
    }
}
