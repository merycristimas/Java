package pessoa;

/**
 * Class PessoaDAO responsável pela 
 * leitura/escrita de objetos Pessoa no BD
 *
 * @author JSQLGen
 */
public final class PessoaDAO extends dbaccess.DAO {

    //*****************************************
    //CREATE TABLE
    //*****************************************

    /** createTable - Cria a tabela Pessoa no BD
     * @param connection Conexão com BD
     * @throws java.sql.SQLException
     */
    public static void createTable(java.sql.Connection connection) throws java.sql.SQLException {
        String sql = "CREATE TABLE Pessoa ("
                   + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                   + "nome VARCHAR(40) UNIQUE NOT NULL,"
                   + "nascimento DATE NOT NULL,"
                   + "genero VARCHAR(11) NOT NULL,"
                   + "email VARCHAR(60) NOT NULL,"
                   + "celular VARCHAR(15) NOT NULL,"
                   + "usuario VARCHAR(20) UNIQUE NOT NULL,"
                   + "senha VARCHAR(20) NOT NULL,"
                   + "CONSTRAINT PK_Pessoa PRIMARY KEY (id)"
                   + ")";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    //*****************************************
    //UPDATE
    //*****************************************

    /** obj2stmt - Transfere o Objeto para o PreparedStatement.
     * @param connection Conexão com BD
     * @param pessoaSave Pessoa a ser armazenado
     * @param statement PreparedStatement contendo SQL
     * @throws java.sql.SQLException
     */
    private static void obj2stmt(Pessoa pessoaSave, java.sql.PreparedStatement statement) throws java.sql.SQLException {
        statement.setString(1, pessoaSave.getNome());
        statement.setDate(2, new java.sql.Date(pessoaSave.getNascimento().getTime()));
        statement.setString(3, pessoaSave.getGenero());
        statement.setString(4, pessoaSave.getEmail());
        statement.setString(5, pessoaSave.getCelular());
        statement.setString(6, pessoaSave.getUsuario());
        statement.setString(7, pessoaSave.getSenha());
    }

    /** insert - Este método insere no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param pessoaInsert Pessoa a ser inserido
     * @throws java.sql.SQLException
     */
    public static void insert(java.sql.Connection connection, Pessoa pessoaInsert) throws java.sql.SQLException {
        String sql = "INSERT INTO Pessoa (nome,nascimento,genero,email,celular,usuario,senha) "
                   + "VALUES (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(pessoaInsert, statement);
        statement.executeUpdate();
        statement.close();
        sql = "SELECT IDENTITY_VAL_LOCAL() FROM Pessoa";
        statement = connection.prepareStatement(sql);
        java.sql.ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            pessoaInsert.setId(resultSet.getInt(1));
        }
        statement.close();
    }

    /** update - Este método atualiza no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param pessoaUpdate Pessoa a ser atualizado
     * @throws java.sql.SQLException
     */
    public static void update(java.sql.Connection connection, Pessoa pessoaUpdate) throws java.sql.SQLException {
        String sql = "UPDATE Pessoa SET "
                   + "nome = ?,"
                   + "nascimento = ?,"
                   + "genero = ?,"
                   + "email = ?,"
                   + "celular = ?,"
                   + "usuario = ?,"
                   + "senha = ? "
                   + "WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(pessoaUpdate, statement);
        statement.setInt(8, pessoaUpdate.getId());
        statement.executeUpdate();
        statement.close();
    }

    /** delete - Este método apaga do BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param pessoaDelete Pessoa a ser apagado
     * @throws java.sql.SQLException
     */
    public static void delete(java.sql.Connection connection, Pessoa pessoaDelete) throws java.sql.SQLException {
        String sql = "DELETE FROM Pessoa WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pessoaDelete.getId());
        statement.executeUpdate();
        statement.close();
    }

    //*****************************************
    //QUERY private
    //*****************************************

