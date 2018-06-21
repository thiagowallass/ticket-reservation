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
public class Seat {
    boolean taken;
    String letter;
    
    Seat(String letter){
        taken = false;
        this.letter = letter;
    }
    
    static String converteToString(int n){
        String res = null;
        switch(n){
            case 0:
                res = "A";
                break;
            case 1:
                res = "B";
                break;
            case 2:
                res = "C";
                break;
            case 3:
                res = "D";
                break;
            case 4:
                res = "E";
                break;
            case 5:
                res = "F";
                break;
        }
        return res;
    }
    
    static int converteToPos(String seat){
        int n = 0;
        switch(seat){
            case "A":
                n = 0;
                break;
            case "B":
                n = 1;
                break;
            case "C":
                n = 2;
                break;
            case "D":
                n = 3;
                break;
            case "E":
                n = 4;
                break;
            case "F":
                n = 5;
                break;
            default:
                n = -1;
                break;
        }
        return n;
    }
    
    boolean reserveSeat(){
        if(!taken){
            taken = true;
            return true;
        }else{
            return false;
        }       
    }
    
    boolean cancelReserve(){
        if(taken){
            taken = false;
            return true;
        }else{
            return false;
        }
    }
    
    void print(){
        if(taken)
            System.out.print(letter + " X ");
        else
            System.out.print(letter + " _ ");
    }

}
