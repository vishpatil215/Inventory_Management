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

import com.Dao.LogsRawDao;
import com.Dao.RawMaterialDao;
import com.Model.LogsRaw;
import com.Model.RawMaterial;

@Controller
public class RawMaterialController {
	
	
	@RequestMapping("/addRaw")
	public String insert(@ModelAttribute RawMaterial rawMaterial,HttpServletRequest request)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
		
		rawMaterialDao.insert(rawMaterial);
		return "dashboard";
	}
	@RequestMapping("/viewRaw")
	public String viewRawpage(Model m)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
		
		List<RawMaterial> rawMaterial=rawMaterialDao.getAllRaw();
		m.addAttribute("rawMaterial",rawMaterial);
		return "viewRaw";
	}
	@RequestMapping("/unraw")
	public String unRawpage(Model m)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
		
		List<RawMaterial> rawMaterial=rawMaterialDao.getAllRaw();
		m.addAttribute("rawMaterial",rawMaterial);
		return "unraw";
	}
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public RedirectView deleteRaw(@PathVariable("id") int id,HttpServletRequest request)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
		
		rawMaterialDao.deleteRaw(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewRaw");
		return redirectView;
	}
	
	@RequestMapping(value="/updateR",method=RequestMethod.GET)
	public String updatepage(@RequestParam int id,Model m)
	{
		m.addAttribute("id", id);
		return "updateR";
	}
	@RequestMapping("/insertQ")
	public RedirectView updateRaw(HttpServletRequest request)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
		 
		
		int new_quantity=Integer.parseInt(request.getParameter("quantity"));
		int id=Integer.parseInt(request.getParameter("id"));
		RawMaterial uprawMaterial=rawMaterialDao.getRaw(id);
		uprawMaterial.setQuantity(uprawMaterial.getQuantity()+new_quantity);
		
		rawMaterialDao.update(uprawMaterial);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewRaw");
		return redirectView;
	}
	@RequestMapping(value="/issueR",method=RequestMethod.GET)
	public String issueRaw(@RequestParam int tid,Model m)
	{
		m.addAttribute("tid", tid);
		return "issueR";
	}
	@RequestMapping("/issuedR")
	public RedirectView issue(HttpServletRequest request)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
		 LogsRawDao logsRawDao=(LogsRawDao) c.getBean("logsRawDao");
		 LogsRaw logsRaw=(LogsRaw) c.getBean("logsRaw");
		int new_quantity=Integer.parseInt(request.getParameter("quantity"));
		String iname=request.getParameter("iname");
		int tid=Integer.parseInt(request.getParameter("tid"));
		int sid=Integer.parseInt(request.getParameter("sid"));
		String date=request.getParameter("date");
		RawMaterial issuerawMaterial=rawMaterialDao.getRaw(tid);
		if(issuerawMaterial.getQuantity()>=new_quantity)
		{
		issuerawMaterial.setQuantity(issuerawMaterial.getQuantity()-new_quantity);
		rawMaterialDao.update(issuerawMaterial);
		logsRaw.setId(sid);
		logsRaw.setIname(iname);
		logsRaw.setItemid(tid);
		logsRaw.setDate(date);
		logsRaw.setQuantity(new_quantity);
		logsRaw.setCost(issuerawMaterial.getCostPerUnit());
		logsRaw.setItemname(issuerawMaterial.getName());
		logsRawDao.insert(logsRaw);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewRaw");
		return redirectView;
		}
		else
		{
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/fail");
			return redirectView;
		}
	}
	@RequestMapping("/fail")
	public String fail()
	{
		return "fail";
	}

}
