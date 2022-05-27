package Test_Scripts;



import org.testng.annotations.Test;

import Generic_Library.BaseClass;
import POM.SkillraryLoginPage;

public class Login extends BaseClass {
	
	@Test
	public void testLogin() {
		SkillraryLoginPage s = new SkillraryLoginPage(driver);
		s.un("admin");
		s.pw("admin");
		s.cl();
	}

}
