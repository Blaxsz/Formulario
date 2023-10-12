package com.tela.login.telalogin.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tela.login.telalogin.model.Funcionario;
import com.tela.login.telalogin.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repository;

    @GetMapping("/aluno/cadastro")
    public String cadastroAluno() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastroFuncionario(Funcionario funcionario) {
        repository.save(funcionario);
        return "redirect:/funcionario/lista";
    }

    @GetMapping("/funcionario/lista")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("lista");
        java.util.List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = repository.findAll();
        mv.addObject("funcionarios", funcionarios);
        return mv;
    }
}
