package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Model.ProcessedM;



@Component
public class ProcessedMDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(ProcessedM processedM)
	{
		Integer i=(Integer) this.hibernateTemplate.save(processedM);
		return i;
	}
	public ProcessedM getRaw(int id)
	{
		ProcessedM processedM=this.hibernateTemplate.get(ProcessedM.class, id);
		return processedM;
	}
	public List<ProcessedM> getAllRaw()
	{
		List<ProcessedM> processedM=this.hibernateTemplate.loadAll(ProcessedM.class);
		return processedM;
	}
	@Transactional
	public void deleteRaw(int id)
	{
		ProcessedM processedM=this.hibernateTemplate.get(ProcessedM.class, id);
		this.hibernateTemplate.delete(processedM);
	}
	
	
	@Transactional
	public void update(ProcessedM processedM)
	{
		this.hibernateTemplate.update(processedM);
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

}
