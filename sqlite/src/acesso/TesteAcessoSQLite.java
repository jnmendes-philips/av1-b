package acesso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import dao.DAO;

public class TesteAcessoSQLite {

    static DAO dao = new DAO();

    public static void main(String[] args) {
        ResultSet result = null;
        try {
            //testeIncluir(con);
            //testeExcluir(con);
            testeAlterar();
            testeConsultar(result);
        } catch(SQLException ex) {
            System.out.print("Erro no SQL: " + ex.getMessage());
        }
    }
    
    static void testeConsultar(ResultSet result) throws SQLException {
        result = dao.consultarComId("999");
        while (result.next()) {
            ResultSetMetaData rsmd = result.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(result.getString(i) + " \t | ");
            }
            System.out.print("\n");
        }
    }
    
    static void testeIncluir() throws SQLException {
        Compania c = new Compania();
        c.setNome("teste");
        c.setAno("1888");
        dao.incluir(c);
    }
    
    static void testeExcluir() throws SQLException {
        dao.excluir("1000");
    }
    
    static void testeAlterar() throws SQLException{
        Compania c = dao.consultar("999");
        c.setAno("1872");
        dao.alterar(c);
    }

}
