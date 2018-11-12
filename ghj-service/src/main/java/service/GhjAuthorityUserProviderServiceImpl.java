package service;

import com.ghjwh.dao.mapper.authority.GhjAuthorityUserMapper;
import com.ghjwh.model.authority.GhjAuthorityUser;
import com.ghjwh.service.authority.GhjAuthorityUserService;
import com.ghjwh.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/12.
 */
@Service
public class GhjAuthorityUserProviderServiceImpl extends AbstractService<GhjAuthorityUser> implements GhjAuthorityUserService {

    @Autowired
    private GhjAuthorityUserMapper ghjAuthorityUserMapper;

}
