package venda.vendaitem;

/**
 * Class VendaItemDAO responsável pela 
 * leitura/escrita de objetos VendaItem no BD
 *
 * @author JSQLGen
 */
public final class VendaItemDAO extends dbaccess.DAO {

    //*****************************************
    //CREATE TABLE
    //*****************************************

    /** createTable - Cria a tabela VendaItem no BD
     * @param connection Conexão com BD
     * @throws java.sql.SQLException
     */
    public static void createTable(java.sql.Connection connection) throws java.sql.SQLException {
        String sql = "CREATE TABLE VendaItem ("
                   + "vendaOwner INT NOT NULL,"
                   + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                   + "produto INT NOT NULL,"
                   + "quantidade INT NOT NULL,"
                   + "valor FLOAT NOT NULL,"
                   + "CONSTRAINT PK_VendaItem PRIMARY KEY (id),"
                   + "CONSTRAINT FKC_VendaItem_VendaOwner FOREIGN KEY (vendaOwner) REFERENCES Venda ON DELETE CASCADE,"
                   + "CONSTRAINT FKA_VendaItem_Produto FOREIGN KEY (produto) REFERENCES Produto ON DELETE CASCADE"
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
     * @param vendaItemSave VendaItem a ser armazenado
     * @param statement PreparedStatement contendo SQL
     * @throws java.sql.SQLException
     * @param vendaOwner Venda owner
     */
    private static void obj2stmt(VendaItem vendaItemSave, venda.Venda vendaOwner, java.sql.PreparedStatement statement) throws java.sql.SQLException {
        statement.setInt(1, vendaOwner.getId());
        statement.setInt(2, vendaItemSave.getProduto().getId());
        statement.setInt(3, vendaItemSave.getQuantidade());
        statement.setFloat(4, vendaItemSave.getValor());
    }

    /** insert - Este método insere no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param vendaItemInsert VendaItem a ser inserido
     * @param vendaOwner Venda owner
     * @throws java.sql.SQLException
     */
    public static void insert(java.sql.Connection connection, VendaItem vendaItemInsert, venda.Venda vendaOwner) throws java.sql.SQLException {
        String sql = "INSERT INTO VendaItem (vendaOwner,produto,quantidade,valor) "
                   + "VALUES (?,?,?,?)";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(vendaItemInsert, vendaOwner, statement);
        statement.executeUpdate();
        statement.close();
        sql = "SELECT IDENTITY_VAL_LOCAL() FROM VendaItem";
        statement = connection.prepareStatement(sql);
        java.sql.ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            vendaItemInsert.setId(resultSet.getInt(1));
        }
        statement.close();
    }

    /** update - Este método atualiza no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param vendaItemUpdate VendaItem a ser atualizado
     * @param vendaOwner Venda owner
     * @throws java.sql.SQLException
     */
    public static void update(java.sql.Connection connection, VendaItem vendaItemUpdate, venda.Venda vendaOwner) throws java.sql.SQLException {
        String sql = "UPDATE VendaItem SET "
                   + "vendaOwner = ?,"
                   + "produto = ?,"
                   + "quantidade = ?,"
                   + "valor = ? "
                   + "WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(vendaItemUpdate, vendaOwner, statement);
        statement.setInt(5, vendaItemUpdate.getId());
        statement.executeUpdate();
        statement.close();
    }

    /** delete - Este método apaga do BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param vendaItemDelete VendaItem a ser apagado
     * @throws java.sql.SQLException
     */
    public static void delete(java.sql.Connection connection, VendaItem vendaItemDelete) throws java.sql.SQLException {
        String sql = "DELETE FROM VendaItem WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, vendaItemDelete.getId());
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
    private static VendaItem rs2obj(java.sql.Connection connection, java.sql.ResultSet resultSet) throws java.sql.SQLException {
        VendaItem vendaItemLoad = new VendaItem();
        vendaItemLoad.setId(resultSet.getInt("id"));
        try {
            vendaItemLoad.setProduto(produto.ProdutoDAO.loadById(connection, resultSet.getInt("produto")));
        } catch (java.sql.SQLException e) {
            vendaItemLoad.setProduto(new produto.Produto());
        }
        vendaItemLoad.setQuantidade(resultSet.getInt("quantidade"));
        vendaItemLoad.setValor(resultSet.getFloat("valor"));
        return vendaItemLoad;
    }

    /** load - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return objeto VendaItem || null caso não encontrar
     * @throws java.sql.SQLException
     */
    private static VendaItem load(java.sql.Connection connection, String condition) throws java.sql.SQLException {
        if(!condition.isEmpty()){
            String sql = "SELECT id,produto,quantidade,valor "
                       + "FROM VendaItem "
                       + "WHERE "+condition;
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            VendaItem vendaItemLoad;
            if (resultSet.next()) {
                vendaItemLoad = rs2obj(connection, resultSet);
            } else {
                vendaItemLoad = null;
            }
            statement.close();
            return vendaItemLoad;
        } else {
            return null;
        }
    }

    /** loadList - Carrega lista de objetos VendaItem
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return List contendo a tabela
     */
    private static java.util.List<VendaItem> loadList(java.sql.Connection connection, String condition) {
        java.util.List<VendaItem> list = new java.util.ArrayList<VendaItem>();
        try {
            String sql = "SELECT id,produto,quantidade,valor "
                       + "FROM VendaItem "
                       + (condition.isEmpty()?"":"WHERE "+condition);
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendaItem vendaItemLoad = rs2obj(connection, resultSet);
                list.add(vendaItemLoad);
            }
            statement.close();
        } catch (java.sql.SQLException sqlex) {
            System.out.println("Falha na leitura do banco de dados !\n"+sqlex.getMessage());
        }
        return list;
    }

    /** loadView - Carrega visão de atributos de objetos VendaItem
     * @param connection Conexão com BD
     * @param attributesList Atributos listados
     * @param condition condição WHERE
     * @param order Ordem da lista
     * @return lista de atributo
     */
    private static java.util.List loadView(java.sql.Connection connection, String attributesList, String condition, String order) {
        String sql = "SELECT " + attributesList + " "
                   + "FROM VendaItem "
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
     * @param id campo identificador de VendaItem
     * @return objeto VendaItem || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static VendaItem loadById(java.sql.Connection connection, Integer id) throws java.sql.SQLException {
        return load(connection, "id = "+id);
    }

    //*****************************************
    //EXISTS Object BY
    //*****************************************

    /** existsById - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de VendaItem
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsById(java.sql.Connection connection, Integer id) {
        java.util.List<VendaItem> l = loadList(connection, "id="+id);
        return !l.isEmpty();
    }

    //*****************************************
    //LOAD Attribute List
    //*****************************************

    /** loadIdList - Carrega lista de id de objetos VendaItem
     * @param connection Conexão com BD
     * @return List contendo Id
     */
    public static java.util.List<String> loadIdList(java.sql.Connection connection) {
        return loadView(connection, "id", "", "id");
    }

    //*****************************************
    //LOAD Object List
    //*****************************************

    /** loadList - Retorna Lista de objetos VendaItem por Venda
     * @param connection Conexão com BD
     * @param vendaOwner Venda
     * @return List contendo os objetos
     */
    public static java.util.List<VendaItem> loadList(java.sql.Connection connection, venda.Venda vendaOwner) {
        return loadList(connection, "vendaOwner = " + vendaOwner.getId());
    }

    //*****************************************
    //LOAD Object View
    //*****************************************

}
