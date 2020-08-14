package com.example.gmall.service;

import com.example.gmall.beans.UmsMember;
import com.example.gmall.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByUserId(String memberId);
}
