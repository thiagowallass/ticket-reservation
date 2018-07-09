/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author thiag
 */
public class Row {
    Seat[] seats;
    int numberRow;
    
    Row(int n, int numberRow, double price){
        this.numberRow = numberRow;
        seats = new Seat[n];
        for(int i = 0; i < n; i++){
            seats[i] = new Seat(numberRow, Seat.converteToString(i), price);
        }
    }
    
    void print(){
        for(int i = 0; i < seats.length; i++){
            seats[i].print();
        }
        System.out.println("");
    }
   
}
