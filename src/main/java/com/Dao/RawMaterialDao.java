package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Model.RawMaterial;

@Component
public class RawMaterialDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(RawMaterial rawMaterial)
	{
		Integer i=(Integer) this.hibernateTemplate.save(rawMaterial);
		return i;
	}
	public RawMaterial getRaw(int id)
	{
		RawMaterial rawMaterial=this.hibernateTemplate.get(RawMaterial.class, id);
		return rawMaterial;
	}
	public List<RawMaterial> getAllRaw()
	{
		List<RawMaterial> rawMaterial=this.hibernateTemplate.loadAll(RawMaterial.class);
		return rawMaterial;
	}
	@Transactional
	public void deleteRaw(int id)
	{
		RawMaterial rawMaterial=this.hibernateTemplate.get(RawMaterial.class, id);
		this.hibernateTemplate.delete(rawMaterial);
	}
	
	@Transactional
	public void update(RawMaterial rawMaterial)
	{
		this.hibernateTemplate.update(rawMaterial);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
