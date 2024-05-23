package com.university.departmentmanagement;

import com.university.departmentmanagement.config.SecurityConfig;
import com.university.departmentmanagement.controller.DepartmentController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DepartmentController.class)
@Import(SecurityConfig.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentController departmentController;

    private List<String> departments;

    @BeforeEach
    public void setUp() {
        departments = new ArrayList<>();
        departments.add("Computer Science");
        departments.add("Mathematics");
    }

    @Test
    @WithMockUser
    public void testDepartments() throws Exception {
        given(departmentController.departments()).willReturn(new ModelAndView("departments").addObject("departmentsList", departments));

        MvcResult mvcResult = mockMvc.perform(get("/departments"))
                .andExpect(status().isOk())
                .andExpect(view().name("departments"))
                .andExpect(model().attributeExists("departmentsList"))
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        assertThat(modelAndView).isNotNull();
        assertThat(modelAndView.getViewName()).isEqualTo("departments");
        assertThat(modelAndView.getModel().get("departmentsList")).isEqualTo(departments);
    }

}
