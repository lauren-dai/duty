package com.cypc.tgdc.cddc.ad.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cypc.tgdc.cddc.ad.bean.DayColumnBean;
import com.cypc.tgdc.cddc.ad.bean.MonthColumnBean;
import com.cypc.tgdc.cddc.ad.bean.NameColumnBean;
import com.cypc.tgdc.cddc.ad.bean.PieBean;
import com.cypc.tgdc.cddc.ad.bean.TimeColumnBean;
import com.cypc.tgdc.cddc.ad.bean.TotalColumnBean;
import com.cypc.tgdc.cddc.ad.service.ChartService;
import com.opensymphony.xwork2.ActionSupport;

public class ChartAction extends ActionSupport{
	private List<PieBean> beans;
	private List<MonthColumnBean> monthcolumns;
	private List<NameColumnBean> namecolumns;
	private List<TimeColumnBean>  timecolumns;
	private List<TotalColumnBean> totalcolumns;
	private List<DayColumnBean> daycolumns;
      public String getPieChart(){
    	  System.out.println("获取pie图形");
    	  WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
          ChartService server = ctx.getBean("chartServer", ChartService.class);
          
           beans = server.getPieChartData();
          return SUCCESS;
      }
     public String MonthColumnChart(){
    	  System.out.println("获取monthcolumn图形");
    	  WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
          ChartService server = ctx.getBean("chartServer", ChartService.class);
          monthcolumns = server.getMonthColumnData();
          return SUCCESS;
     }
     public String NameColumnChart(){
    	 System.out.println("获取NameColumn图形");
    	 WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
         ChartService server = ctx.getBean("chartServer", ChartService.class);
         namecolumns = server.getNameColumnData();
         return SUCCESS;
     }
     
     public String TimeColumnChart(){
    	 System.out.println("获取TimeColumn图形");
    	 WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
         ChartService server = ctx.getBean("chartServer", ChartService.class);
         timecolumns = server.getTimeColumnData();
         return SUCCESS;
     }
     public String TotalColumnChart(){
    	 System.out.println("获取TotalColumn图形");
    	 WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
         ChartService server = ctx.getBean("chartServer", ChartService.class);
         totalcolumns = server.getTotalColumnData();
         return SUCCESS;
     }
     
     public String DayColumnChart(){
    	 System.out.println("获取DayColumn图形");
    	 WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
         ChartService server = ctx.getBean("chartServer", ChartService.class);
         daycolumns = server.getDayColumnData();
         return SUCCESS;
     }
      
      public String execute(){
    	  return SUCCESS;
      }
      
	public List<PieBean> getBeans() {
		return beans;
	}
	public void setBeans(List<PieBean> beans) {
		this.beans = beans;
	}

	public List<MonthColumnBean> getMonthcolumns() {
		return monthcolumns;
	}

	public void setMonthcolumns(List<MonthColumnBean> monthcolumns) {
		this.monthcolumns = monthcolumns;
	}
	public List<NameColumnBean> getNamecolumns() {
		return namecolumns;
	}
	public void setNamecolumns(List<NameColumnBean> namecolumns) {
		this.namecolumns = namecolumns;
	}
	public List<TimeColumnBean> getTimecolumns() {
		return timecolumns;
	}
	public void setTimecolumns(List<TimeColumnBean> timeclolumns) {
		this.timecolumns = timeclolumns;
	}
	public List<TotalColumnBean> getTotalcolumns() {
		return totalcolumns;
	}
	public void setTotalcolumns(List<TotalColumnBean> totalcolumns) {
		this.totalcolumns = totalcolumns;
	}
	public List<DayColumnBean> getDaycolumns() {
		return daycolumns;
	}
	public void setDaycolumns(List<DayColumnBean> daycolumns) {
		this.daycolumns = daycolumns;
	}
}
