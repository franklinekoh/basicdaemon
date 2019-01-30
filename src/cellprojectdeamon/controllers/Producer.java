/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellprojectdeamon.controllers;

import DBAccess.DBAccess;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FRANK
 */
public class Producer extends Thread{
    
    Connection con;
    private final int SLEEP_TIME = 10000;
    
    public Producer(){
        this.con = DBAccess.connectDB();
    }
    
    
    private void process() throws InterruptedException, SQLException{
        System.out.print("Pocessing Data");
        DBAccess access = new DBAccess();
//        calling updateUnprocessed function 
        access.updateUnprocessed(con);
        
    }
    
    @Override
    public void run(){
        
        int unprocessed = 0;
        try{
            
            unprocessed = DBAccess.unProcessed(con);
            if(unprocessed > 0){
               process();  
            }else{
                Producer.sleep(SLEEP_TIME);
            }
           
        }catch(SQLException ex){
            System.out.println("SQL Exception Occured " + ex);
        }catch(InterruptedException ex){
            
            System.out.println("Interrupted Exception " + ex);
            
        }
    }
}
