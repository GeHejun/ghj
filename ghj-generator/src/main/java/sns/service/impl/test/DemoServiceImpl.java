package sns.service.impl.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sns.dao.mapper.test.DemoMapper;
import sns.model.test.Demo;
import sns.service.AbstractService;
import sns.service.test.DemoService;

/**
 *
 * Created by zhh on 2017/09/27.
 */
@Service
public class DemoServiceImpl extends AbstractService<Demo> implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

}
