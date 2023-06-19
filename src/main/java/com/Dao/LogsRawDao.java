package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Model.LogsRaw;

@Component
public class LogsRawDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insert(LogsRaw logsRaw)
	{
		this.hibernateTemplate.save(logsRaw);
	}
	public LogsRaw get(int id)
	{
		LogsRaw logsRaw=this.hibernateTemplate.get(LogsRaw.class, id);
		return logsRaw;
	}
	public List<LogsRaw> getAll()
	{
		List<LogsRaw> logsRaw = this.hibernateTemplate.loadAll(LogsRaw.class);
		return logsRaw;
	}

}
