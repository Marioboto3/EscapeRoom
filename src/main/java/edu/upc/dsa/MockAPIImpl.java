package edu.upc.dsa;

import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.lang.Object;
import java.util.HashMap;

public class MockAPIImpl implements MockAPI {
    private static MockAPI instance;

    HashMap<String, User> userHashMap;
    HashMap<String, Obj> objectHashMap;

    final static Logger logger = Logger.getLogger(MockAPIImpl.class);

    private MockAPIImpl() {
        this.userHashMap = new HashMap<>();
        this.objectHashMap = new HashMap<>();
    }

    public static MockAPI getInstance() {
        if (instance==null) instance = new MockAPIImpl();
        return instance;
    }

    public int sizeUsers() {
        int ret = this.userHashMap.size();
        logger.info("size " + ret);
        return ret;
    }
    public int sizeStore() {
        int ret = this.objectHashMap.size();
        logger.info("size " + ret);
        return ret;
    }

    @Override
    public UserProfile getProfile(String username) throws UserNotFoundException {
        User user = this.userHashMap.get(username);
        if(user==null) throw new UserNotFoundException();
        UserProfile userProfile = this.passUserToUserProfile(user);
        return userProfile;
    }

    @Override
    public UserLogin addUserLogin(String username, String password) throws ExistantUserException {
        User u = this.userHashMap.get(username);
        if(u!=null) throw new ExistantUserException();
        u = new User(username,password);
        this.userHashMap.put(username,u);
        logger.info("New user: "+u.toString());
        UserLogin userLogin = this.passUserToUserLogin(u);
        return userLogin;
    }

    @Override
    public User addUser(String username, String password, String name, String surname, String mail, int age, int enemigos, int monedas, int minutos, int partidas) throws ExistantUserException {
        User u = this.userHashMap.get(username);
        if(u!=null) throw new ExistantUserException();
        u = new User(username,password, name,surname,mail,age,enemigos,minutos,monedas,partidas);
        this.userHashMap.put(username,u);
        logger.info("New user: "+u.toString());
        return u;       }

    @Override
    public UserLogin getUserLogin(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        User user = this.userHashMap.get(username);
        if(user==null) throw new UserNotFoundException();
        if(!password.equals(user.getPassword())) throw new PasswordNotMatchException();
        logger.info("Logged in: "+user.toString());
        UserLogin userLogin = this.passUserToUserLogin(user);
        return userLogin;    }

    @Override
    public User getUser(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        User u = this.userHashMap.get(username);
        if(u==null) throw new UserNotFoundException();
        if(!password.equals(u.getPassword())) throw new PasswordNotMatchException();
        return u;
    }

    @Override
    public void buyObject(String name, String username) throws ObjectNotExist, UserNotFoundException {
        Obj object = this.objectHashMap.get(name);
        if (object==null)  throw new ObjectNotExist();
        logger.info("Objecto: " + object.toString());
        User user = this.userHashMap.get(username);
        if(user==null) throw new UserNotFoundException();
        logger.info("User: "+ user.toString());
        user.addObject(object);
        logger.info("Objeto añadido: " + object.toString());

    }

    @Override
    public void addObjectStore(String name) throws ObjectExist {
        Obj obj = this.objectHashMap.get(name);
        if(obj==null) {
            Obj obje = new Obj(name);
            this.objectHashMap.put(obje.getNombre(),obje);
            logger.info("Objeto añadido a la store: " + obje.toString());
        }
        else throw new ObjectExist();

    }

    @Override
    public void clear() {
        this.userHashMap.clear();
    }

    @Override
    public UserLogin passUserToUserLogin(User user) {
        UserLogin userLogin = new UserLogin(user.getUsername(),user.getPassword());
        return userLogin;
    }

    @Override
    public UserProfile passUserToUserProfile(User user) {
        UserProfile userProfile= new UserProfile(user.getUsername(),user.getPassword(),user.getName(),user.getSurname(),user.getMail(),user.getAge());
        return userProfile;
    }
}