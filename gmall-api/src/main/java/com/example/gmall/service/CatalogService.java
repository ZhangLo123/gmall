package com.example.gmall.service;

import com.example.gmall.beans.PmsBaseCatalog1;
import com.example.gmall.beans.PmsBaseCatalog2;
import com.example.gmall.beans.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {

    List<PmsBaseCatalog1> getcatalog1();

    List<PmsBaseCatalog2> getcatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getcatalog3(String catalog1Id);
}
