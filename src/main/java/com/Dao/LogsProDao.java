package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Model.LogsPro;

@Component
public class LogsProDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insert(LogsPro logsPro)
	{
		this.hibernateTemplate.save(logsPro);
	}
	public LogsPro get(int id)
	{
		LogsPro logsPro=this.hibernateTemplate.get(LogsPro.class, id);
		return logsPro;
	}
	public List<LogsPro> getAll()
	{
		List<LogsPro> logsPro = this.hibernateTemplate.loadAll(LogsPro.class);
		return logsPro;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
