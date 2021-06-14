package com.yaopeiyun.mapper;

import com.yaopeiyun.entities.DailySum;
import com.yaopeiyun.entities.Transcation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TranscationMapper {

    public List<DailySum> getTranscationByWeek();

    public List<Transcation> getTranscation(int userid, int status, Date start, Date end);

    public List<DailySum> getUserTransByWeek(Integer id);

}
