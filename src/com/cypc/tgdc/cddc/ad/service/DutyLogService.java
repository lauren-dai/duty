package com.cypc.tgdc.cddc.ad.service;

import java.util.List;

import com.cypc.tgdc.cddc.ad.bean.DutyLogBean;
import com.cypc.tgdc.cddc.ad.model.Dutylog;

public interface DutyLogService {
     public List<DutyLogBean> findAllRecords();
     public void save(DutyLogBean bean);
}
