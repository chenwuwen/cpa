package cn.kanyun.cpa.dao.impl;
import cn.kanyun.cpa.dao.IUnitExamDao;
import cn.kanyun.cpa.pojo.CpaRepertory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by KANYUN on 2017/4/13.
 */
@Repository(IUnitExamDao.SERVICE_NAME)
public class UnitExamDaoImpl extends CommonDaoImpl<Integer, CpaRepertory> implements IUnitExamDao {
    //通过调用父类的构造函数指定clazz值，即实体类的类类型
    public UnitExamDaoImpl() {
        super(CpaRepertory.class);
    }


}
