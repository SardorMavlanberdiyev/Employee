package com.example.demo.controller;

import com.example.demo.entity.EmployeeModel;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @RequestMapping({"/", ""})
    public String getList(Model model) {
        model.addAttribute("employees", employeeService.read());
        return "employee/list";
    }

    @RequestMapping("/addForm")
    public String addForm(Model model) {
        model.addAttribute("addEmployee", new EmployeeModel());
        return "employee/form-layout";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute EmployeeModel employeeModel) {
        employeeService.save(employeeModel);
        return "redirect:/employee";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        EmployeeModel employeeModel = employeeService.getById(id);
        model.addAttribute("addEmployee", employeeModel);
        return "employee/form-layout";
    }
    


}
