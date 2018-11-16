package com.ghj.service;

import java.util.List;
import tk.mybatis.mapper.entity.Condition;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 * Created by zhh on 2017/09/18.
 */
public interface MyService<T,K> {

    public void save(T model) throws IllegalAccessException, InstantiationException;

    public void save(List<T> models) throws IllegalAccessException, InstantiationException;

    public void deleteById(Integer id);

    public void deleteByIds(String ids);

    public void update(T model) throws IllegalAccessException, InstantiationException;

    public T findById(Integer id) throws IllegalAccessException, InstantiationException;

    /**
     * 根据id批量查询
     */
    public List<T> findByIds(String ids) throws IllegalAccessException, InstantiationException;

    /**
     * 根据多条件查询
     */
    public List<T> findByCondition(Condition condition) throws IllegalAccessException, InstantiationException;

    /**
     * 查询全部
     */
    public List<T> findAll() throws IllegalAccessException, InstantiationException;


    /**
     * 这个方法不好（不想使用）
     */
    @SuppressWarnings("unchecked")
    @Deprecated
    public T findBy(String fieldName, Object value);
}
