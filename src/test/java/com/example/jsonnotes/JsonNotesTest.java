package com.example.jsonnotes;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.jsonnotes.entity.explain;
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
public class JsonNotesTest {

    @Resource
    private InventoryMapper InventoryMapper;

    @Test
    public void selectTitle() {
        System.out.println(("----- selectTitle method test ------"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) ) AS items", "id");
        List<inventory> inventoryList = InventoryMapper.selectList(queryWrapper);
        inventoryList.forEach(System.out::println);
    }

    @Test
    public void selectONE() {
        System.out.println(("----- selectONE method test ------"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) )", "hat");
        queryWrapper.lt("JSON_VALUE(items, '$.price' RETURNING DECIMAL(5,2))", 100.01);
        List<inventory> inventoryList = InventoryMapper.selectList(queryWrapper);
        inventoryList.forEach(System.out::println);
    }

    @Test
    public void selectEolain() {
        System.out.println(("----- selectEolain method test ------"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) )", "hat");
        queryWrapper.lt("JSON_VALUE(items, '$.price' RETURNING DECIMAL(5,2) )", 100.01);
        queryWrapper.lt("JSON_VALUE ( items, '$.quantity' returning UNSIGNED )", 18);
        List<explain> inventoryList = InventoryMapper.selectEolain(queryWrapper);
        inventoryList.forEach(System.out::println);
    }

    @Test
    public void update() {
        System.out.println(("----- update method test ------"));
        inventory inventory = new inventory();
        inventory.setItems("{\"name\": \"hat6\", \"price\": \"66.66\", \"quantity\": \"666\"}");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) )", "hat6");
        updateWrapper.eq("id",6);
        int id = InventoryMapper.update(inventory, updateWrapper);
    }

    @Test
    public void updateEolain() {
        System.out.println(("----- updateEolain method test ------"));
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("items","{\"name\": \"hat6\", \"price\": \"66.66\", \"quantity\": \"6\"}");
        updateWrapper.eq("JSON_VALUE ( items, '$.name' RETURNING CHAR ( 50 ) )", "hat6");
        updateWrapper.eq("id",6);
        List<explain> inventoryList = InventoryMapper.updateEolain( updateWrapper);
    }
}
