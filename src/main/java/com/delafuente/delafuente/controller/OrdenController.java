package com.delafuente.delafuente.controller;


import com.delafuente.delafuente.model.*;

import com.delafuente.delafuente.repository.CategoriaRepository;
import com.delafuente.delafuente.repository.ClienteRepository;
import com.delafuente.delafuente.repository.OrdenRepository;
import com.delafuente.delafuente.repository.ProfesionalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class OrdenController {
    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProfesionalRepository profesionalRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/ordenes")
    public String ordenes(Model model, @ModelAttribute("filtro") Filtro filtro) {
        List<Orden> ordenes;
        if (filtro.getDesde() != null && filtro.getHasta() != null) {
            ordenes = ordenRepository.findByFechaBetween(filtro.getDesde(),filtro.getHasta());
        } else {
            ordenes = ordenRepository.findAll();
        }
        model.addAttribute("ordenes", ordenes);
        return "ordenes";
    }



    @PostMapping("/filtrarOrdenes")
    public String filtrarOrdenes(@ModelAttribute("filtro") Filtro filtro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String desde = filtro.getDesde() != null ? filtro.getDesde().format(formatter) : "";
        String hasta = filtro.getHasta() != null ? filtro.getHasta().format(formatter) : "";

        return "redirect:/ordenes?" + "desde=" + desde + "&hasta=" + hasta;
    }

    @GetMapping("/nueva_orden")
    public String nuevaOrden(Model model) {
        model.addAttribute("orden", new Orden());


        List<Cliente> clientes = clienteRepository.findAll();
        List<Profesional> profesionales = profesionalRepository.findAll();
        List<Categoria> categorias = categoriaRepository.findAll();

        model.addAttribute("clientes", clientes);
        model.addAttribute("profesionales", profesionales);
        model.addAttribute("categorias", categorias);

        return "nueva_orden";
    }



    @PostMapping("/guardarOrden")
    public String guardarOrden(@ModelAttribute("orden") @Valid Orden orden, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Cliente> clientes = clienteRepository.findAll();
            List<Profesional> profesionales = profesionalRepository.findAll();
            List<Categoria> categorias = categoriaRepository.findAll();

            model.addAttribute("clientes", clientes);
            model.addAttribute("profesionales", profesionales);
            model.addAttribute("categorias", categorias);

            return "nueva_orden";
        }
        ordenRepository.save(orden);
        return "redirect:/ordenes";
    }

}
