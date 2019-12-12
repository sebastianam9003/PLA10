package com.trifulcas.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.proyecto.model.Paciente;
import com.trifulcas.proyecto.model.Optometria;
import com.trifulcas.proyecto.services.IPacienteService;
import com.trifulcas.proyecto.services.IOptometriaService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IOptometriaService optometriaService;

	@GetMapping("/deletepaciente")
	public String deletePaciente(@RequestParam("idpaciete") int idpaciente) {
		Paciente paciente = pacienteService.getPaciente(idpaciente);
		pacienteService.delete(paciente);

		return "redirect:/";
	}

	@GetMapping("/deleteoptometria")
	public String deleteOptometria(@RequestParam("idoptometria") int idoptometria) {
		Optometria optometria = optometriaService.getOptometria(idoptometria);
		int idpaciente=optometria.getPacientes().getIdpaciente();
		optometriaService.delete(optometria);

		return "redirect:/optometria?id="+idpaciente;
	}
}
