package user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.User;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
	@Resource
	private UserService userService;
	@Test
	public void getAllUserTest(){
		List<User> user = new ArrayList<User>();
		user=userService.getAll();
		for(User u:user){
			//System.out.println(u.getName());
		}
	}
	@Test
	public void saveUserTest(){
		User user = new User();
		user.setName("11");
		user.setAge(23);
		user.setPwd("dfd");
		userService.saveUser(user);
	}
	@Test
	public void checkNameTest(){
		String name = "kkkk";
		boolean flag = userService.checkName(name);
		System.out.println(flag);
	}
}
