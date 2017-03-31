package com.cypc.tgdc.cddc.ad.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cypc.tgdc.cddc.ad.bean.DayColumnBean;
import com.cypc.tgdc.cddc.ad.bean.MonthColumnBean;
import com.cypc.tgdc.cddc.ad.bean.NameColumnBean;
import com.cypc.tgdc.cddc.ad.bean.PieBean;
import com.cypc.tgdc.cddc.ad.bean.TimeColumnBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnRecord;
import com.cypc.tgdc.cddc.ad.dao.ChartDao;
import com.cypc.tgdc.cddc.ad.model.Dutylog;
import com.cypc.tgdc.cddc.ad.service.ChartService;

public class ChartServiceImpl implements ChartService{
    private ChartDao chartDao;
    private String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    private   String[] times= {"00:00~01:00","01:00~02:00","02:00~03:00","03:00~04:00","04:00~05:00","05:00~06:00","06:00~07:00","07:00~08:00","08:00~09:00","09:00~10:00",
    		"10:00~11:00","11:00~12:00","12:00~13:00","13:00~14:00","14:00~15:00","15:00~16:00","16:00~17:00","17:00~18:00","18:00~19:00","19:00~20:00","20:00~21:00",
    		"21:00~22:00","22:00~23:00","23:00~24:00"};
    private String[] days={"Mon","Tue","Wen","Thu","Fri","Sat","Sun"};
	@Override
	public List<PieBean> getPieChartData() {
		List<PieBean> beans = chartDao.getPieData();
		return beans;
	}
	@Override
	public List<MonthColumnBean> getMonthColumnData() {
		List<MonthColumnBean> beans = new ArrayList<MonthColumnBean>();
		Map<String,Integer> set = chartDao.getMonthColumnData();
		for(int i = 0; i < months.length ;i++){
			MonthColumnBean bean = new MonthColumnBean();
			bean.setMonth(months[i]);
			if(set.get(months[i])==null){
				bean.setNumber(0);
			}else{
				bean.setNumber(set.get(months[i]));
			}
			beans.add(bean);
		}
		
		return beans;
	}
	
	@Override
	public List<NameColumnBean> getNameColumnData() {
		
		return chartDao.getNameColumnData();
	}
	
	
	@Override
	public List<TimeColumnBean> getTimeColumnData() {
		List<TimeColumnBean> beans = new ArrayList<TimeColumnBean>();
		Map<String,Integer> set = chartDao.getTimeColumnData();
		for(int i = 0; i < times.length ;i++){
			String key = times[i].substring(0,2);
			TimeColumnBean bean = new TimeColumnBean();
			bean.setTime(times[i]);
			if(set.get(key)==null){
				bean.setNumber(0);
			}else{
				
				bean.setNumber(set.get(key));
			}
			beans.add(bean); 
		}
		
		return beans;
	}
	
	@Override
	public List<TotalColumnBean> getTotalColumnData() {
		List<TotalColumnBean> beans = generateList();
		Map<String,Integer> records = chartDao.getTotalColumnData();
        for(int i = 0; i < beans.size();i++){
        	long timemillis = beans.get(i).getTime();
        	Date date = new Date(timemillis);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String key = sdf.format(date);

        	Integer number = records.get(key.substring(5, 10));
        	if(number != null){
        	     beans.get(i).setNumber(number);
        	}
        }
		return beans;
	}
	
	@Override
	public List<DayColumnBean> getDayColumnData() {
		List<DayColumnBean> beans = new ArrayList<DayColumnBean>();
		Map<String,Integer> set = chartDao.getDayColumnData();

		for(int i = 0; i < days.length ;i++){
			DayColumnBean bean = new DayColumnBean();
			bean.setDay(days[i]);
			if(set.get(days[i])==null){
				bean.setNumber(0);
			}else{
				bean.setNumber(set.get(days[i]));
			}
			beans.add(bean);
		}
		
		return beans;
	}

	
	public ChartDao getChartDao() {
		return chartDao;
	}
	public void setChartDao(ChartDao chartDao) {
		this.chartDao = chartDao;
	}
	
	private  List<TotalColumnBean> generateList(){
		List<TotalColumnBean> beans = new ArrayList<TotalColumnBean>();
		try{
		Calendar cal = getTheFirstDayOfYear();
		Date now = new Date();
		while(cal.getTimeInMillis()<= now.getTime()){
			TotalColumnBean bean = new TotalColumnBean();
			bean.setTime(cal.getTime().getTime());
			bean.setNumber(0);
			beans.add(bean);
			cal.add(Calendar.DATE, 1);
		}
		cal.add(Calendar.DATE, 1);
		}catch(Exception e){
			return null;
		}
		return beans;
	}
	
	private  Calendar getTheFirstDayOfYear(){
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		try{
		cal.setTime(now);
		int year = cal.get(Calendar.YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date firstDate = sdf.parse(String.valueOf(year));
		cal.setTime(firstDate);
		}catch(Exception e){
			e.printStackTrace();
		}
		return cal;
	}
	

	public static void main(String[] args) throws Exception{
		Date date = new Date();
		
		date.setTime(1388506600000l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		System.out.println(sdf.format(date));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf2.parse("2014-01-01");
		System.out.println(date2.getTime());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = getTheFirstDayOfYear();
//        System.out.println(sdf.format(cal.getTime()));
	}

}
