/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class Database {
    private ArrayList<User> users;
    
    Database(){
      users = new ArrayList<User>();
      userDAO();
    }

    public void userDAO(){
      users.add(new User("Thiago Wallass Nascimento Mendes", "thiagowallass@hotmail.com","thiago", "123456", "159753", "123456-8"));
      users.add(new User("Wesley Araujo Costa Luz", "wesley@hotmail.com", "wesley", "123456", "65481279", "876543-1"));
      users.add(new User("Dayanne Cristina Pereira Gomes", "dayanne@hotmail.com","dayanne","123456", "663202", "152648-7"));
    }

    public void addUser(User user){
      users.add(user);
    }
    
    public int size(){
      return users.size();
    }

    public User validateUsername(String username){
      if(users.size() > 0){
        for(User user:users){
          if(username.equals(user.getUsername()))
            return user;
        }
      }
      return null;
    }

    public boolean validatePassword(String password, User usuario){
      if(password.equals(usuario.getSenha()))
        return true;
      else
        return false;
    }

    public boolean registerUser(){
    User user;
    User exist;
    String name, username, password, email, cpf, card;

    Scanner read = new Scanner(System.in);

    System.out.println("Informe \n Seu username:");
    username = read.next();
    exist = validateUsername(username);
    if(exist == null){
      System.out.println("Sua Senha:");
      password = read.next();
      System.out.println("Seu email: ");
      email = read.next();
      System.out.println("Seu Nome: ");
      name = read.next();
      System.out.println("Seu cpf: ");
      cpf = read.next();
      System.out.println("O numero do seu cartão: ");
      card = read.next();
      user = new User(name,email,username,password,cpf,card);
      addUser(user);
      return true;
    }else
      return false;
  }
  
  public User login(){
    User user;
    String username, password;
    boolean state;

    Scanner read = new Scanner(System.in);

    System.out.println("Nome de usuário:");
    username = read.next();
    user = validateUsername(username);
    if(user != null){
      System.out.println("Senha: ");
      password = read.next();
      state = validatePassword(password, user);
      if(state){
        System.out.println("Bem vindo(a), " + user.getName() + "!\n" );
        return user;
      }else{
        System.out.println("Senha Incorreta");
        return null;
      }
    }else{
      System.out.println("Usuario Inexistente");
      return null;
    }
  }
  public User createUser(){
        
        User user;
        boolean state;
        int option;

        Scanner read = new Scanner(System.in);
        
        do{
            System.out.println("1 - Cadastrar\n2 - Logar\n3 - Sair");
            option = read.nextInt();
            if(option == 1){
                do{
                    state = registerUser();
                    if(state)
                        System.out.println("Usuario Cadastrado com sucesso");
                    else
                        System.out.println("Usuario já existe");      
                }while(!state);
            }else if(option == 2){  
                do{
                    user = login();
                } while(user == null);
                return user;
            }else if(option == 3){;
            }else{
                System.out.println("Opção Inválida");
            }
        }while(option != 3);
        return null;
  }
}
