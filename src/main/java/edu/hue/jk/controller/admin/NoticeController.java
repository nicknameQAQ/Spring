package edu.hue.jk.controller.admin;

import edu.hue.jk.mapper.NoticeMapper;
import edu.hue.jk.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin/notices")
public class NoticeController {

    @Autowired
    private NoticeMapper noticeMapper;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("noticeList", noticeMapper.findAll());
        return "admin/notices/list";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("notice", new Notice());
        return "admin/notices/add";
    }

    @RequestMapping("/edit")
    public String edit(Model model, int nId) {
        model.addAttribute("notice", noticeMapper.findById(nId));
        return "admin/notices/edit";
    }

    @RequestMapping("/save")
    public String save(Notice notice) {
        String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        notice.setNTime(now);

        if (notice.getNId() == null) {
            noticeMapper.insert(notice);
        } else {
            noticeMapper.update(notice);
        }

        return "redirect:/admin/notices/list";
    }

    @RequestMapping("/del")
    public String delete(int nId) {
        noticeMapper.delete(nId);
        return "redirect:/admin/notices/list";
    }
}