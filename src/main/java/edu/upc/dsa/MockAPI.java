package edu.upc.dsa;

import edu.upc.dsa.models.Exceptions.*;
import edu.upc.dsa.models.Users.*;

public interface MockAPI {

    //USER
    public User addUser(String username, String password, String name, String surname, String mail, int age) throws ExistantUserException;
    public UserLogin getUserLogin(String username, String password) throws UserNotFoundException, PasswordNotMatchException;
    public User getUser (String username,String password) throws UserNotFoundException;
    public UserProfile getProfile (String username) throws UserNotFoundException;
    public UserInventary getInventary (String username) throws  UserNotFoundException;
    public UserStatistics getStatistics(String username) throws UserNotFoundException;
    public UserLogin passUserToUserLogin (User user);
    public UserProfile passUserToUserProfile (User user);
    public UserStatistics passUserToUserStatistics (User user);
    public UserInventary passUserToUserInvetary (User user);
    public int sizeUsers();

    //OBJECTS
    public void buyObject(String name, String username) throws ObjectNotExist, UserNotFoundException;
    void addObjectStore(String name) throws ObjectExist;
    public int sizeStore();


    public void clear();


}
