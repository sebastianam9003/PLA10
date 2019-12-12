package com.trifulcas.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.proyecto.model.Paciente;
import com.trifulcas.proyecto.model.Optometria;
import com.trifulcas.proyecto.services.IPacienteService;
import com.trifulcas.proyecto.services.IOptometriaService;

@Controller
public class GerenteController {
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IOptometriaService optometriaService;

	@GetMapping("/addpaciente")
	public String addCategory(Model modelo) {
		Paciente paciente = new Paciente();
		modelo.addAttribute(paciente);
		return "form-paciente";
	}

	@PostMapping("/savepaciente")
	public String savePaciente(@ModelAttribute("paciente") Paciente paciente) {

		pacienteService.save(paciente);
		return "redirect:/";
	}

	@GetMapping("updatepaciente")
	public String updatePaciente(@RequestParam("idpaciente") int idpaciente, Model modelo) {

		Paciente paciente = pacienteService.getPaciente(idpaciente);
		modelo.addAttribute(paciente);
		return "form-paciente";
	}

	@GetMapping("/addoptometria")
	public String addoptometria(Model modelo) {
		Optometria optometria = new Optometria();
		modelo.addAttribute(optometria);

		List<Paciente> pacientes = pacienteService.getPacientes();
		modelo.addAttribute("pacientes", pacientes);

		return "form-optometria";
	}

	@PostMapping("/saveoptometria")
	public String saveOptometria(@ModelAttribute("optometria") Optometria optometria) {

		optometriaService.save(optometria);
		return "redirect:/optometrias?id="+optometria.getPacientes().getIdpaciente();
	}

	@GetMapping("updateoptometria")
	public String updateTarea(@RequestParam("idoptometria") int idoptometria, Model modelo) {

		Optometria optometria = optometriaService.getOptometria(idoptometria);
		modelo.addAttribute(optometria);
		List<Paciente> pacientes = pacienteService.getPacientes();
		modelo.addAttribute("pacientes", pacientes);

		return "form-optometria";
	}
}
