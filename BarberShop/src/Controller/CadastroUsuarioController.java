/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.CadastroUsuarioHelper;
import Model.DAO.Conexao;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.CadastroUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.frey
 */
public class CadastroUsuarioController {

    private final CadastroUsuario view;
    private CadastroUsuarioHelper helper;

    public CadastroUsuarioController(CadastroUsuario view) {
        this.view = view;
        this.helper = new CadastroUsuarioHelper(view);
    }

    public void cadastrarUsuario() {

        Usuario usuario = helper.obterModeloCadastroUsuario();

        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.insert(usuario);
            conexao.close();
            view.exibeMensagem("Usuário salvo com sucesso!");
            helper.limpatela();

        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            view.exibeMensagem("Falha, não foi possivel salvar o Usuario!");
        }

    }

}
