package com.example.jsonnotes;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.jsonnotes.entity.inventory;
import com.example.jsonnotes.mapper.InventoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JsonNotesApplication.class)
public class ShardingJdbcTest {

    @Resource
    private InventoryMapper InventoryMapper;

    @Test
    public void selectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<inventory> inventoryList = InventoryMapper.selectList(null);
        inventoryList.forEach(System.out::println);
    }

    @Test
    public void noJsonSelect1() {
        System.out.println(("----- noJsonSelect method test ------"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", 1);
        List<inventory> inventoryList = InventoryMapper.selectList(queryWrapper);
        inventoryList.forEach(System.out::println);
    }
    @Test
    public void noJsonSelect2() {
        System.out.println(("----- noJsonSelect method test ------"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", 2);
        List<inventory> inventoryList = InventoryMapper.selectList(queryWrapper);
        inventoryList.forEach(System.out::println);
    }

    @Test
    public void jsonSelect() {
        System.out.println(("----- jsonSelect method test ------"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) )", "hat");
        List<inventory> inventoryList = InventoryMapper.selectList(queryWrapper);
        inventoryList.forEach(System.out::println);
    }
}