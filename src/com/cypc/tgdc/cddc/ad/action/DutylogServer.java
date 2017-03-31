package com.cypc.tgdc.cddc.ad.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cypc.tgdc.cddc.ad.bean.DutyLogBean;
import com.cypc.tgdc.cddc.ad.service.DutyLogService;
import com.opensymphony.xwork2.ActionSupport;

public class DutylogServer extends ActionSupport{
	 private String time;
	 private String desc;
	 private String recorder;
	 private String solver;
	 private String systype;
	
      public String execute(){
    	  System.out.println("time" + time);
    	  System.out.println("desc" + desc);
    	  System.out.println("recorder" + recorder);
    	  System.out.println("solver" + solver);
    	  System.out.println("systype" + systype);
   
    	  DutyLogBean bean = new DutyLogBean();
    	  bean.setDescription(desc);
    	  bean.setRecorder(recorder);
    	  bean.setSolver(solver);
    	  bean.setTime(time);
    	  bean.setType(systype);
    	  WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
          DutyLogService server = ctx.getBean("dutyLogServer", DutyLogService.class);
          server.save(bean);
    	  return SUCCESS;
      }

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public String getSolver() {
		return solver;
	}

	public void setSolver(String solve) {
		this.solver = solve;
	}

	public String getSystype() {
		return systype;
	}

	public void setSystype(String systype) {
		this.systype = systype;
	}
}
