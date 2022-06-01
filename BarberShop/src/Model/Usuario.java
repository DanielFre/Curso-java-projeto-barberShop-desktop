/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;



/**
 *
 * @author danie
 */
public class Usuario extends Pessoa{
    
    private String senha;   
    private String usuario;

    private String nivelDeAcesso;

    public Usuario(int id, String nome, String senha ) {
        super(id, nome);
        this.senha = senha;
    }

    public Usuario(int id, String nome, String senha, String nivelDeAcesso) {
        super(id, nome);
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public Usuario( int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg, String senha, String nivelDeAcesso) {
        super(id, nome, sexo, dataNascimento, telefone, email, rg);
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public Usuario(String senha, String usuario, int id) {
        super(id);
        this.senha = senha;
        this.usuario = usuario;
    }

    public Usuario( String usuario, String senha) {
        this.senha = senha;
        this.usuario = usuario;
    }
    
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    } 

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   
    
}
