/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Usuario;
import View.CadastroUsuario;

/**
 *
 * @author daniel.frey
 */
public class CadastroUsuarioHelper {

    private final CadastroUsuario view;

    public CadastroUsuarioHelper(CadastroUsuario view) {
        this.view = view;
    }

    
    public void limpatela() {
       view.getjTFusuario().setText("");
       view.getjPFsenha().setText("");
    }

     public Usuario obterModeloCadastroUsuario() {
        String usuario = view.getjTFusuario().getText();
        String senha = view.getjPFsenha().getText();
        Usuario modelo = new Usuario(usuario, senha);
        return modelo;
    }
}
