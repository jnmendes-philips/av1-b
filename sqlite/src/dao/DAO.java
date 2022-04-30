package dao;


import acesso.Compania;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    
    public Connection con;
    
    public DAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\companies_1000.db");
        } catch(SQLException ex) {
            System.out.print("Erro no SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void incluir(Compania c) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" insert into compania ( ");
            sb.append(" name,");
            sb.append(" domain, ");
            sb.append(" \"year founded\", ");
            sb.append(" industry, ");
            sb.append(" \"size range\", ");
            sb.append(" locality, ");
            sb.append(" country, ");
            sb.append(" \"linkedin url\", ");
            sb.append(" \"current employee estimate\", ");
            sb.append(" \"total employee estimate\") ");
            sb.append(" values (?,?,?,?,?,?,?,?,?,?) ");
            PreparedStatement pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getDominio());
            pstmt.setString(3, c.getAno());
            pstmt.setString(4, c.getIndustria());
            pstmt.setString(5, c.getTamanho());
            pstmt.setString(6, c.getLocalizacao());
            pstmt.setString(7, c.getPais());
            pstmt.setString(8, c.getLinkedin());
            pstmt.setInt(9, c.getEmpregados_atual());
            pstmt.setInt(10, c.getEmpregados_total());
            pstmt.execute();
        } catch(SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(String id) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" delete from compania ");
            sb.append(" where rowid = ? ");
            PreparedStatement pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, id);
            pstmt.execute();
        } catch(SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(Compania c) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" update compania ");
            sb.append(" set ");
            sb.append(" name = ?, ");
            sb.append(" domain = ?, ");
            sb.append(" \"year founded\" = ?, ");
            sb.append(" industry = ?, ");
            sb.append(" \"size range\" = ?, ");
            sb.append(" locality = ?, ");
            sb.append(" country = ?, ");
            sb.append(" \"linkedin url\" = ?, ");
            sb.append(" \"current employee estimate\" = ?, ");
            sb.append(" \"total employee estimate\" = ? ");
            sb.append(" where rowid = ? ");
            PreparedStatement pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getDominio());
            pstmt.setString(3, c.getAno());
            pstmt.setString(4, c.getIndustria());
            pstmt.setString(5, c.getTamanho());
            pstmt.setString(6, c.getLocalizacao());
            pstmt.setString(7, c.getPais());
            pstmt.setString(8, c.getLinkedin());
            pstmt.setInt(9, c.getEmpregados_atual());
            pstmt.setInt(10, c.getEmpregados_total());
            pstmt.setString(11, c.getId());
            pstmt.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Compania consultar(String id) {
        try {
            ResultSet rs = consultarComId(id);
            Compania c = new Compania();
            c.setId(rs.getString(1));
            c.setNome(rs.getString(2));
            c.setDominio(rs.getString(3));
            c.setAno(rs.getString(4));
            c.setIndustria(rs.getString(5));
            c.setTamanho(rs.getString(6));
            c.setLocalizacao(rs.getString(7));
            c.setPais(rs.getString(8));
            c.setLinkedin(rs.getString(9));
            c.setEmpregados_atual(rs.getInt(10));
            c.setEmpregados_total(rs.getInt(11));
            return c;
        } catch(SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet consultarComId(String id) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select rowid, ");
            sb.append(" name, ");
            sb.append(" domain, ");
            sb.append(" \"year founded\", ");
            sb.append(" industry, ");
            sb.append(" \"size range\", ");
            sb.append(" locality, ");
            sb.append(" country, ");
            sb.append(" \"linkedin url\", ");
            sb.append(" \"current employee estimate\", ");
            sb.append(" \"total employee estimate\" ");
            sb.append(" from compania a ");
            sb.append(" where a.rowid = ? ");
            PreparedStatement pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, id);
            return pstmt.executeQuery();
        } catch(SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet consultar() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select rowid, ");
            sb.append(" name, ");
            sb.append(" domain, ");
            sb.append(" \"year founded\", ");
            sb.append(" industry, ");
            sb.append(" \"size range\", ");
            sb.append(" locality, ");
            sb.append(" country, ");
            sb.append(" \"linkedin url\", ");
            sb.append(" \"current employee estimate\", ");
            sb.append(" \"total employee estimate\" ");
            sb.append(" from compania a ");
            PreparedStatement pstmt = con.prepareStatement(sb.toString());
            return pstmt.executeQuery();
        } catch(SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
