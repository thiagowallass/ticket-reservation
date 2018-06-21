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
public class Airplane {
    GenericClass first;
    EconomicClass economic;
    int numberOfRows;
    int gate, flight;
    String company;
    String destination;
    String departureTime;
    
    Airplane(int p, int e, String company, int flight, int gate, String departureTime, String destination){
        first = new FirstClass(p);
        economic = new EconomicClass(e, p);
        numberOfRows = p + e;
        this.company = company;
        this.flight = flight;
        this.gate = gate;
        this.destination = destination;
        this.departureTime = departureTime;
    }
    
    void setFlight(int flight, int gate, String departureTime, String destination){
        this.flight = flight;
        this.gate = gate;
        this.departureTime = departureTime;
        this.destination = destination;
    }
    
    void checkSeats(int option){
        switch (option) {
            case 1:
                first.print();
                break;
            case 2:
                economic.print();
                break;
            default:
                first.print();
                economic.print();
                break;
        }
    }
    
    boolean reserveSeat(User user, String option){
        return reserveSeats(user, option);
    }

    void boardingPass(User user, String seat){
      System.out.println("Cartão de Embarque \t \t" + company + "\n");
      System.out.println("Nome do passageiro: " + user.getName() + "\nVoo: " + flight + "\nDestino: "+ destination + "\tAssento: "+ seat.toUpperCase() + "\nSaída: " + departureTime + "\t\tPortão: " + gate + "\n");
        
    }

    public boolean rebookSeat(User user, String oldSeat, String newSeat){
      boolean state;

      if(user.reservedSeats().contains(oldSeat)){
        cancelSeat(user, oldSeat);
        state = reserveSeat(user, newSeat);
        if(!state)
          reserveSeat(user, oldSeat);
        return state;
      }
      return false;
    }

    public boolean cancelReserve(User user, String seat){
      if(user.reservedSeats().contains(seat)){
        return cancelSeat(user, seat);
      }
      return false;
    }
    
    private int getRow(String str){
        int row;
        switch (str.length()) {
            case 2:
                row = Integer.parseInt(str.substring(0, 1));
                row--;
                break;
            case 3:
                row = Integer.parseInt(str.substring(0, 2));
                row--;
                break;
            default:
                row = -1;
                break;
        }
        return row;
    }
    
    private String getSeat(String str){
        String seat;
        switch (str.length()) {
            case 2:
                seat = str.substring(1).toUpperCase();
                break;
            case 3:
                seat = str.substring(2).toUpperCase();
                break;
            default:
                seat = null;
                break;
        }
        return seat;
    }

    private boolean reserveSeats(User user, String option){
        String seat;
        int row;
        boolean state;
        
        row = getRow(option);
        seat = getSeat(option);
        
        try{
            if(row < first.rows.length){
                state = first.rows[row].seats[Seat.converteToPos(seat)].reserveSeat();
                if(state)
                  user.reserveSeat(option);
                return state;
            }else if(row < first.rows.length + economic.rows.length){
                row = row - 5;
                state = economic.rows[row].seats[Seat.converteToPos(seat)].reserveSeat();
                if(state)
                  user.reserveSeat(option);
                return state;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

    private boolean cancelSeat(User user, String option){
        String seat;
        int row;
        boolean state;
        
        row = getRow(option);
        seat = getSeat(option);
        
        try{
            if(row < first.rows.length){
                state = first.rows[row].seats[Seat.converteToPos(seat)].cancelReserve();
                if(state)
                  user.cancelSeat(option);
                return state;
            }else if(row < first.rows.length + economic.rows.length){
                row = row - 5;
                state = economic.rows[row].seats[Seat.converteToPos(seat)].cancelReserve();
                if(state)
                  user.cancelSeat(option);
                return state;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    
     boolean validRow(String seat, int numberOfClass)
    { 
      int chair = getRow(seat);
      if(numberOfClass == 1){
        if(chair <= (first.rows.length-1)){
          return true;
        }else{
          return false;
        }
      }
      if(numberOfClass == 2){
        if(chair > (first.rows.length-1)){
          return true;
        }else{
          return false;
        }
      }
      if(numberOfClass == 3){
       return true;
      }
      return false;
    }
}
