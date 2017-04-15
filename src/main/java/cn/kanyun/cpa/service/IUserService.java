package cn.kanyun.cpa.service;

import java.io.Serializable;

import javax.annotation.Resource;

import cn.kanyun.cpa.dao.ICommonDao;
import cn.kanyun.cpa.pojo.CpaResult;
import cn.kanyun.cpa.pojo.CpaUser;

public interface IUserService extends ICommonService <Integer,CpaUser> {
	public static final String SERVICE_NAME="cn.kanyun.cpa.service.impl.UserServiceImpl";
	CpaResult checkLogin(String username, String password);
}
