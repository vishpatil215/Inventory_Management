package com.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dao.LogsRawDao;
import com.Model.LogsRaw;

@Controller
public class LogsRawController {
	
	@RequestMapping("/viewlograw")
	public String view(Model m)
	{
		ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
		LogsRawDao logsRawDao=(LogsRawDao) c.getBean("logsRawDao");
		List<LogsRaw> logsRaw=logsRawDao.getAll();
		m.addAttribute("logsRaw", logsRaw);
		return "viewlograw";
	}

}
