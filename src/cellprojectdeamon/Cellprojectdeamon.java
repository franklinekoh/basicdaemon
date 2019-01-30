/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellprojectdeamon;
import cellprojectdeamon.controllers.Producer;

/**
 *
 * @author FRANK
 */
public class Cellprojectdeamon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Producer process = new Producer();
      process.start();
    }
    
}
