package com.cypc.tgdc.cddc.ad.dao;

import java.util.List;
import java.util.Map;

import com.cypc.tgdc.cddc.ad.bean.NameColumnBean;
import com.cypc.tgdc.cddc.ad.bean.PieBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnRecord;

public interface ChartDao {
     public List<PieBean> getPieData();
     public Map<String,Integer> getMonthColumnData();
     public List<NameColumnBean> getNameColumnData();
     public Map<String,Integer> getTimeColumnData();
     public Map<String,Integer> getTotalColumnData();
     public Map<String,Integer> getDayColumnData();
}
