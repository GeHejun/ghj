package service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/12.
 */
@Service
public class GhjAuthorityUserConsumerServiceImpl extends AbstractService<GhjAuthorityUser> implements GhjAuthorityUserService {

    @Autowired
    private GhjAuthorityUserMapper ghjAuthorityUserMapper;

}
