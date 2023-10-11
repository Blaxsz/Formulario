package com.tela.login.telalogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuncionarioController {

    @GetMapping("/aluno/cadastro")
    public String cadastroAluno() {
        return "cadastro";
    }
}
