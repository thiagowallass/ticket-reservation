/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservation;

import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class TicketReservation {

    /**
     * @param args the command line arguments
     */
  static void reservePass(User user, Airport airport){
    Airplane airplane;
    int option; String option2; int menuoption;
    int row; String seat;
    boolean state, stat, found;
    
    Scanner read = new Scanner(System.in);

    do{
      airport.print();
      System.out.println(airport.numOfAirplanes() + 1 + " - Sair");
      System.out.println("Escolha um voo: ");
      option = read.nextInt();
      if(option != airport.numOfAirplanes() + 1){
        airplane = airport.getAirplane(option);
        if(airplane != null){
          System.out.print("Avião selecionado: ");
          System.out.println("Opção: " + option + " | Destino: " + airplane.destination + " | Horario: " + airplane.departureTime);
          do{
            found = false;
            System.out.println("1 - Consultar vagas\n2 - Reservar assento\n3 - Seus assentos\n4 - Trocar assento\n5 - Cancelar reserva\n6 - Emitir cartão de embarque\n7 - Sair");
            System.out.println("Escolha uma opção: ");
            menuoption = read.nextInt();
            switch(menuoption){
              case 1:                          //RESERVAR
                airplane.checkSeats(3);
                break;
              case 2:
                do{
                  System.out.println("1 - Primeira Classe \n2 - Classe Econômica \n3 - Todas as classes \n4 - Voltar");
                  System.out.println("Escolha uma opcao: ");
                  option = read.nextInt();
                  if(option >= 1 && option <=3){
                      airplane.checkSeats(option);
                      System.out.println("Digite o assento que você desejar reservar: (Ex: 20F)");
                      option2 = read.next();
                      stat = airplane.validRow(option2,option);
                      if(stat){
                        state = airplane.reserveSeat(user, option2.toUpperCase());
                        if(state){                       
                          System.out.println("Assento Reservado com Sucesso!");    
                        }else{
                          System.out.println("Impossível reservar este assento!");
                        }
                      }else{
                        System.out.println("Assento pertece a outra classe");
                      }       
                  }else if(option == 4);
                  else
                    System.out.println("Opcão Inválida!");
                }while(option != 4);
                break;
              case 3:
                System.out.println("Seus assentos: " + user.reservedSeats());
                break;
              case 4:
                System.out.println("Seus assentos são: " + user.reservedSeats() + ". Escolha um assento para remarcar");
                String oldAssento = read.next();
                System.out.println("Digite o novo assento que marcar: ");
                String newAssento = read.next();
                state = airplane.rebookSeat(user, oldAssento.toUpperCase(), newAssento.toUpperCase());
                if(state)
                  System.out.println("Assento remarcado com sucesso!");
                else
                  System.out.println("Impossível remarcar assento");
                break;
              case 5:
                System.out.println("Digite o assento que deseja cancelar: ");
                seat = read.next();
                state = airplane.cancelReserve(user, seat.toUpperCase());
                if(state)
                  System.out.println("Assento cancelado com sucesso!");
                else
                  System.out.println("Impossível cancelar assento");
                break;
              case 6:
                if(user.reservedSeats() != null && !user.reservedSeats().trim().isEmpty()){
                  System.out.println("Qual será o assento ocupado por " + user.getName() + " no voo? \nAssentos reservados: " + user.reservedSeats());
                  while(!found){
                    seat = read.next();
                    found = user.checkingAssentos(seat.toUpperCase());
                    if(found){
                      System.out.println("Emitindo cartão de embarque.\n");
                      airplane.boardingPass(user, seat.toUpperCase());
                    }else{
                      System.out.println("Assento inválido.");
                    }
                  }
                }else{
                  System.out.println("Não é possível emitir cartão de embarque sem reservar um assento.\n");
                }
                break;
              case 7:
                break;
              default:
                System.out.println("Opcão Inválida");
            }
          }while(menuoption != 7);
        }else
          System.out.println("Opção Inválida!");
      }
    }while(option != airport.numOfAirplanes() + 1);
  }

  public static void main(String[] args) {

    User user;
      
    Airport airport = new Airport();
    Database database = new Database();
    
    do{
      user = database.login();
      if(user != null)
        reservePass(user, airport);
    }while(user != null);
  }
    
}
