package com.cypc.tgdc.cddc.ad.dao;

import java.util.List;

import com.cypc.tgdc.cddc.ad.model.Dutylog;

public interface DutyDao {
	
	public List<Dutylog> findAllRecords();
	public void saveDutylog(Dutylog log);

}
