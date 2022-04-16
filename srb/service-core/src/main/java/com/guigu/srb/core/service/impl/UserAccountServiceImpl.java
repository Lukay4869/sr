package com.guigu.srb.core.service.impl;

import com.guigu.srb.core.pojo.entity.UserAccount;
import com.guigu.srb.core.mapper.UserAccountMapper;
import com.guigu.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
