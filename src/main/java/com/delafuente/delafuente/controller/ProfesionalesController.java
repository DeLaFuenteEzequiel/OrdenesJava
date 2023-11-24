package com.delafuente.delafuente.controller;


import com.delafuente.delafuente.model.Profesional;
import com.delafuente.delafuente.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProfesionalesController {
    @Autowired
    private ProfesionalRepository profesionalRepository;

    @GetMapping("/profesionales")
    public String profesionales(Model model) {
        List<Profesional> profesionales = profesionalRepository.findAll();
        model.addAttribute("profesionales",profesionales);
        return "profesionales";
    }
}

