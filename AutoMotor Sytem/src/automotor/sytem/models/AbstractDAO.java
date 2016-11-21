/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotor.sytem.models;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jcodogno
 */
public class AbstractDAO {
    
    private Connection conn;
    private String table;
    private String where;
    private String moreOptions;
    private String leftJoin[];
    private String rightJoin[];
    private String innerJoin[];
    private ResultSet result;
    private String rowCount;
    
    
    public AbstractDAO(){
        conn = ConnectionMySql.startConnection();
    }
    
    public ResultSet getResult(){
        return this.result;
    }
    
    public boolean select(String parameters){
        try{
            String sql = new String();
            sql = "SELECT "+parameters+" FROM "+this.table;
            if(this.innerJoin.length>0){
                for (String innerJoin1 : innerJoin) {
                    sql += " INNER JOIN " + innerJoin1;
                }
            }
            if(this.leftJoin.length>0){
                for (String leftJoin1 : leftJoin) {
                    sql += " LEFT JOIN " + leftJoin1;
                }
            }
            if(this.rightJoin.length>0){
                for (String rightJoin1 : rightJoin) {
                    sql += " RIGHT JOIN " + rightJoin1;
                }
            }
            if(!this.where.isEmpty())
                sql += " WHERE "+this.where;
            if(!this.moreOptions.isEmpty())
                sql += " "+this.moreOptions;

            PreparedStatement comando = conn.prepareStatement(sql);
            this.result = comando.executeQuery();
            return true;
        }catch(SQLException es){
            System.out.println(es.toString());
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return false;
    }
    
    public boolean create(){
        
        return false;
    }
    
    public boolean delete(){
        
        return false;
    }
    
    public boolean update(){
        
        return false;
    }
        
    
}
