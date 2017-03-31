package com.cypc.tgdc.cddc.ad.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cypc.tgdc.cddc.ad.dao.DutyDao;
import com.cypc.tgdc.cddc.ad.model.Dutylog;

public class DutyDaoImpl implements DutyDao {
    SessionFactory sessionFactory =null;
	@Override
	public List<Dutylog> findAllRecords() {
		List<Dutylog> result = new ArrayList<Dutylog>();
		Session sess  = sessionFactory.openSession();
		Query query = sess.createQuery("from Dutylog");
		List<?> datas = query.list();
		System.out.println("the size is :" + datas.size());
        if(datas != null ){
        	Iterator<?> iteratorDatas = datas.iterator();
        	while(iteratorDatas.hasNext()){
        		Dutylog data = (Dutylog)iteratorDatas.next();
        		result.add(data);
        	}
        }
        sess.close();
		return result;
	}
	
	@Override
	public void saveDutylog(Dutylog log) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(log);
		tx.commit();
		sess.close();		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
