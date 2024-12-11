package mvn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import mvn.dao.Employeedao;
import mvn.dto.Employee;

@Service
public class EmployeService {
	
	@Autowired
	Employeedao dao;

	public String add(Employee employee,ModelMap map)
	{
		dao.save(employee);
		map.put("Success", "Record Added Success");
		return "home.jsp";
	}
	
	public String fetch(ModelMap map)
	{
		List<Employee> list=dao.fetchAll();
		if(list.isEmpty())
		{
			map.put("Failure", "No Record Found");
			return "home.jsp";
		}
		else {
			map.put("list", list);
			return "fetch.jsp";
		}
	}

	public String delete(int id, ModelMap map) {
		Employee employee=dao.find(id);
		dao.delete(employee);
		map.put("success","Record Delete Success");
		return "fetch";
		
		
		
	}

	public String edit(int id, ModelMap map) {
		Employee employee=dao.find(id);
		map.put("list", employee);
		return "update.jsp";
	}

	public String update(Employee employee, ModelMap map) {
		dao.update(employee);
		map.put("success","Employee Record updated Success");
		return "fetch";
	}
}
