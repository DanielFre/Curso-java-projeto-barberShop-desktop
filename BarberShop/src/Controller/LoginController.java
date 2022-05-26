/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.Usuario;
import View.Login;

/**
 *
 * @author danie
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema() {
       
        // pegar o usuario da view
        Usuario usuario = helper.obterModelo();
        
        //pesquisar usuario no banco
        //pegar a senha da view
        //pesquisar senha no banco

        // se tudo ok direciona para o menu principal
        //  senão mostrar alerta informando "usuario ou senha inválidos"
        
        
    }

    public void fizTarefa() {

        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o Fiz Tarefa");

    }

}
