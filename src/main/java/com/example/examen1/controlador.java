package com.example.examen1;
import com.example.examen1.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class controlador {
    private List<Cita> valores = new ArrayList<>();

    @RequestMapping(path ="/calendario")
    public String lista (Model model){
        model.addAttribute("lista", valores);
        return "calendario";
    }

    @RequestMapping(path ="/vista")
    public String estado(){
        return "vista";
    }


    @PostMapping("/add")
    public String add(String nombre, String asunto, String fecha, String hora){
        Cita cita = new Cita();
        cita.setMedico(nombre);
        cita.setAsunto(asunto);
        cita.setFecha(fecha);
        cita.setHora(hora);
        valores.add(cita);
        return "redirect:/calendario";
    }
}
