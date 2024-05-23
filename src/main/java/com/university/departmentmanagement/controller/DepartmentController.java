package com.university.departmentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {
    private final List<String> departments = new ArrayList<>();

    @GetMapping("/departments")
    public ModelAndView departments() {
        ModelAndView modelAndView = new ModelAndView("departments");
        modelAndView.addObject("departmentsList", departments);
        return modelAndView;
    }

    @PostMapping("/departments")
    public String addDepartment(@RequestParam String departmentName) {
        departments.add(departmentName);
        return "redirect:/departments";
    }

    @GetMapping("/departments/delete/{index}")
    public String deleteDepartment(@PathVariable int index) {
        if (index >= 0 && index < departments.size()) {
            departments.remove(index);
        }
        return "redirect:/departments";
    }

}