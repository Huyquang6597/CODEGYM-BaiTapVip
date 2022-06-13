package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @GetMapping("/sandwich")
    public String getCondiments(){
        return "index";
    }

@PostMapping("/condiment")
    public String condiment(@RequestParam(name = "condiment1",required = false,defaultValue = "") String condiment1, Model model){
            model.addAttribute("name",condiment1);
            return "condiment";
}
    }
