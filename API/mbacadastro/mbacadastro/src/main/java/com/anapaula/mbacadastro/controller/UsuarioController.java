package com.anapaula.mbacadastro.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anapaula.mbacadastro.banco.UsuarioBanco;
import com.anapaula.mbacadastro.entidade.Usuario;

// CrossOrigin("*") libera o acesso de qualquer lugar de fora
@CrossOrigin("*")
@RestController
public class UsuarioController {

    // erro JPA é erro de acesso ao banco
    // autowired é o que permite o acesso
    @Autowired
    private UsuarioBanco acessoBanco;
    
    @GetMapping("/usuarios")
    public List<Usuario> listarUsusaUsuarios(){
        return (List<Usuario>)acessoBanco.findAll();
    }
     
    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> pegarPorId(@PathVariable int id){
        return acessoBanco.findById(id);
    } 

    // na URL só presta o get
    // insomnia é um recurso utilizado para fazer requisições
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Usuario novoUsuario){
        acessoBanco.save(novoUsuario);
    }

    // put é para alterar
    // requestyBody passa as alterações
    @PutMapping("/alterar/{id}")
    public void alterar(@PathVariable int id, @RequestBody Usuario usuario){
        acessoBanco.findById(id).map( user -> {
            user.setNome(usuario.getNome());
            user.setUsuario(usuario.getUsuario());
            user.setEmail(usuario.getEmail());
            user.getSenha(usuario.getSenha());
            return acessoBanco.save(user);
        });
    }

    @PutMapping("/alterar")
        public void alterarUsuario(@RequestBody Usuario usuario){
            acessoBanco.save(usuario);
        }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable int id){
        acessoBanco.deleteById(id);
    }

}