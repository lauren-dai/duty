package com.cypc.tgdc.cddc.ad.service;

import java.util.List;

import com.cypc.tgdc.cddc.ad.bean.DayColumnBean;
import com.cypc.tgdc.cddc.ad.bean.MonthColumnBean;
import com.cypc.tgdc.cddc.ad.bean.NameColumnBean;
import com.cypc.tgdc.cddc.ad.bean.PieBean;
import com.cypc.tgdc.cddc.ad.bean.TimeColumnBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnBean;

public interface ChartService {
      public List<PieBean> getPieChartData();
      public List<MonthColumnBean> getMonthColumnData();
      public List<NameColumnBean> getNameColumnData();
      public List<TimeColumnBean> getTimeColumnData();
      public List<TotalColumnBean> getTotalColumnData();
      public List<DayColumnBean> getDayColumnData();
}
