package util;



import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.kanyun.cpa.pojo.CpaRepertory;
import cn.kanyun.cpa.pojo.CpaOption;
import cn.kanyun.cpa.pojo.CpaSolution;
import cn.kanyun.cpa.pojo.CpaUser;
import cn.kanyun.cpa.util.HibernateSessionFactory;

public class TestHibernet {
	//获得log4j的记录器
	private Logger logger = Logger.getLogger(TestHibernet.class);
	public static void main(String[]args){
	
	}
	@Test
	public void getSessionFactory(){
		SessionFactory sessionfactory = HibernateSessionFactory.getSessionFactory();
		System.out.println(sessionfactory);
	}
	@Test
	public void getsession(){
		Session session1 = HibernateSessionFactory.getSessionFactory().openSession();
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		logger.info(session);
		System.out.println(session1);
	}
	@Test
	public void getCpaUser(){
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CpaUser CpaUser = (CpaUser) session.get(CpaUser.class, 1);
	 	System.out.println(CpaUser);
		//System.out.println(1/0);
	}
	@Test
	public void saveCpaUser(){
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		CpaUser u = new CpaUser();
		u.setPetName("kanyun");
		u.setPassword("kanyun");
		u.setPetName("自傲名");
		session.save(u);
		u.setPetName("1234");
		tx.commit();
		
	}
	@Test
	public  void getCpaUser1(){	
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(CpaUser.class);
		Criterion criterion = Restrictions.like("username", "a%");
		criteria = criteria.add(criterion);
		List<CpaUser> list = criteria.list();
		for (CpaUser CpaUser:list){
			System.out.println(CpaUser.getUsername());
		}
	}
	@Test
	public void  examOfHql(){
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		CpaRepertory  td =new  CpaRepertory();
		String hql="from CpaRepertory";
		Query query = session.createQuery(hql);
		List<CpaRepertory> list = query.list();
		for (int i =0;i<list.size();i++){
			logger.info(list.get(i).getTestStem());
			Set set = list.get(i).getCpaOptions();
			Iterator<CpaOption> it = set.iterator();
			while (it.hasNext()){
				logger.info(it.next().getOptionData());
			}
		}
	}
	@Test
    public void  examOfCriteria(){
        Session session = HibernateSessionFactory.getSession();
        Criteria criteria = session.createCriteria(CpaRepertory.class);
        List<CpaRepertory> list = criteria.list();
        System.out.println(list.size());
        for (CpaRepertory td:list){
            logger.info(td.getTestStem());
            Set<CpaOption> set =  td.getCpaOptions();
            for (CpaOption to:set){
                logger.info(to.getSelectData()+"  "+to.getOptionData());
            }
        }
    }
    @Test
    public void  encapsulationObbjectInCollection(){
        Session session = HibernateSessionFactory.getSession();
        Criteria criteria = session.createCriteria(CpaRepertory.class);
        List<CpaRepertory> list = criteria.list();
        List<Map<String,Object>>   listShowExam = new ArrayList<Map<String,Object>>();
        for (CpaRepertory td:list){
        	Map<String ,Object> map = new HashMap<String, Object>();
        	map.put("stem",td.getTestStem());
        	map.put("tr_id",td.getId());
        	List<String> listOptioins = new ArrayList<String>();
            Set<CpaOption> set =  td.getCpaOptions();
            for (CpaOption to:set){
				listOptioins.add(to.getOptionData());
            }
            map.put("options",listOptioins);
			listShowExam.add(map);
        }
        logger.info(listShowExam.toString());
    }

	@Test
	public void savetdandtoandre(){
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		CpaRepertory td = new CpaRepertory();
//		session.save(td);0
		CpaOption to = new CpaOption(td, "A", "将有余额的账户的余额直接记入新账余额栏内");
		CpaOption to1 =new CpaOption(td,"B","编制记账凭证，将余额结转下年");
		CpaOption to2 =new CpaOption(td,"C","将余额记入本年账户的借或贷方，将本年有余额的账户的余额为零");
		CpaOption to3 =new CpaOption(td,"D","将其余额转入应收或应付明细分类账中，作为往来账挂账");
		CpaSolution tr = new CpaSolution(td, "A");
		session.save(to);
		session.save(to1);
		session.save(to2);
		session.save(to3);
		session.save(tr);
		tx.commit();
		session.close();
	}

}
