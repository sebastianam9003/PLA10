package com.trifulcas.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.proyecto.model.Paciente;
import com.trifulcas.proyecto.model.Optometria;
import com.trifulcas.proyecto.services.IPacienteService;
import com.trifulcas.proyecto.services.IOptometriaService;

@Controller
public class AppController {

	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IOptometriaService optometriaService;

	@GetMapping("/")
	public String inicio(Model modelo) {

		List<Paciente> pacientes = pacienteService.getPacientes();

		modelo.addAttribute("pacientes", pacientes);

		return "index";
	}

	@GetMapping("/optometria")
	public String optometrias(Model modelo, @RequestParam int id) {
		
		List<Optometria> optometrias = optometriaService.getOptometrias(id);
		Paciente paciente=pacienteService.getPaciente(id);
		modelo.addAttribute("optometria", optometrias);
		modelo.addAttribute("paciente", paciente);

		return "optometria";
	}
}
