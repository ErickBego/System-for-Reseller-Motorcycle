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
    private String table = "";
    private String where = "";
    private String moreOptions = "";
    private final ArrayList leftJoin = new ArrayList();
    private final ArrayList rightJoin = new ArrayList();
    private final ArrayList innerJoin = new ArrayList();
    ResultSet result;
    private int rowCount;
    
    
    public AbstractDAO(){
        conn = ConnectionMySql.startConnection();
    }
    
    public ResultSet getResult(){
        return this.result;
    }
    
    public AbstractDAO setTable(String table){
        this.table = table;
        return this;
    }
    
    public AbstractDAO setLeftJoin(String data[]){
        if(data.length==5)
            this.leftJoin.add(data);
        return this;
    }
    
    public AbstractDAO setInnerJoin(String data[]){
        if(data.length==5)
            this.innerJoin.add(data);
        return this;
    }
    
    public AbstractDAO setRightJoin(String data[]){
        if(data.length==5)
            this.rightJoin.add(data);
        return this;
    }
    
    public AbstractDAO select(String parameters){
        try{
            String sql = "SELECT "+parameters+" FROM "+this.table;
          
            if(this.innerJoin.size()>0){
                for (Object innerJoin1 : innerJoin) {
                    sql += " INNER JOIN " + innerJoin1;
                }
            }
            
            if(this.leftJoin.size()>0){
                for (Object leftJoin1 : leftJoin) {
                    sql += " LEFT JOIN " + leftJoin1;
                }
            }
            
            if(this.rightJoin.size()>0){
                for (Object rightJoin1 : rightJoin) {
                    sql += " RIGHT JOIN " + rightJoin1;
                }
            }
   
            if(!this.where.isEmpty()){
                sql += " WHERE "+this.where;
            }
            if(!this.moreOptions.isEmpty()){
                sql += " "+this.moreOptions;
            }

            PreparedStatement comando = conn.prepareStatement(sql);
            this.result = comando.executeQuery();
            conn.close();
            return this;
        }catch(SQLException es){
            System.out.println(es.toString());
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return this;
    }
    public boolean create(String Data[][]) throws Exception{
        try{
            String sql = "INSERT INTO "+this.table;
            PreparedStatement comando = conn.prepareStatement(sql);
            this.result = comando.executeQuery();
            
        }catch(SQLException es){
            System.out.println(es.toString());
        }
        return false;
    }
    
    public boolean delete(){
        
        return false;
    }
    
    public boolean update(){
        
        return false;
    }
        
    
}
