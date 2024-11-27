package com.workpage.repository;

import com.yourpackage.model.WorkInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkInformationRepositoryJDBC implements WorkInformationRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<WorkInformation> workInfoMapper;

    public WorkInformationRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.workInfoMapper = (rs, rowNum) -> new WorkInformation(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("resource_link")
        );
    }

    @Override
    public void save(WorkInformation workInfo) {
        String sql = "INSERT INTO work_information (title, description, resource_link) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, workInfo.getTitle(), workInfo.getDescription(), workInfo.getResourceLink());
    }

    @Override
    public List<WorkInformation> getAll() {
        String sql = "SELECT * FROM work_information";
        return jdbcTemplate.query(sql, workInfoMapper);
    }
}
package com.yourpackage.controller;

import com.yourpackage.model.WorkInformation;
import com.yourpackage.repository.WorkInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkInformationController {

    @Autowired
    private WorkInformationRepository workInformationRepository;

    @GetMapping("/addWork")
    public ModelAndView showAddWorkForm() {
        ModelAndView mav = new ModelAndView("addWork.html");
        mav.addObject("workInfo", new WorkInformation(null, "", "", ""));
        return mav;
    }

    @PostMapping("/saveWork")
    public String saveWork(@ModelAttribute WorkInformation workInfo) {
        workInformationRepository.save(workInfo);
        return "redirect:/viewWork";
    }

    @GetMapping("/viewWork")
    public ModelAndView viewWork() {
        ModelAndView mav = new ModelAndView("viewWork.html");
        mav.addObject("workInfoList", workInformationRepository.getAll());
        return mav;
    }
}