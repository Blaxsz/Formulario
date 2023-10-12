package com.tela.login.telalogin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tela.login.telalogin.model.Funcionario;
import com.tela.login.telalogin.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repository;

    @GetMapping("/funcionario/cadastro")
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

    @GetMapping("/funcionario/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "redirect:/funcionario/lista";
    }

    @GetMapping("/funcionario/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = repository.findAll();

        for (Funcionario f : funcionarios) {
            if (f.getLogin().equals(funcionario.getLogin()) && f.getSenha().equals(funcionario.getSenha())) {
                return "redirect:/funcionario/lista";
            }
        }
        return "redirect:/funcionario/login";
    }
}
