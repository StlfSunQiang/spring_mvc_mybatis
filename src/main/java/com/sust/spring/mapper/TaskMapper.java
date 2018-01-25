package com.sust.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TaskMapper {


    //任务总数
    @Select("select count(*) from tbl_task")
    int findAllTasksCount();

    //任务状态为open的总数量
    @Select("select count(*) from tbl_task where STATUS = 'Open'")
    int findAllOpenTasksCount();
}