    /**
     * rs2obj - Transfere do ResultSet da Query SQL para um novo objeto
     * @param connection
     * @param resultSet to parse
     * @return novo objeto
     * @throws java.sql.SQLException 
     */
    private static Pessoa rs2obj(java.sql.Connection connection, java.sql.ResultSet resultSet) throws java.sql.SQLException {
        Pessoa pessoaLoad = new Pessoa();
        pessoaLoad.setId(resultSet.getInt("id"));
        pessoaLoad.setNome(resultSet.getString("nome"));
        pessoaLoad.setNascimento(resultSet.getDate("nascimento"));
        pessoaLoad.setGenero(resultSet.getString("genero"));
        pessoaLoad.setEmail(resultSet.getString("email"));
        pessoaLoad.setCelular(resultSet.getString("celular"));
        pessoaLoad.setUsuario(resultSet.getString("usuario"));
        pessoaLoad.setSenha(resultSet.getString("senha"));
        return pessoaLoad;
    }

    /** load - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return objeto Pessoa || null caso não encontrar
     * @throws java.sql.SQLException
     */
    private static Pessoa load(java.sql.Connection connection, String condition) throws java.sql.SQLException {
        if(!condition.isEmpty()){
            String sql = "SELECT id,nome,nascimento,genero,email,celular,usuario,senha "
                       + "FROM Pessoa "
                       + "WHERE "+condition;
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            Pessoa pessoaLoad;
            if (resultSet.next()) {
                pessoaLoad = rs2obj(connection, resultSet);
            } else {
                pessoaLoad = null;
            }
            statement.close();
            return pessoaLoad;
        } else {
            return null;
        }
    }

