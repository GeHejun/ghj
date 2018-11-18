package ${basePackage}.com.ghj.com.ghj.service.impl.${sign};

import ${basePackage}.com.ghj.com.ghj.controller.authority.dao.mapper.${sign}.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${sign}.${modelNameUpperCamel};
import ${basePackage}.com.ghj.com.ghj.service.${sign}.${modelNameUpperCamel}Service;
import ${basePackage}.com.ghj.com.ghj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ProviderServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
