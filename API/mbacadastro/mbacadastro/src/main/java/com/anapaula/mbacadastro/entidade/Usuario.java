package com.anapaula.mbacadastro.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

// nome de classe em java começa com letra maiúscula
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String senha;
    private String usuario;
    private String email;
    public int getId() {
      return id;
    }
    public void setId(int id) {
      this.id = id;
    }
    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
    public String getSenha(String string) {
      return senha;
    }
    public void setSenha(String senha) {
      this.senha = senha;
    }
    public String getUsuario() {
      return usuario;
    }
    public void setUsuario(String usuario) {
      this.usuario = usuario;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public String getSenha() {
        return senha;
    }

}
