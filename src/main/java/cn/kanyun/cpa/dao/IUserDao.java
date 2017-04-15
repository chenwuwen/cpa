package cn.kanyun.cpa.dao;

import cn.kanyun.cpa.pojo.CpaUser;

public interface IUserDao extends ICommonDao<Integer,CpaUser>{
	public static final String SERVICE_NAME="cn.kanyun.cpa.dao.impl.UserDaoImpl";
}
