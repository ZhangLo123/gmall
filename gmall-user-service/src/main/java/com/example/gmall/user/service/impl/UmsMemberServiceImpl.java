package com.example.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.gmall.beans.UmsMember;
import com.example.gmall.beans.UmsMemberReceiveAddress;
import com.example.gmall.user.mapper.UmsMemberMapper;
import com.example.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.example.gmall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
//        List<UmsMember> umsMembers = umsMemberMapper.selectUser();
        List<UmsMember> umsMembers = umsMemberMapper.selectAll();

        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByUserId(String memberId) {

        //通用mapper里的方法example，一个
//        Example example = new Example(UmsMemberReceiveAddress.class);
//        example.createCriteria().andEqualTo("memberId",memberId);
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = umsMemberReceiveAddressMapper.selectByExample(example);
        //封装的参数对象
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        return umsMemberReceiveAddressList;
    }
}
