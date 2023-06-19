package com.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dao.LogsProDao;
import com.Model.LogsPro;

@Controller
public class LogsProController {
	
	@RequestMapping("/viewlogpro")
	public String view(Model m)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		LogsProDao logsProDao=(LogsProDao) c.getBean("logsProDao");
		List<LogsPro> logsPro=logsProDao.getAll();
		m.addAttribute("logsPro", logsPro);
		return "viewlogpro";
	}


}
