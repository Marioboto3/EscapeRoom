package edu.upc.dsa;

import edu.upc.dsa.models.*;

import javax.jws.soap.SOAPBinding;

public interface MockAPI {

    //USER
    public UserLogin addUserLogin(String username, String password) throws ExistantUserException;
    public User addUser(String username, String password, String name, String surname, String mail, int age, int enemigos, int monedas, int minutos, int partidas) throws ExistantUserException;
    public UserLogin getUserLogin(String username, String password) throws UserNotFoundException, PasswordNotMatchException;
    public User getUser (String username,String password) throws UserNotFoundException, PasswordNotMatchException;
    public UserProfile getProfile (String username) throws UserNotFoundException;
    public UserLogin passUserToUserLogin (User user);
    public UserProfile passUserToUserProfile (User user);

    public int sizeUsers();



    //OBJECTS
    public void buyObject(String name, String username) throws ObjectNotExist, UserNotFoundException;
    void addObjectStore(String name) throws ObjectExist;

    public int sizeStore();


    public void clear();


}
