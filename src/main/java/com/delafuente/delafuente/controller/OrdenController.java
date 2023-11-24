package com.delafuente.delafuente.controller;


import com.delafuente.delafuente.model.Orden;

import com.delafuente.delafuente.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdenController {
    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping("/ordenes")
    public String ordenes(Model model) {
        List<Orden> ordenes = ordenRepository.findAll();
        model.addAttribute("ordenes",ordenes);
        return "ordenes";
    }
}
