package com.yaopeiyun.mapper;

import com.yaopeiyun.entities.Circle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public double getUserBalance(String  addr);

    public Integer getUserIdByAddr(String addr);

    public String getUserAddrById(Integer id);

    Integer getUserIn(String addr);
    Integer getUserOut(String addr);

    List<Circle> getUserCircle(Integer id);
}
