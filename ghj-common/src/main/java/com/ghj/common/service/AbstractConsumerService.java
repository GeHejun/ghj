package com.ghj.common.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.common.mapper.MyMapper;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Condition;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
@Component
public abstract class AbstractConsumerService<T> {

    @Reference
    protected AbstractProviderService abstractProviderService;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractConsumerService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model) {
        abstractProviderService.save(model);
    }

    public void save(List<T> models) {
        abstractProviderService.save(models);
    }

    public void deleteById(Integer id) {
        abstractProviderService.deleteById(id);
    }

    public void deleteByIds(String ids) {
        abstractProviderService.deleteByIds(ids);
    }

    public void update(T model) {
        abstractProviderService.update(model);
    }

    public T findById(Integer id) {
        return (T)abstractProviderService.findById(id);
    }

    public List<T> findByIds(String ids) {
        return abstractProviderService.findByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return abstractProviderService.findByCondition(condition);
    }

    public List<T> findAll() {
        return abstractProviderService.findAll();
    }
}
