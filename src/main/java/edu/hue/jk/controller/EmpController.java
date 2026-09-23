package edu.hue.jk.controller;

import edu.hue.jk.mapper.EmpMapper;
import edu.hue.jk.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

    @Autowired
    private EmpMapper empMapper;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("empList", empMapper.selectAll());
        return "emp_list";
    }

    @RequestMapping("/add")
    public String add() {
        return "emp_add";
    }

    @RequestMapping("/edit")
    public String edit(Model model, String empno) {
        model.addAttribute("emp", empMapper.selectByEmpno(empno));
        return "emp_edit";
    }

    @RequestMapping("/save")
    public String save(Emp emp) {
        String empno = String.valueOf(emp.getEmpno());

        if (empMapper.selectByEmpno(empno) == null) {
            empMapper.insert(emp);
        } else {
            empMapper.update(emp);
        }

        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(String empno) {
        empMapper.deleteByEmpno(empno);
        return "redirect:/list";
    }
}