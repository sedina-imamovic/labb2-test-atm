package bih.iths.sedina.labb2test.controller;

import bih.iths.sedina.labb2test.service.ATMService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ATMController {

    private final ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/saldo")
    public String getSaldo(Model model) {
        model.addAttribute("saldo", atmService.getSaldo());
        return "saldo";
    }
}
