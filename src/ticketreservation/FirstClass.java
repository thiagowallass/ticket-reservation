/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservation;

/**
 *
 * @author thiag
 */
public class FirstClass extends GenericClass{
    
    FirstClass(int n){
        super(n, 0);
    }
    
    @Override
    void print(){
        System.out.println("Primeira Classe: ");
        super.print(); //Chama método imprimir da classe mãe
    }


}
