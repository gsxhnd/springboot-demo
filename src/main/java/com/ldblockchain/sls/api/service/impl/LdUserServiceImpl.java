package com.ldblockchain.sls.api.service.impl;

import com.ldblockchain.sls.api.entity.LdUser;
import com.ldblockchain.sls.api.mapper.LdUserMapper;
import com.ldblockchain.sls.api.service.ILdUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-11-23
 */
@Service
public class LdUserServiceImpl extends ServiceImpl<LdUserMapper, LdUser> implements ILdUserService {

}
