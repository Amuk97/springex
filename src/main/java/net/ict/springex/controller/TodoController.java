package net.ict.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor

public class TodoController {


        private final TodoService todoService;



        @RequestMapping("/list")
        public void list(Model model){
            log.info("todo list............");
            model.addAttribute("dtoList",todoService.getAll());
            //model에는 'dtoList' 이름으로 목록 데이터가 담겨 있다.

        }
        @RequestMapping(value = "/register" , method = RequestMethod.GET)
        public void register(){
            log.info("todo register........");
        }

        //todo/register 를 POST방식으로 처리하는 메소드 TodoDTO를 파라미터로 적용
        @PostMapping("/register")
        public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
            log.info("POST todo register.......");

            if(bindingResult.hasErrors()){
                log.error("has errors.....");
                redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
                return "redirect:/todo/register";
            }

            log.info(todoDTO);
            todoService.register(todoDTO);
            return "redirect:/todo/list";
        }

}
