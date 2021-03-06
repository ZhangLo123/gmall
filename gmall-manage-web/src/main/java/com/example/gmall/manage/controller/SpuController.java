package com.example.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.beans.PmsBaseAttrInfo;
import com.example.gmall.beans.PmsBaseAttrValue;
import com.example.gmall.beans.PmsProductInfo;
import com.example.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;


    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfoList = spuService.getspuList(catalog3Id);

        return pmsProductInfoList;
    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpu(@RequestBody PmsProductInfo pmsProductInfo){

        
        return "success";
    }
}
