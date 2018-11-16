package com.ghj.service;



import com.ghj.core.dto.BaseDTO;
import com.ghj.dao.MyMapper;
import com.ghj.entity.Model;
import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 *
 * @Author GeHejun
 */
public abstract class AbstractProviderService<T extends BaseDTO, K extends Model> {

    @Autowired
    protected MyMapper<K> mapper;


    private Class<K> kClass;

    private Class<T> tClass;

    public AbstractProviderService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        tClass = (Class<T>) pt.getActualTypeArguments()[0];
        kClass = (Class<K>) pt.getActualTypeArguments()[1];
    }

    /**
     * 保存
     */
    public void save(T model) throws IllegalAccessException, InstantiationException {
        K k = kClass.newInstance();
        BeanUtils.copyProperties(model, k);
        mapper.insertSelective(k);
    }

    /**
     * 批量保存
     */
    public void save(List<T> models) throws IllegalAccessException, InstantiationException {
        List<K> ks = Lists.newArrayList();
        for (T t : models) {
            K k = kClass.newInstance();
            BeanUtils.copyProperties(t, k);
            ks.add(k);
        }
        mapper.insertList(ks);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    /**
     * 更新
     */
    public void update(T model) throws IllegalAccessException, InstantiationException {
        K k = kClass.newInstance();
        BeanUtils.copyProperties(model, k);
        mapper.updateByPrimaryKeySelective(k);
    }

    public T findById(Integer id) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        K k = mapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(k, t);
        return t;
    }

    /**
     * 这个方法不好（不想使用）
     */
    @SuppressWarnings("unchecked")
    @Deprecated
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            K model = kClass.newInstance();
            Field field = kClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            K k = mapper.selectOne(model);
            T t = tClass.newInstance();
            BeanUtils.copyProperties(k, t);
            return t;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("查询操作异常!");
        }
    }

    /**
     * 根据id批量查询
     */
    public List<T> findByIds(String ids) throws IllegalAccessException, InstantiationException {
        List<K> ks = mapper.selectByIds(ids);
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
    public List<T> findByCondition(Condition condition) throws IllegalAccessException, InstantiationException {
        List<K> ks = mapper.selectByCondition(condition);
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
    public List<T> findAll() throws IllegalAccessException, InstantiationException {
        List<K> ks = mapper.selectAll();
        List<T> ts = Lists.newArrayList();
        for (K k : ks) {
            T t = tClass.newInstance();
            BeanUtils.copyProperties(k, t);
            ts.add(t);
        }
        return ts;
    }
}
