
package View;

/**
 *
 * @author lenovo
 */
public class User {
  private String name, email, username, password, cpf, card;
  private String reservedSeats;
  
    //construtor
    User(String name,String email,String username,String password,String cpf,String card)
    {
      this.name = name;
      this.email = email;
      this.username = username;
      this.password = password;
      this.cpf = cpf;
      this.card = card;
      reservedSeats = "";
    }
    
    //metodos
    String getName()
    {
     return this.name;
    }
    String getEmail(){
        return this.email;
    }
    String getCpf(){
        return this.cpf;
    }
    String getCard(){
        return this.card;
    }
    String getUsername(){
        return this.username;
    }
    String getSenha(){
        return this.password;
    }

    String reservedSeats(){
      return reservedSeats;
    }
 
    boolean reserveSeat(String seat){
      reservedSeats += seat + " ";
      return true;
    }

    boolean checkingAssentos (String match){
      String[] seats = reservedSeats().split(" ");
      for(String word: seats)
      {
          if(word.equals(match))
              return true;
      }
      return false;
    }
      
    boolean cancelSeat(String seat){
      String[] arrayAssentos = reservedSeats.split(" ");
      reservedSeats = "";
      for(String str: arrayAssentos)
        if(!seat.equals(str)){
          reservedSeats += str;
          reservedSeats += " ";
        }
      return true;
    }
}
