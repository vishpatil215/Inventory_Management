package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.Dao.LogsProDao;
import com.Dao.LogsRawDao;
import com.Dao.ProcessedMDao;
import com.Dao.RawMaterialDao;
import com.Model.LogsPro;
import com.Model.LogsRaw;
import com.Model.ProcessedM;
import com.Model.RawMaterial;


@Controller
public class ProcessedMController {
	
	
	@RequestMapping("/procesM")
	public String page()
	{
		return "procesM";
	}
	
	@RequestMapping("/addPro")
	public String addpr(@ModelAttribute ProcessedM processedM , HttpServletRequest request)
	{
		ApplicationContext c= new ClassPathXmlApplicationContext("config.xml");
		ProcessedMDao processedMDao=(ProcessedMDao) c.getBean("processedMDao");
		
		processedMDao.insert(processedM);
		return "dashboard";
	}
	@RequestMapping("/viewPro")
	public String viewRawpage(Model m)
	{
		ApplicationContext c= new ClassPathXmlApplicationContext("config.xml");
		ProcessedMDao processedMDao=(ProcessedMDao) c.getBean("processedMDao");
		
		List<ProcessedM> processedM=processedMDao.getAllRaw();
		m.addAttribute("processedM",processedM);
		return "viewPro";
	}
	@RequestMapping("/unpro")
	public String unRawpage(Model m)
	{
		ApplicationContext c= new ClassPathXmlApplicationContext("config.xml");
		ProcessedMDao processedMDao=(ProcessedMDao) c.getBean("processedMDao");
		
		List<ProcessedM> processedM=processedMDao.getAllRaw();
		m.addAttribute("processedM",processedM);
		return "unpro";
	}
	@RequestMapping(path="/deletep/{id}",method=RequestMethod.GET)
	public RedirectView deleteRaw(@PathVariable("id") int id,HttpServletRequest request)
	{
		ApplicationContext c= new ClassPathXmlApplicationContext("config.xml");
		ProcessedMDao processedMDao=(ProcessedMDao) c.getBean("processedMDao");
		
		processedMDao.deleteRaw(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewPro");
		return redirectView;
	}
	@RequestMapping(value="/updatepro",method=RequestMethod.GET)
	public String updatepage(@RequestParam int pid,Model m)
	{
		m.addAttribute("pid", pid);
		return "updatepro";
	}

	@RequestMapping("/insertPq")
	public RedirectView updatepro(HttpServletRequest request)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		ProcessedMDao processedMDao=(ProcessedMDao) c.getBean("processedMDao");
		 
		
		int new_quantity=Integer.parseInt(request.getParameter("quantity"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProcessedM upprocess=processedMDao.getRaw(pid);
		upprocess.setQuantity(upprocess.getQuantity()+new_quantity);
		
		processedMDao.update(upprocess);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewPro");
		return redirectView;
	}
	@RequestMapping(value="/issuepro",method=RequestMethod.GET)
	public String issuepro(@RequestParam int prid,Model m)
	{
		m.addAttribute("prid", prid);
		return "issuepro";
	}
	@RequestMapping("/issuedpro")
	public RedirectView issue(HttpServletRequest request)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		ProcessedMDao processedMDao=(ProcessedMDao) c.getBean("processedMDao");
		 LogsProDao logsProDao=(LogsProDao ) c.getBean("logsProDao");
		 LogsPro logsPro=(LogsPro) c.getBean("logsPro");
		int new_quantity=Integer.parseInt(request.getParameter("quantity"));
		String iname=request.getParameter("iname");
		int tid=Integer.parseInt(request.getParameter("prid"));
		int sid=Integer.parseInt(request.getParameter("sid"));
		String date=request.getParameter("date");
		ProcessedM issueprocessedM=processedMDao.getRaw(tid);
		if(issueprocessedM.getQuantity()>=new_quantity)
		{
			issueprocessedM.setQuantity(issueprocessedM.getQuantity()-new_quantity);
			processedMDao.update(issueprocessedM);
		logsPro.setId(sid);
		logsPro.setIname(iname);
		logsPro.setItemid(tid);
		logsPro.setDate(date);
		logsPro.setQuantity(new_quantity);
		logsPro.setCost(issueprocessedM.getCostPerUnit());
		logsPro.setItemname(issueprocessedM.getName());
		logsProDao.insert(logsPro);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewPro");
		return redirectView;
		}
		else{
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/fail2");
			return redirectView;
		}
	}
	@RequestMapping("/fail2")
	public String f()
	{
		return "fail";
	}
}
