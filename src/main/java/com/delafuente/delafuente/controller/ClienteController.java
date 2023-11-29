package com.delafuente.delafuente.controller;

import com.delafuente.delafuente.model.Cliente;
import com.delafuente.delafuente.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/nuevo_cliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "nuevo_cliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "nuevo_cliente";
        }
        clienteRepository.save(cliente);
        return "redirect:/nueva_orden";
    }

    @PostMapping("/eliminarCliente")
    public String eliminarCliente(@RequestParam("dni") Long dni) {

        clienteRepository.deleteById(dni);
        return "redirect:/clientes";
    }
}
