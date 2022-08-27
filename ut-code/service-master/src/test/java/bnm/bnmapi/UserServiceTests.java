package bnm.bnmapi;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Test
    void testClass() throws UserNotFoundException{
        UserRepository ur= mock(UserRepository.class);//repo class called to define the service function 
        UserService us= new UserService(ur);//to call the function of the service layer
        Userdetails userd=new Userdetails(1,"abc","abc@gmail.com","male","597976757","abc123","abc123");//this is for what should be returned by repo layer
        Optional<Userdetails> userd1=Optional.of(userd);//converting to optional
        when(ur.findByEmailId(any())).thenReturn(userd1);
        Userdetails user= new Userdetails(1,"abc","abc@gmail.com","male","597976757","abc123","abc123");
        assertEquals(user,us.getUserByEmailId("abc@gmail.com"));
    }
/* 
    @Test
    void testClass1() throws UserNotFoundException{
        UserRepository ur= mock(UserRepository.class);
        UserService us= new UserService(ur);
        Userdetails userd=new Userdetails(1,"abc","abc@gmail.com","male","597976757","abc123","abc123");
        Optional<Userdetails> userd1=Optional.of(userd);
        when(ur.findByUserId(any())).thenReturn(userd1);
        Userdetails user= new Userdetails(1,"abc","abc@gmail.com","male","597976757","abc123","abc123");
        assertEquals(user,us.getUserByUserId(1));
    }
*/ 
}