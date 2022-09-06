package bnm.bnmapi;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;
import bnm.bnmapi.mapper.ProfileMapper;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class UserServiceTests {
    @org.junit.Test
    public void testForGetUserByEmail() throws UserNotFoundException {
        UserRepository ur = Mockito.mock(UserRepository.class);//repo class called to define the service function
        UserService us = new UserService(ur);//to call the function of the service layer
        UserDetailsDAO usd = new UserDetailsDAO();
        usd.setEmail("abc@gmail.com");
        usd.setGender("male");
        usd.setUser_Id(1);
        usd.setMobile_no("234653221");
        usd.setName("abc");
        usd.setPassword("abc123");
        Optional<UserDetailsDAO> userd1 = Optional.of(usd);
        when(ur.findByEmail(any())).thenReturn(userd1);
        Optional<UserDetailsDAO> userd = Optional.of(usd);
        assertEquals(userd.get(), us.getUserByEmail("abc@gmail.com").get());
    }
    @org.junit.Test
    public void testForGetProfileByEmail() throws UserNotFoundException {
        ProfileRepo ur = Mockito.mock(ProfileRepo.class);//repo class called to define the service function
        UserService us = new UserService(ur);//to call the function of the service layer
        UserProfileDAO usd = new UserProfileDAO();
        usd.setGender("male");
        usd.setMobile_no("234653221");
        usd.setName("abc");
        usd.setEmail("abc@gmail.com");
        usd.setAddress("hyderabad");
        usd.setPreffereddays("sunday");
        usd.setUserId(1);
        usd.setPrefferedlocations("hyderabad");
        usd.setPrefferedstores("lifestyle");
        usd.setPrefferedtimings("10pm");
        Optional<UserProfileDAO> userd1 = Optional.of(usd);
        when(ur.findByEmail(any())).thenReturn(userd1);
        Optional<UserProfileDAO> userd = Optional.of(usd);
        assertEquals(userd.get(), us.getProfileByEmail("abc@gmail.com").get());
    }

    //duplicate key problem!!!!!!!!!
    @org.junit.Test
    public void testForCreateProfile() throws SQLIntegrityConstraintViolationException {
        ProfileRepo ur = Mockito.mock(ProfileRepo.class);//repo class called to define the service function
        UserService us = new UserService(ur);//to call the function of the service layer
        UserProfile usd = new UserProfile();
        UserProfileDAO dao = ProfileMapper.convertToProfileEntity(usd);
        usd.setGender("male");
        usd.setMobile_no("234653221");
        usd.setName("abc");
        usd.setEmail("abc@gmail.com");
        usd.setAddress("hyderabad");
        usd.setPreffereddays("sunday");
        usd.setUserId(199876);
        usd.setPrefferedlocations("hyderabad");
        usd.setPrefferedstores("lifestyle");
        usd.setPrefferedtimings("10pm");
        Optional<UserProfileDAO> userd1 = Optional.of(dao);
        when(ur.save(any())).thenReturn("success");
        Optional<UserProfileDAO> userd = Optional.of(dao);
        assertEquals("success", us.createProfile(usd));
    }
}