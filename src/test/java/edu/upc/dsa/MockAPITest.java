package edu.upc.dsa;

import edu.upc.dsa.models.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MockAPITest {
    private MockAPI ma;

    @Before
    public void setUp() throws Exception {
        this.ma = MockAPIImpl.getInstance();

        this.ma.addUserLogin("admin", "admin");
        this.ma.addUserLogin("carlo", "carlo");

        this.ma.addObjectStore("keyRed");
    }

    @After
    public void tearDown() {
        this.ma.clear();
    }

    @Test
    public void testAddUser() throws ExistantUserException {
        this.ma.addUserLogin("mario", "mario");
        Assert.assertEquals(3, this.ma.sizeUsers());
    }

    @Test
    public void testGetUserLogin() throws UserNotFoundException, PasswordNotMatchException {
        UserLogin u = this.ma.getUserLogin("carlo", "carlo");
        Assert.assertEquals("carlo", u.getUsername());
    }

    @Test(expected = UserNotFoundException.class)
    public void testGetUserNotFound() throws Exception {
        this.ma.getUser("null", "null");
    }

    @Test(expected = ExistantUserException.class)
    public void testAddExistingUser() throws Exception {
        this.ma.addUserLogin("carlo", "carlo");
    }

    @Test(expected = PasswordNotMatchException.class)
    public void testGetUserPasswordNotMatch() throws Exception {
        this.ma.getUser("carlo", "null");
    }
    @Test
    public void testAddObjectToStore() throws ObjectExist{
        this.ma.addObjectStore("keyBlue");
        Assert.assertEquals(2, this.ma.sizeStore());
    }
    @Test
    public void testBuyObject() throws ObjectNotExist, UserNotFoundException,PasswordNotMatchException{
        this.ma.buyObject("keyRed","carlo");
        User user = this.ma.getUser("carlo","carlo");
        Assert.assertEquals(1,user.size());

    }

}

