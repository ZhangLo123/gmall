package com.example.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.beans.PmsBaseCatalog1;
import com.example.gmall.beans.PmsBaseCatalog2;
import com.example.gmall.beans.PmsBaseCatalog3;
import com.example.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin//跨域访问的注解
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> catalog1List = catalogService.getcatalog1();
        return catalog1List;
    }

    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2( String catalog1Id){

        List<PmsBaseCatalog2> catalog2List = catalogService.getcatalog2(catalog1Id);
        return catalog2List;
    }

    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

        List<PmsBaseCatalog3> catalog3List = catalogService.getcatalog3(catalog2Id);
        return catalog3List;
    }

}
