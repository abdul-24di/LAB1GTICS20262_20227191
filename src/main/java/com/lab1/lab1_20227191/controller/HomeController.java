package com.lab1.lab1_20227191.controller;

import com.lab1.lab1_20227191.model.equipo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static List<equipo> equipos = new ArrayList<>();

    static {
        equipos.add(new equipo("Laptop ASUS ROG", "Laptop", "ABC1235456A", "2026-09-22"));
        equipos.add(new equipo("PC HP", "PC", "ABC1235456B", "2026-01-29"));
        equipos.add(new equipo("Servidor CISCO", "Servidor", "ABC1235456C", "2026-02-01"));
        equipos.add(new equipo("Laptop Macbook pro", "Laptop", "ABC1235456D", "2026-03-18"));
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/equipo/registro";
    }

    @GetMapping("/equipos/registrar")
    public String registrarEquipo(@RequestParam String nombre,
                                  @RequestParam String tipo,
                                  @RequestParam String codigoActivo,
                                  @RequestParam String fechaAdquisicion) {
        if(nombre.isBlank() || tipo.isBlank() || codigoActivo.isBlank() || fechaAdquisicion.isBlank()){
            return "redirect:/equipos/registro?error=Todos los campos son obligatorios";
        }
        for(equipo e :equipos){
            if(e.getCodigoActivo().equalsIgnoreCase(codigoActivo)){
                return "redirect:/equipos/registro?error=El codigo de activo ya existe";
            }
        }
        equipos.add(new equipo(nombre, tipo, codigoActivo, fechaAdquisicion));
        return "redirect:/equipos/listado";
    }

    @GetMapping("/equipos/listado")
    public String listarEquipos(Model model) {
        model.addAttribute("equipos", equipos);
        return "listado";
    }

    @GetMapping("/equipos/buscar/{codigo}")
    public String buscarPorCodigo(@PathVariable String codigo, Model model){
        List<equipo> resultado = new ArrayList<>();
        for (equipo e : equipos) {
            if (e.getCodigoActivo().equalsIgnoreCase(codigo)) {
                resultado.add(e);
            }
        }
        model.addAttribute("equipos", resultado);
        if(resultado.isEmpty()){
            model.addAttribute("mensaje", "No se encontro equipos");
        }
        return "listado";
    }


}
