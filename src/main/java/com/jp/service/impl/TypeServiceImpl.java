package com.jp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.mapper.TypeMapper;
import com.jp.mapper.TypeMapperCustom;
import com.jp.po.Type;
import com.jp.po.TypeCustom;
import com.jp.service.TypeService;
import com.jp.utils.PageUtil;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapperCustom typeMapperCustom;
	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public List<TypeCustom> getTypeList(String name_descripton) throws Exception {
		
		return typeMapperCustom.getTypeList(name_descripton);
	}

	@Override
	public List<TypeCustom> getTypeListByPage(Integer pageNum, Integer numPerPage) throws Exception {
		//根据页号和每页数量计算起始点
		int startNum = numPerPage*(pageNum-1);
		return typeMapperCustom.getTypeListLimit(startNum, numPerPage);
	}

	@Override
	public int getTypeTotalCount() throws Exception {
		
		return typeMapperCustom.getTypeTotalCount();
	}

	@Override
	public int getTypePagetotalNum() throws Exception {
		
		 int total = this.getTypeTotalCount();
		 if(total%PageUtil.NumPerPageInBack==0){
			 return total/PageUtil.NumPerPageInBack; 
		 }else{
			 return total/PageUtil.NumPerPageInBack + 1;
		 }
	}

	@Override
	public void deleteTypeById(Integer id) throws Exception {
		typeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Type getTypeById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void modifyTypeById(Type type) throws Exception {
		typeMapper.updateByPrimaryKeySelective(type);
	}

	@Override
	public void addType(Type type) throws Exception {
		typeMapper.insertSelective(type);
	}

}
