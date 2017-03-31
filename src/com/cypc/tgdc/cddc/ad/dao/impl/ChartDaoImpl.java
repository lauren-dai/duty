package com.cypc.tgdc.cddc.ad.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cypc.tgdc.cddc.ad.bean.MonthColumnBean;
import com.cypc.tgdc.cddc.ad.bean.NameColumnBean;
import com.cypc.tgdc.cddc.ad.bean.PieBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnRecord;
import com.cypc.tgdc.cddc.ad.dao.ChartDao;
import com.cypc.tgdc.cddc.ad.model.Dutylog;

public class ChartDaoImpl implements ChartDao {
    private SessionFactory sessionFactory = null;
    private String[]  days={"Sun","Mon","Tue","Wen","Thu","Fri","Sat"};
	@Override
	public List<PieBean> getPieData() {
		List<PieBean> beans = new ArrayList<PieBean>();
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("select systype,count(systype) from Dutylog t where systype is not null group by systype ");
		List<?> lists = query.list();
		Iterator<?> iterator = lists.iterator();
		while(iterator.hasNext()){
			Object[] result = (Object[])iterator.next();
			PieBean bean = new PieBean();
			bean.setTypename((String)result[0]);
			bean.setNumber(String.valueOf(result[1]));
			beans.add(bean);
		}
		sess.close();
		return beans;
	}
	
	@Override
	public Map<String,Integer> getMonthColumnData() {
		Map<String,Integer> set = new HashMap<String,Integer>();
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("select to_char(time,'MM') as time ,id from Dutylog where systype is not null group by time,id order by time desc");
		List<?> lists = query.list();
		Iterator<?> iterator = lists.iterator();
		while(iterator.hasNext()){
			Object[] result = (Object[])iterator.next();
			String key = (String)result[0];
			if(set.get(key)==null){
				set.put(key, 1);
			}else{
				int number = set.get(key);
				set.put(key, ++number);
			}

		}
		sess.close();
		return set;
	}
	
	@Override
	public List<NameColumnBean> getNameColumnData() {
		List<NameColumnBean> beans = new ArrayList<NameColumnBean>();
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("select recorder,count(recorder) from Dutylog where systype is not null group by recorder ");
		
		List<?> lists = query.list();
		Iterator<?> iterator = lists.iterator();
		while(iterator.hasNext()){
			Object[] result = (Object[]) iterator.next();
		    NameColumnBean bean = new NameColumnBean();
		    bean.setName((String)result[0]);
		    bean.setNumber(((Long)result[1]).intValue());
		    beans.add(bean);
		}
		return beans;
	}
	
	@Override
	public Map<String,Integer> getTimeColumnData() {
		Map<String,Integer> set = new HashMap<String,Integer>();
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("select to_char(time,'HH24') from Dutylog where systype is not null group by time ,id order by time desc");
		List<?> lists = query.list();
		Iterator<?> iterator = lists.iterator();
		while(iterator.hasNext()){
			String key = (String)iterator.next();
			if(set.get(key)==null){
				set.put(key, 1);
			}else{
				int number = set.get(key);
				set.put(key, ++number);
			}

		}
		sess.close();
		return set;
	}

	@Override
	public Map<String,Integer> getTotalColumnData() {
		Map<String,Integer> records = new HashMap<String,Integer>();
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("select to_char(time,'mm-dd') as time,description from Dutylog order by time desc ");
		List<?> lists = query.list();
		Iterator<?> iterator = lists.iterator();
		while(iterator.hasNext()){
			Object[] result = (Object[]) iterator.next();
			String key = (String)result[0];
			String description = (String)result[1];
			if(records.get(key)==null){
				if(description.contains("正常")&&!description.contains("事由")){
					records.put(key, 0);
				}else{
					records.put(key, 1);
				}	
			}else{
				int number = records.get(key);
				records.put(key, ++number);
			}		
		}
		sess.close();
		return records;
	}

	
	@Override
	public Map<String, Integer> getDayColumnData() {
		Map<String,Integer> set = new HashMap<String,Integer>();
		Session sess = sessionFactory.openSession();
		try{		
		Query query = sess.createQuery("select to_char(time,'yyyy-MM-dd') as time ,id from Dutylog where systype is not null group by time,id order by time desc");
		List<?> lists = query.list();
		Iterator<?> iterator = lists.iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		while(iterator.hasNext()){
			Object[] result = (Object[])iterator.next();
			String dateStr = (String)result[0];
			Date date = sdf.parse(dateStr);
			cal.setTime(date);
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			String key = days[dayOfWeek-1];
			if(set.get(key)==null){
				set.put(key, 1);
			}else{
				int number = set.get(key);
				set.put(key, ++number);
			}

		}}catch(Exception e){
			e.printStackTrace();
		}
		sess.close();
		return set;
	}


	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	




}
