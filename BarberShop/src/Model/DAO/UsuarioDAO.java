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
     * @return 
     * @throws java.sql.SQLException
     */
    public Usuario insert(Usuario usuario) throws SQLException {

        String sql = "insert into usuario(usuario, senha) values (?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());

        statement.execute();
        
        ResultSet resulSet = statement.getGeneratedKeys();
        
        if(resulSet.next()){
            int id = resulSet.getInt("id");
            usuario.setId(id);
        }
        
        return usuario;
    }

    /**
     * Atualiza um Objeto no banco de dados
     *
     * @param usuario
     */
    public void update(Usuario usuario) throws SQLException {

        String sql = "update usuario set usuario = ?, senha = ? where id = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getId());

        statement.execute();
    }

    public void insertOrUpdate(Usuario usuario) throws SQLException {
        if (usuario.getId() > 0) {
            update(usuario);
        } else {
            insert(usuario);
        }
    }

    /**
     * Deleta um objeto do banco de dados pelo id do usuario passado
     *
     * @param usuario
     */
    public void delete(Usuario usuario) throws SQLException {
        String sql = "delete from usuario where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, usuario.getId());

        statement.execute();
    }

    /**
     * Retorna um arraylist com todos os usuarios do banco de dados
     *
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Usuario> selectAll() throws SQLException {

        String sql = "select * from usuario;";
        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String usuario = resultSet.getString("usuario");
            String senha = resultSet.getString("senha");

            Usuario usuarioComDadosDoBanco = new Usuario(id, usuario, senha);
            usuarios.add(usuarioComDadosDoBanco);
        }
        return usuarios;
    }

    public Usuario selectPorId(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        return pesquisa(statement).get(0);

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
