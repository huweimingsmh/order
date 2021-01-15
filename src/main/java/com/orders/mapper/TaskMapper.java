package com.orders.mapper;

import com.orders.dao.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

    public Task getTask(String id);
}
