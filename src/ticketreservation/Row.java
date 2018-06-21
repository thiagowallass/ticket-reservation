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
public class Row {
    Seat[] seats;
    int numberRow;
    
    Row(int n, int numeroFila){
        this.numberRow = numeroFila;
        seats = new Seat[n];
        for(int i = 0; i < n; i++){
            seats[i] = new Seat(Seat.converteToString(i));
        }
    }
    
    void print(){
        for(int i = 0; i < seats.length; i++){
            seats[i].print();
        }
        System.out.println("");
    }
   
}
