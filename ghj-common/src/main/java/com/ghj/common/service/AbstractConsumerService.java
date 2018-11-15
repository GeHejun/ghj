package com.ghj.common.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.dto.BaseDTO;
import com.ghj.common.vo.BaseVO;
import com.google.common.collect.Lists;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Condition;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
@Component
public abstract class AbstractConsumerService<T extends BaseVO, K extends BaseDTO> implements com.ghj.service.Service<T> {

    @Reference
    protected AbstractProviderService abstractProviderService;

    Class<T> tClass;

    Class<K> kClass;

    public AbstractConsumerService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        tClass = (Class<T>) pt.getActualTypeArguments()[0];

        kClass = (Class<K>) pt.getActualTypeArguments()[1];
    }

    public void save(T model) throws IllegalAccessException, InstantiationException {
        K k = kClass.newInstance();
        BeanUtils.copyProperties(model, k);
        abstractProviderService.save(k);
    }
    @Override
    public void save(List<T> models) throws IllegalAccessException, InstantiationException {
        List<K> ks = Lists.newArrayList();
        for (T t : models) {
            K k = kClass.newInstance();
            BeanUtils.copyProperties(t, k);
            ks.add(k);
        }
        abstractProviderService.save(ks);
    }
    @Override
    public void deleteById(Integer id) {
        abstractProviderService.deleteById(id);
    }

    @Override
    public void deleteByIds(String ids) {
        abstractProviderService.deleteByIds(ids);
    }


    public void update(T model) throws IllegalAccessException, InstantiationException {
        K k = kClass.newInstance();
        BeanUtils.copyProperties(model, k);
        abstractProviderService.update(k);
    }

    @Override
    public T findById(Integer id) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        K k = (K) abstractProviderService.findById(id);
        BeanUtils.copyProperties(k, t);
        return t;
    }

    /**
     * 根据id批量查询
     */
    @Override
    public List<T> findByIds(String ids) throws IllegalAccessException, InstantiationException {
        List<K> ks = abstractProviderService.findByIds(ids);
        List<T> ts = Lists.newArrayList();
        for (K k : ks) {
            T t = tClass.newInstance();
            BeanUtils.copyProperties(k, t);
            ts.add(t);
        }
        return ts;
    }

    /**
     * 根据多条件查询
     */
    @Override
    public List<T> findByCondition(Condition condition) throws IllegalAccessException, InstantiationException {
        List<K> ks = abstractProviderService.findByCondition(condition);
        List<T> ts = Lists.newArrayList();
        for (K k : ks) {
            T t = tClass.newInstance();
            BeanUtils.copyProperties(k, t);
            ts.add(t);
        }
        return ts;
    }

    /**
     * 查询全部
     */
    @Override
    public List<T> findAll() throws IllegalAccessException, InstantiationException {
        List<K> ks = abstractProviderService.findAll();
        List<T> ts = Lists.newArrayList();
        for (K k : ks) {
            T t = tClass.newInstance();
            BeanUtils.copyProperties(k, t);
            ts.add(t);
        }
        return ts;
    }


    /**
     * 这个方法不好（不想使用）
     */
    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {

        try {
            K k = (K) abstractProviderService.findBy(fieldName, value);
            T t = tClass.newInstance();
            BeanUtils.copyProperties(k, t);
            return t;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("查询操作异常!");
        }
    }
}
