package glasses;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Glasses;
import com.service.GlassesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GlassesServiceTest {
	@Resource
	private GlassesService glassesService;

	@Test
	public void saveTest() {
		Glasses glasses = new Glasses();
		glassesService.save(glasses);
	}

	@Test
	public void getAllTest() {
		List<Glasses> list = glassesService.getAll();
		for (Glasses g : list) {
			System.out.println(g.getBrand());
		}
	}
}
