package com.example.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.beans.UmsMember;
import com.example.gmall.beans.UmsMemberReceiveAddress;
import com.example.gmall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UmsMemberController {

    @Reference
    private UmsMemberService umsMemberService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello user";
    }


    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers = umsMemberService.getAllUser();

        return umsMembers;
    }

    @RequestMapping("/getReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByUserId(String memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberService.getReceiveAddressByUserId(memberId);

        return umsMemberReceiveAddresses;
    }


}
