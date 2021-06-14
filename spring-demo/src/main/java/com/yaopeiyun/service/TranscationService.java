package com.yaopeiyun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaopeiyun.entities.DailySum;
import com.yaopeiyun.entities.Transcation;
import com.yaopeiyun.entities.TranscationPo;
import com.yaopeiyun.mapper.TranscationMapper;
import com.yaopeiyun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


import java.util.*;


@Repository
public class TranscationService {

    @Autowired
    TranscationMapper transcationMapper;
    @Autowired
    UserMapper userMapper;

    @Cacheable("trend")
    public List<DailySum> getTranscationsByWeek(){

        PageHelper.startPage(1, 7,"date desc");
        List<DailySum> list = transcationMapper.getTranscationByWeek();
        return list;
    }


    public List<TranscationPo> getTranscations(int pageNum, int userid, int status, Date start, Date end, Model model){
        PageHelper.startPage(pageNum, 20);
        List<Transcation> list = transcationMapper.getTranscation(userid,status,start,end);
        PageInfo pageInfo=new PageInfo(list,20);
        Set<Integer> addrSet = new HashSet<>();
        for (Transcation tr : list){
            if(!addrSet.contains(tr.getFromNodeNum())){
                addrSet.add(tr.getFromNodeNum());
            }
            if(!addrSet.contains(tr.getToNodeNum())){
                addrSet.add(tr.getToNodeNum());
            }
        }

        List<TranscationPo> transcations = new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        for(Integer id: addrSet){
            String addr = userMapper.getUserAddrById(id);
            map.put(id,addr);
        }

        for (Transcation tr:list){
            TranscationPo po = new TranscationPo();
            po.setId(tr.getId());
            po.setFromNodeNum(map.get(tr.getFromNodeNum()));
            po.setToNodeNum(map.get(tr.getToNodeNum()));
            po.setValue(tr.getValue());
            po.setDate(tr.getDate());
            transcations.add(po);
        }
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("transcations",transcations);
        model.addAttribute("userid",userid);
        return transcations;
    }

    @Cacheable(cacheNames = "usertrend")
    public List<DailySum> searchTransTrend(Integer id){
        PageHelper.startPage(1, 7,"date desc");
        List<DailySum> list = transcationMapper.getUserTransByWeek(id);
        return list;
    }

}
