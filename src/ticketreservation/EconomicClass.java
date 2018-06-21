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
public class EconomicClass extends GenericClass{
    
    EconomicClass(int n, int p){
        super(n, p);
    }
    
    @Override
    void print(){
        System.out.println("Classe Economica: ");
        super.print(); //Chama método imprimir da classe mãe
    }

}
