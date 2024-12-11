package mvn.controler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvn.dto.Employee;
import mvn.service.EmployeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeService servic;
	
	@GetMapping({ "/", "/home" })
	public String lodehome()
	{
		return "home.jsp";
	}
	
	@GetMapping("/add")
	public String add()
	{
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String add(Employee employe,ModelMap map)
	{
		return servic.add(employe,map);
	}
	
	@RequestMapping("/fetch")
	public String fetch(ModelMap map)
	{
		return servic.fetch(map);
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id,ModelMap map)
	{
		 return servic.delete(id,map);
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id,ModelMap map)
	{
		return servic.edit(id,map);
	}
	
	@PostMapping("/update")
	public String update(Employee employee,ModelMap map)
	{
		return servic.update(employee, map);
	}

}
