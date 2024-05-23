package com.university.departmentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class DepartmentController {

    @GetMapping("/departments")
    public ModelAndView departments() {
        // Повернення списку департаментів
        List<String> departments = List.of("Computer Science", "Mathematics");
        return new ModelAndView("departments").addObject("departmentsList", departments);
    }

    @PostMapping("/departments")
    public RedirectView addDepartment(@RequestParam String departmentName) {
        // Додавання нового департаменту
        return new RedirectView("/departments");
    }

    @GetMapping("/departments/delete/1")
    public RedirectView deleteDepartment(@RequestParam int id) {
        // Видалення департаменту
        return new RedirectView("/departments");
    }
}
