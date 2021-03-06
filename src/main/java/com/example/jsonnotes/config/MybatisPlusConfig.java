package com.example.jsonnotes.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@MapperScan("com.example.jsonnotes.mapper")
public class MybatisPlusConfig {


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }
    /**
     * 配置执行分析插件
     */
//    @Bean
//    public SqlExplainInterceptor sqlExplainInterceptor(){
//        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
//        List<ISqlParser> list = new ArrayList<>();
//        list.add(new BlockAttackSqlParser());//全表更新、删除阻断器
//        sqlExplainInterceptor.setSqlParserList(list);
//        return sqlExplainInterceptor;
//    }
}
