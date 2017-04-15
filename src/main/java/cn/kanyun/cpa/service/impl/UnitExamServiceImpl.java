package cn.kanyun.cpa.service.impl;

import cn.kanyun.cpa.dao.IUnitExamDao;
import cn.kanyun.cpa.pojo.CpaRepertory;
import cn.kanyun.cpa.service.IUnitExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by KANYUN on 2017/3/18.
 */
@Service(IUnitExamService.SERVICE_NAME)
public class UnitExamServiceImpl extends CommonServiceImpl<Integer,CpaRepertory> implements IUnitExamService {
    @Resource(name = IUnitExamDao.SERVICE_NAME)
    private IUnitExamDao unitExamDao;
}