    /** loadList - Carrega lista de objetos Pessoa
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return List contendo a tabela
     */
    private static java.util.List<Pessoa> loadList(java.sql.Connection connection, String condition) {
        java.util.List<Pessoa> list = new java.util.ArrayList<Pessoa>();
        try {
            String sql = "SELECT id,nome,nascimento,genero,email,celular,usuario,senha "
                       + "FROM Pessoa "
                       + (condition.isEmpty()?"":"WHERE "+condition);
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pessoa pessoaLoad = rs2obj(connection, resultSet);
                list.add(pessoaLoad);
            }
            statement.close();
        } catch (java.sql.SQLException sqlex) {
            System.out.println("Falha na leitura do banco de dados !\n"+sqlex.getMessage());
        }
        return list;
    }

    /** loadView - Carrega visão de atributos de objetos Pessoa
     * @param connection Conexão com BD
     * @param attributesList Atributos listados
     * @param condition condição WHERE
     * @param order Ordem da lista
     * @return lista de atributo
     */
    private static java.util.List loadView(java.sql.Connection connection, String attributesList, String condition, String order) {
        String sql = "SELECT " + attributesList + " "
                   + "FROM Pessoa "
                   + (condition.isEmpty() ? "" : "WHERE " + condition)
                   + (order.isEmpty() ? "" : "ORDER BY " + order);
        return execQueryF(connection, sql);
    }

    //*****************************************
    //QUERY public
    //*****************************************

    //*****************************************
    //LOAD Object BY
    //*****************************************

    /** loadById - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Pessoa
     * @return objeto Pessoa || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Pessoa loadById(java.sql.Connection connection, Integer id) throws java.sql.SQLException {
        return load(connection, "id = "+id);
    }

    /** loadByNome - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Pessoa
     * @return objeto Pessoa || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Pessoa loadByNome(java.sql.Connection connection, String nome) throws java.sql.SQLException {
        return load(connection, "nome = '"+nome+"'");
    }

    /** loadByUsuario - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param usuario campo identificador de Pessoa
     * @return objeto Pessoa || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Pessoa loadByUsuario(java.sql.Connection connection, String usuario) throws java.sql.SQLException {
        return load(connection, "usuario = '"+usuario+"'");
    }

    //*****************************************
    //EXISTS Object BY
    //*****************************************

    /** existsById - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Pessoa
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsById(java.sql.Connection connection, Integer id) {
        java.util.List<Pessoa> l = loadList(connection, "id="+id);
        return !l.isEmpty();
    }

    /** existsByNome - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Pessoa
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsByNome(java.sql.Connection connection, String nome) {
        java.util.List<Pessoa> l = loadList(connection, "nome='"+nome+"'");
        return !l.isEmpty();
    }

    /** existsByUsuario - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param usuario campo identificador de Pessoa
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsByUsuario(java.sql.Connection connection, String usuario) {
        java.util.List<Pessoa> l = loadList(connection, "usuario='"+usuario+"'");
        return !l.isEmpty();
    }

    //*****************************************
    //GET Unique Attribute BY 
    //*****************************************

    /** getNomeById - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Pessoa
     * @return nome || null caso não exista
     */
    public static String getNomeById(java.sql.Connection connection, Integer id) {
        java.util.List l = execQuery(connection, "SELECT nome FROM Pessoa WHERE id="+id);
        if(!l.isEmpty()){
            return(String)l.get(0);
        } else {
            return null;
        }
    }

    /** getUsuarioById - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Pessoa
     * @return usuario || null caso não exista
     */
    public static String getUsuarioById(java.sql.Connection connection, Integer id) {
        java.util.List l = execQuery(connection, "SELECT usuario FROM Pessoa WHERE id="+id);
        if(!l.isEmpty()){
            return(String)l.get(0);
        } else {
            return null;
        }
    }

    /** getIdByNome - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Pessoa
     * @return id || null caso não exista
     */
    public static Integer getIdByNome(java.sql.Connection connection, String nome) {
        java.util.List l = execQuery(connection, "SELECT id FROM Pessoa WHERE nome='"+nome+"'");
        if(!l.isEmpty()){
            return(Integer)l.get(0);
        } else {
            return null;
        }
    }

    /** getUsuarioByNome - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Pessoa
     * @return usuario || null caso não exista
     */
    public static String getUsuarioByNome(java.sql.Connection connection, String nome) {
        java.util.List l = execQuery(connection, "SELECT usuario FROM Pessoa WHERE nome='"+nome+"'");
        if(!l.isEmpty()){
            return(String)l.get(0);
        } else {
            return null;
        }
    }

    /** getIdByUsuario - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param usuario campo identificador de Pessoa
     * @return id || null caso não exista
     */
    public static Integer getIdByUsuario(java.sql.Connection connection, String usuario) {
        java.util.List l = execQuery(connection, "SELECT id FROM Pessoa WHERE usuario='"+usuario+"'");
        if(!l.isEmpty()){
            return(Integer)l.get(0);
        } else {
            return null;
        }
    }

    /** getNomeByUsuario - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param usuario campo identificador de Pessoa
     * @return nome || null caso não exista
     */
    public static String getNomeByUsuario(java.sql.Connection connection, String usuario) {
        java.util.List l = execQuery(connection, "SELECT nome FROM Pessoa WHERE usuario='"+usuario+"'");
        if(!l.isEmpty()){
            return(String)l.get(0);
        } else {
            return null;
        }
    }

    //*****************************************
    //LOAD Attribute List
    //*****************************************

    /** loadIdList - Carrega lista de id de objetos Pessoa
     * @param connection Conexão com BD
     * @return List contendo Id
     */
    public static java.util.List<String> loadIdList(java.sql.Connection connection) {
        return loadView(connection, "id", "", "id");
    }

    /** loadNomeList - Carrega lista de nome de objetos Pessoa
     * @param connection Conexão com BD
     * @return List contendo Nome
     */
    public static java.util.List<String> loadNomeList(java.sql.Connection connection) {
        return loadView(connection, "nome", "", "nome");
    }

    /** loadUsuarioList - Carrega lista de usuario de objetos Pessoa
     * @param connection Conexão com BD
     * @return List contendo Usuario
     */
    public static java.util.List<String> loadUsuarioList(java.sql.Connection connection) {
        return loadView(connection, "usuario", "", "usuario");
    }

    //*****************************************
    //LOAD Object List
    //*****************************************

    /** loadList - Carrega lista de objetos Pessoa
     * @param connection Conexão com BD
     * @return List contendo os objetos
     */
    public static java.util.List<Pessoa> loadList(java.sql.Connection connection) {
        return loadList(connection, "");
    }

    //*****************************************
    //LOAD Object View
    //*****************************************

    /** loadView - Carrega visão de atributos de objetos Pessoa
     * @param connection Conexão com BD
     * @return lista com visão de atributos
     */
    public static java.util.List loadView(java.sql.Connection connection) {
        String sql = "SELECT "
                   + "Pessoa.id,"
                   + "Pessoa.nome,"
                   + "Pessoa.nascimento,"
                   + "Pessoa.genero,"
                   + "Pessoa.email,"
                   + "Pessoa.celular,"
                   + "Pessoa.usuario,"
                   + "Pessoa.senha "
                   + "FROM Pessoa ";
        return execQueryF(connection, sql);
    }

}
