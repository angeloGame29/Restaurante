package br.ufpb.dcx.restaurante;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class Usuario {
    private String nome;
    private String Email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.Email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Email, usuario.Email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Email, senha);
    }

    public void cadastrarUsuario(HashMap<String, Usuario> usuarioHashMap) {
        usuarioHashMap.put(getSenha(),this);
    }
}
