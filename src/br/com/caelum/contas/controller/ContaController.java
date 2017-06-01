package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;


@Controller
public class ContaController {
	
	private ContaDAO dao;

	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
		
	}
	
	@RequestMapping("/form")
	public String formulario() {	//M�todo para chamar a p�gina 'formul�rio'
		return "conta/formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {		//Action da p�gina 'conta/formulario'
		
		if(result.hasErrors()) {
			return "conta/formulario";
		}
		dao.adiciona(conta);
		
		return "redirect:/listaContas";
		
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta) { //M�todo usado para remover uma conta listada na p�gina 'conta/lista'
		
		dao.remove(conta);
		
		return "redirect:/listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model mv) {	//M�todo usado para alterar uma conta listada na p�gina 'conta/lista'
		
		mv.addAttribute("conta", dao.buscaPorId(id));
		
		return "conta/mostra";
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {	//Action da p�gina 'conta/mostra'
		
		dao.altera(conta);
		
		return "redirect:listaContas";
	}
	
	@RequestMapping("/pagarConta")
	public void pagar(Conta conta, HttpServletResponse response) {
		
		dao.paga(conta.getId());
		
		response.setStatus(200);
	}
	
	@RequestMapping("/listaContas")
	public String lista(Model mv) {
		
		List<Conta> contas = dao.lista();
		
		mv.addAttribute("contas", contas);
		
		return "conta/lista";
	}
}
