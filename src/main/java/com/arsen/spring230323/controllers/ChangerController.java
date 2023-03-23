package com.arsen.spring230323.controllers;

import com.arsen.spring230323.dto.ChangerDTO;
import com.arsen.spring230323.services.ChangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/changer")
public class ChangerController {
    private final ChangerService changerService;

    @Autowired
    public ChangerController(ChangerService changerService) {
        this.changerService = changerService;
    }

    @GetMapping
    public String main(@ModelAttribute("change") ChangerDTO changerDTO) {
        return "changer";
    }


    @GetMapping("/convert")
    public String change(@ModelAttribute("change") ChangerDTO changerDTO, Model model) throws Exception {
        model.addAttribute("result",
                changerService.change(changerDTO.getCurrency(), changerDTO.getAmount()));

        return "show";
    }

    @GetMapping("/get")
    public String getCurrencies(Model model) throws Exception {
        model.addAttribute("currencies", changerService.getCurrencies());

        return "currencies";
    }

}
