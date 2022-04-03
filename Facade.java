package practice.lld.machine.structural;

import java.sql.Driver;

/**
 * if we have multiple interfaces doing similar kind of jobs/work 
 * then we add facade interface which help in routing to related interface
 * @author Yash
 *
 */
class Firefox{
	
	public static Driver getFirefoxDriver(){
		return null;
	}
	public static void generateHTMLReport(String test,Driver driver){
		System.out.println("Generating HTML Report for Firefox Driver");
	}
	public static void getJUnitReport(String test,Driver driver){
		System.out.println("Generating JUnit Report for Firefox Driver");
	}
}
class Chrome{
	
	public static Driver getChromeDriver(){
		return null;
	}
	public static void generateHTMLReport(String test,Driver driver){
		System.out.println("Generating HTML Report for Chrome Driver");
	}
	public static void getJUnitReport(String test,Driver driver){
		System.out.println("Generating JUnit Report for Chrome Driver");
	}
}
class WebBrowserHelperFacade{
	
	public static void generateReport(String browser,String report, String test){
		
		Driver driver  = null;
		switch(browser){
		 case "firefox":
			 driver = Firefox.getFirefoxDriver();
			 switch(report){
			 case "html":
				 Firefox.generateHTMLReport(test, driver);
				 break;
			 case "junit":
				 Firefox.getJUnitReport(test, driver);
				 break;
			 }
			break;
		 case "chrome":
			 driver = Chrome.getChromeDriver();
			 switch(report){
			 case "html":
				 Chrome.generateHTMLReport(test, driver);
				 break;
			 case "junit":
				 Chrome.getJUnitReport(test, driver);
				 break;
			 }
			 break;
		}
	}
}
public class Facade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		String test = "checkifElementPresent";
		
		WebBrowserHelperFacade.generateReport("firefox", "html", test);
		WebBrowserHelperFacade.generateReport("firefox", "junit", test);
		WebBrowserHelperFacade.generateReport("chrome", "html", test);
		WebBrowserHelperFacade.generateReport("chrome", "junit", test);
	}

}
