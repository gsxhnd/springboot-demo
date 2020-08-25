package xyz.gsxhnd.springboot-demo.api.service.impl;

import xyz.gsxhnd.springboot-demo.api.entity.LdUser;
import xyz.gsxhnd.springboot-demo.api.mapper.LdUserMapper;
import xyz.gsxhnd.springboot-demo.api.service.ILdUserService;
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
