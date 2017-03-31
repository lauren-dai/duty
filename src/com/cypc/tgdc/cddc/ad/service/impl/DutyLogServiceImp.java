package com.cypc.tgdc.cddc.ad.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cypc.tgdc.cddc.ad.bean.DutyLogBean;
import com.cypc.tgdc.cddc.ad.dao.DutyDao;
import com.cypc.tgdc.cddc.ad.model.Dutylog;
import com.cypc.tgdc.cddc.ad.service.DutyLogService;

public class DutyLogServiceImp implements DutyLogService {
      private DutyDao dutyDao= null;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public List<DutyLogBean> findAllRecords() {
		List<DutyLogBean> logs = new ArrayList<DutyLogBean>();
		List<Dutylog> lists = dutyDao.findAllRecords();
		Iterator iterator = lists.iterator();
		while(iterator.hasNext()){		
			Dutylog record = (Dutylog)iterator.next();
			DutyLogBean log = new DutyLogBean();
			log.setId(String.valueOf(record.getId()));
			log.setTime(sdf.format(record.getTime()));
			log.setDescription(record.getDescription());
			log.setRecorder(record.getRecorder());
			log.setRecorde_time(sdf.format(record.getRecorde_time()));
			log.setSolver(record.getSolver());
			log.setType(record.getSystype());			
			logs.add(log);
		}		
		return logs;
	}


	@Override
	public void save(DutyLogBean bean) {
		try{
		Dutylog log = new Dutylog();
		log.setDescription(bean.getDescription());
		log.setRecorde_time(new Date());
		log.setRecorder(bean.getRecorder());
		log.setSystype(bean.getType());
		log.setSolver(bean.getSolver());
		log.setTime(sdf.parse(bean.getTime()+":00"));
		
	   dutyDao.saveDutylog(log);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public DutyDao getDutyDao() {
		return dutyDao;
	}

	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}

//	public static void main(String[] args) throws Exception{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.parse("2014-09-16 06:25:00"));
//	}
}
