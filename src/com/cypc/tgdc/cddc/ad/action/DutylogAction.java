package com.cypc.tgdc.cddc.ad.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cypc.tgdc.cddc.ad.bean.DutyLogBean;
import com.cypc.tgdc.cddc.ad.model.Dutylog;
import com.cypc.tgdc.cddc.ad.service.DutyLogService;
import com.opensymphony.xwork2.ActionSupport;

public class DutylogAction extends ActionSupport{
	   private List<DutyLogBean> result;
       public String execute(){
    	   System.out.println("获取日志记录");
    	   WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
           DutyLogService server = ctx.getBean("dutyLogServer", DutyLogService.class);
           result = server.findAllRecords();
//           result = JSONSerializer.toJSON(logs).toString();

    	   return SUCCESS;
       }
       

       
       public List<DutyLogBean> getResult() {
		return result;
	}


	public void setResult(List<DutyLogBean> result) {
		this.result = result;
	}


	public static void main(String[] args){
    	   Dutylog log = new Dutylog();
    	   log.setId(1);
    	   log.setTime(new Date());
    	   log.setDescription("ddd");
    	   log.setRecorde_time(new Date());
    	   String[] dd={"1","2014","dd","2014"};
    	   
    	   List<Dutylog> logs =new ArrayList<Dutylog>();
    	   logs.add(log);
    	   logs.add(log);
    	   String result = JSONSerializer.toJSON(logs).toString();
    	   System.out.println(result);
    	   
       }
}