package com.yaopeiyun.controller;

import com.yaopeiyun.service.TranscationService;
import com.yaopeiyun.service.UserService;
import com.yaopeiyun.entities.DailySum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TranscationController {

    @Autowired
    TranscationService transcationService;

    @Autowired
    UserService userService;


    @ResponseBody
    @GetMapping("/transcation/getWeekData")
    public List<DailySum>  getWeekData(){
        return transcationService.getTranscationsByWeek();
    }


    @GetMapping("/transcations")
    public String getTranscations(@RequestParam int page,
                                  @RequestParam(required = false, defaultValue = "0") int userid,
                                  @RequestParam(required = false, defaultValue = "0") int status,
                                  @RequestParam(required = false, defaultValue = "") String date,
                                  Model model) throws ParseException {

        Date start = null;
        Date end = null;
        if(!date.equals("")){
            //分割日期 取出起始日期和终止日期
            String[] dd = date.split(",");
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            start = format1.parse(dd[0]);
            end = format1.parse(dd[1]);
        }
        transcationService.getTranscations(page,userid,status,start,end,model);
        return "emp/list::tableData";
    }

    @GetMapping("/alltrans")
    public String getTranscations(Model model){
        transcationService.getTranscations(1, 0, 0, null, null, model);
        return "emp/list";
    }
}
