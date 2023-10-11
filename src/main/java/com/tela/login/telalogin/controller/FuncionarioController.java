package com.tela.login.telalogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "";
    }
}
