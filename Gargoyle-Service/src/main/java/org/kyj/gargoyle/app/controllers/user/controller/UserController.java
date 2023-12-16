/**
 * 
 */
package org.kyj.gargoyle.app.controllers.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kyj.gargoyle.app.controllers.user.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

/**
 * 
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

	/**
	 * @param id
	 * @return
	 */
	@Operation(summary = "임직원 정보 조회", description = "임직원 정보 조회") // API 정보 설정
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> list() {
		return createList();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Employee get(@RequestParam(value = "id", required = true) String id) {
		Optional<Employee> any = createList().stream().filter(v -> v.getEmpId().equals(id)).findAny();
		if (any.isPresent())
			return any.get();
		return null;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}
}
