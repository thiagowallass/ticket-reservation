/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservation;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author thiag
 */
public class Airport {
    private ArrayList<Airplane> airplanes;
            
    Airport(){
        airplanes = new ArrayList<Airplane>();
        airportDAO();
    }
    
    private void airportDAO(){
        airplanes.add(new Airplane(5, 15, "LATAM", 3903, 07, "06:45", "São Paulo"));
        airplanes.add(new Airplane(5, 15, "GOL", 1480, 11, "07:00", "Brasilia"));
        airplanes.add(new Airplane(5, 15, "AZUL", 4015, 02, "07:09", "Campo Grande"));
    }
           
    void print(){
        Iterator<Airplane> it = airplanes.iterator();
        System.out.printf("%29s", "Lista de Voos\n");
        System.out.println("Opção" + "\t|" + "Cia" + "\t|" + "Voo" + "\t|" + "Saída" + "\t|" + "Destino " + "\t|" + "Portão");
        int i = 1;
        while(it.hasNext()){
            Airplane aviao = it.next();
            System.out.println( (i) + "\t|" + aviao.company + "\t|" + aviao.flight + "\t|" + aviao.departureTime + "\t|" + aviao.destination + "\t|" + aviao.gate);
            i++;
        }
    }

    int numOfAirplanes(){
      return airplanes.size();
    } 
    
    Airplane getAirplane(int index){
        Airplane aviao;
        try{
            aviao = airplanes.get(index-1); 
        }catch(Exception e){
            aviao = null;
        }
        return aviao;
        
    }
}
