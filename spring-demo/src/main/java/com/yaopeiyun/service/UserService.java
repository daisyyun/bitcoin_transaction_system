package com.yaopeiyun.service;

import com.yaopeiyun.entities.Circle;
import com.yaopeiyun.entities.CirclePo;
import com.yaopeiyun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable("balance")
    public double getUserBalance(String addr){
        return userMapper.getUserBalance(addr);
    }


    @Cacheable("user")
    public Integer getUserIdByAddr(String addr){

        return userMapper.getUserIdByAddr(addr);
    }

    @Cacheable("in_and_out")
    public List<Integer> getUserInAndOut(String useraddr) {
        Integer inValue = userMapper.getUserIn(useraddr);
        Integer outValue = userMapper.getUserOut(useraddr);
        return Arrays.asList(inValue,outValue);
    }

    @Cacheable("circle")
    public List<CirclePo> getUserCircle(String useraddr) {

        List<Circle> circles = userMapper.getUserCircle(userMapper.getUserIdByAddr(useraddr));
        List<CirclePo> circlePos = new ArrayList<>();
        for (Circle circle:circles){
            CirclePo cp = new CirclePo();
            cp.setFriend(userMapper.getUserAddrById(circle.getFriend()));
            cp.setValue(circle.getValue());
            circlePos.add(cp);
        }
        return circlePos;
    }
}
