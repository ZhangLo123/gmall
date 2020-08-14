package com.example.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.gmall.beans.PmsBaseCatalog1;
import com.example.gmall.beans.PmsBaseCatalog2;
import com.example.gmall.beans.PmsBaseCatalog3;
import com.example.gmall.manage.mapper.PmsCatalog1Mapper;
import com.example.gmall.manage.mapper.PmsCatalog2Mapper;
import com.example.gmall.manage.mapper.PmsCatalog3Mapper;
import com.example.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsCatalog1Mapper pmsCatalog1Mapper;

    @Autowired
    PmsCatalog2Mapper pmsCatalog2Mapper;

    @Autowired
    PmsCatalog3Mapper pmsCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getcatalog1() {

        return pmsCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getcatalog2(String catalog1Id) {
        PmsBaseCatalog2 pbc2 = new PmsBaseCatalog2();
        pbc2.setCatalog1Id(catalog1Id);
        return pmsCatalog2Mapper.select(pbc2);
    }

    @Override
    public List<PmsBaseCatalog3> getcatalog3(String catalog2Id) {
        PmsBaseCatalog3 pbc3 = new PmsBaseCatalog3();
        pbc3.setCatalog2Id(catalog2Id);
        return pmsCatalog3Mapper.select(pbc3);
    }
}
