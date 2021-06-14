package com.yaopeiyun.controller;

import com.yaopeiyun.entities.CirclePo;
import com.yaopeiyun.service.TranscationService;
import com.yaopeiyun.service.UserService;
import com.yaopeiyun.entities.DailySum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TranscationService transcationService;

    @GetMapping("balance")
    public String toBalancePage(){
        return "emp/balance";
    }

    @ResponseBody
    @PostMapping("/user/balance")
    public double getUserBalance(@RequestParam("useraddr") String useraddr){
        return userService.getUserBalance(useraddr);

    }

    @ResponseBody
    @PostMapping("/user/searchTransTrend")
    public List<DailySum> searchTransTrend(@RequestParam("id") Integer id, Model model){
        model.addAttribute("id",id);
        return transcationService.searchTransTrend(id);
    }

    @ResponseBody
    @PostMapping("/user/getId")
    public int getUserId(@RequestParam("useraddr") String useraddr){
        return userService.getUserIdByAddr(useraddr);
    }


    @ResponseBody
    @GetMapping("/user/getInAndOut")
    public List<Integer> getUserInAndOut(@RequestParam("useraddr") String useraddr){
        return userService.getUserInAndOut(useraddr);
    }

    @ResponseBody
    @GetMapping("/user/getCircle")
    public List<CirclePo> getUserCircle(@RequestParam("useraddr")String useraddr){
        return userService.getUserCircle(useraddr);
    }
}
