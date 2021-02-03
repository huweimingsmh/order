package com.orders.mapper;

import com.orders.dao.Task;
import com.orders.dao.Tasks;
import com.orders.vo.task.TaskInfo;
import com.orders.vo.task.TaskShowVo;
import com.orders.vo.task.TaskStateCountsVo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface TaskMapper {

    public Tasks getTask(String id)throws SQLException;

    public void addTask(Tasks task)throws SQLException;

    public void updateTaskState(String id,int state)throws SQLException;

    public Tasks getTaskByState(String phone, int state)throws SQLException;

    public Tasks getTaskByType(String phone,int type)throws SQLException;
    public Tasks getTaskByGetState(String phone,int getState)throws SQLException;
    public Tasks getTaskByShopName(String phone,String shopName)throws SQLException;
    public Tasks getTaskByGoodsName(String phone,String goodsName)throws SQLException;
    public Tasks getTaskByTid(String tid)throws SQLException;

    public Tasks getTaskByCTime(String phone,String startTime,String endTime)throws SQLException;
    public Tasks getTaskByTTime(String phone,String startTime,String endTime)throws SQLException;

    public Tasks getTaskInfo(String tid)throws SQLException;




}
