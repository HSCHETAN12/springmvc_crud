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
}
