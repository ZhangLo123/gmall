package com.example.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.gmall.beans.PmsBaseAttrInfo;
import com.example.gmall.beans.PmsBaseAttrValue;
import com.example.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.example.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.example.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);

        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        String id = pmsBaseAttrInfo.getId();
        if (StringUtil.isEmpty(id)){
            //id为空，保存

            //保存属性（主键返回策略，插入之后会返回一个新的主键在pmsBaseAttrInfo里面）
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);//insertSelective将非空字段插入数据库，空的不插入。

            //保存属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            //attrValueList.for--for循环的快捷键
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());//设置属性id
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }else {
            //id不为空，修改
            //属性
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

            //属性值修改
            //按照属性id删除所有属性值
            PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

            //删除后，将新的属性值插入
            List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrValueList) {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

            }

        }


        return "success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }

}
