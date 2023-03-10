package org.zerock.springMVC.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springMVC.dto.PageRequestDTO;
import org.zerock.springMVC.dto.TodoDTO;
import org.zerock.springMVC.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping(value = "/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info("todo list..." + pageRequestDTO);

        if (bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));

    }

    @GetMapping("/register")
    public void register() {
        log.info("todo register...");
    }

    @PostMapping("/register")
    public String register(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("POST todo register...");

        if (bindingResult.hasErrors()) {
            log.info("has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long tno, PageRequestDTO pageRequestDTO, Model model) {

        TodoDTO todoDTO = todoService.getOne(tno);

        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);

    }

    @PostMapping("/remove")
    public String remove(long tno, PageRequestDTO pageRequestDTO) {

        log.info("----------------remove---------------");
        log.info("tno : " + tno);

        todoService.remove(tno);

        return "redirect:/todo/list?" + pageRequestDTO.getLink();
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("tno", todoDTO.getTno());

        return "redirect:/todo/read";
    }

}
