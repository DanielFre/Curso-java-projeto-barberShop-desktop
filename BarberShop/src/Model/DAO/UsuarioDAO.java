/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Usuario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere um usuario dentro do banco de dados
     *
     * @param usuario exige que seja passado um objeto do tipo usuario
     */
    public void insert(Usuario usuario) throws SQLException {
        //        Banco.usuario.add(usuario);

        String sql = "insert into usuario(usuario, senha) values (?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        
        statement.execute();
//        connection.close();
    }

    /**
     * Atualiza um Objeto no banco de dados
     *
     * @param usuario
     * @return
     */
    public boolean update(Usuario usuario) {

        for (int i = 0; i < Banco.usuario.size(); i++) {
            if (idSaoIguais(Banco.usuario.get(i), usuario)) {
                Banco.usuario.set(i, usuario);
                return true;
            }
        }
        return false;

    }

    /**
     * Deleta um objeto do banco de dados pelo id do usuario passado
     *
     * @param usuario
     * @return
     */
    public boolean delete(Usuario usuario) {
        for (Usuario usuarioLista : Banco.usuario) {
            if (idSaoIguais(usuarioLista, usuario)) {
                Banco.usuario.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna um arraylist com todos os usuarios do banco de dados
     *
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Usuario> selectAll() {
        return Banco.usuario;
    }

    /**
     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario passado
     * como parâmetro no banco, para considerar sao usado nome e senha
     *
     * @param usuario
     * @return Usuario encontrado no banco de dados
     */
    public boolean verificaSeExisteUsuarioEsenha(Usuario usuario) throws SQLException {

        String sql = "select * from usuario where usuario = ? and senha = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        
        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();

//
////        connection.close();
//        for (Usuario usuarioLista : Banco.usuario) {
//            if (nomeESenhaSaoIguais(usuarioLista, usuario)) {
//                return usuarioLista;
//            }
//        }
//        return null;
    }

    /**
     * Recebe dois objetos e verifica se são iguais verificando o nome e senha
     *
     * @param usuario
     * @param usuarioAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean nomeESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getNome().equals(usuarioAPesquisar.getNome()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    /**
     * Compara se dois objetos tem a propriedade id igual
     *
     * @param usuario
     * @param usuarioAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() == usuarioAComparar.getId();
    }

}
