package Inq2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/study")
    public String study() {
        return "main_screen";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/study";
    }

}
