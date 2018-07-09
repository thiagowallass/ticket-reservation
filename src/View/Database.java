
package View;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class Database {
    public ArrayList<User> users;
    private String senha;
    
    Database(){
      users = new ArrayList<User>();
      userDAO();
    }

    public void userDAO(){
      users.add(new User("Thiago Wallass Nascimento Mendes", "thiagowallass@hotmail.com","thiago", "123456", "15975311100", "123456-8"));
      users.add(new User("Wesley Araujo Costa Luz", "wesley@hotmail.com", "wesley", "123456", "65481279100", "876543-1"));
      users.add(new User("Dayanne Cristina Pereira Gomes", "dayanne@hotmail.com","dayanne","123456", "66320287611", "152648-7"));
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

    public boolean registerUser(String usuario,String nome,String senha, String mail,String CPF, String cartao){
    User user,exist;
    String name, username, password, email, cpf, card;
    username = usuario;
    exist = validateUsername(username);
    if(exist == null){
      password = senha;
      email = mail;
      name = nome;
      cpf = CPF;
      card = cartao;
      user = new User(name,email,username,password,cpf,card);
      addUser(user);
      return true;
    }else
      return false;
  }

  
  public boolean login(String usuario, String senha){
    User user;
    String username, password;
    boolean state;
    username = usuario;
    user = validateUsername(username);
    if(user != null){
      password = senha;
      state = validatePassword(password, user);
      if(state == true){
          return true ;     
      }
    }
    return false;
  }
}