package com.guigu.srb.core.service.impl;

import com.guigu.srb.core.pojo.entity.UserInfo;
import com.guigu.srb.core.mapper.UserInfoMapper;
import com.guigu.srb.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
