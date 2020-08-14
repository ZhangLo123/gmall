package com.example.gmall.service;

import com.example.gmall.beans.PmsProductInfo;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> getspuList(String catalog3Id);
}
