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
public class Client {
    int id;
    String name;
    String telephone;
    String creditCard;
    
    Client(String name, String telephone, String creditCard){
        this.name = name;
        this.telephone = telephone;
        this.creditCard = creditCard;
    }
}
