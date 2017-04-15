package cn.kanyun.cpa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import cn.kanyun.cpa.dao.ICommonDao;
import cn.kanyun.cpa.dao.impl.CommonDaoImpl;
import cn.kanyun.cpa.pojo.CpaResult;
import cn.kanyun.cpa.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommonServiceImpl<K extends Serializable, T extends Serializable>
        implements ICommonService<K, T> {
    //	此处不可添加@Resource注解,添加之后，当有多个类实现一个接口会报NoUniqueBeanDefinitionException异常，
// 我想如果添加了@Resource注解，那么他便会将其添加进Spring容易造成多个bean的情况，下面的注释是原作者写的，暂且不管
//    在不加任何注解的情况下，虽然启动不报错了，但是在实际运行在会报空指针异常，即common为null，那么就说名这个commondao
//    没有注入到容器中，然而添加 @Autowired注解之后一切正常，@Resource注解默认是按名称装配Autowire默认按照类型装配，但是
//    @Resource(type = ICommonDao.class)这样写理论上与@Autowired一样，但是还会报错，不知为何
    @Autowired
    private ICommonDao<K, T> commondao; // 从容器中注入session工厂【无需get,set方法】

    public K save(T t) {
        return commondao.save(t);
    }

    @Override
    public void saveAll(Collection<T> ct) {
        commondao.saveAll(ct);
    }

    @Override
    public T findById(K id) {
        return commondao.findById(id);
    }

    @Override
    public T update(T t) {
        return commondao.update(t);
    }

    @Override
    public T saveOrUpdate(T t) {
        return commondao.saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        commondao.delete(t);
    }

    @Override
    public void deleteAll(Collection<T> ct) {
        commondao.deleteAll(ct);
    }

    @Override
    public boolean deleteById(K id) {
        return commondao.deleteById(id);
    }

    @Override
    public CpaResult<T> loadAll() {
        return commondao.loadAll();
    }

    @Override
    public CpaResult<T> load(int page, int rows) {
        return commondao.load(page, rows);
    }

    @Override
    public long getTotalCount() {
        return commondao.getTotalCount();
    }

    /****************************** HQL ******************************/

    @Override
    public CpaResult<T> getScrollData() {
        return commondao.getScrollData();
    }

    @Override
    public CpaResult<T> getScrollData(int firstResult, int maxResult) {
        return commondao.getScrollData(firstResult, maxResult);
    }

    @Override
    public CpaResult<T> getScrollData(int firstResult, int maxResult,
                                      LinkedHashMap<String, String> orderby) {
        return commondao.getScrollData(firstResult, maxResult, orderby);
    }

    @Override
    public CpaResult<T> getScrollData(int firstResult, int maxResult,
                                      String where, Object[] params) {
        return commondao.getScrollData(firstResult, maxResult, where, params);
    }

    @Override
    public CpaResult<T> getScrollData(int firstResult, int maxResult,
                                      String where, Object[] params, LinkedHashMap<String, String> orderby) {
        return commondao.getScrollData(firstResult, maxResult, where, params,
                orderby);
    }
}
