package practice.lld.machine.structural;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Whenever there is need of creating many object of a class. 
 * { whenever you want to create objects more than 10^5 }
 * we use it to reduce the object creation{ improve time also }
 * Ex.: Counter Strike { there we have terrorist and anti-terrorists }
 * here task of all the terrorist/anti-terrorists is same , if we have 100 terrorist 
 * we don;t want to create 100 objects of it, can keep it to single creation
 * @author Yash
 *
 */
interface Employee{
	public void assignSkill(String skill);
	public void task();
}
class Developer implements Employee{
	private final String Job = "Fix the issue";
    private String skill;
	@Override
	public void assignSkill(String skill) {
		// TODO Auto-generated method stub
		this.skill =skill;
	}

	@Override
	public void task() {
		// TODO Auto-generated method stub
		System.out.println("Developer with skill : " + this.skill + " with Job : " + Job);
	}
	
}
class Tester implements Employee{
    
	private final String Job = "Test the issue";
	private String skill;
	@Override
	public void assignSkill(String skill) {
		// TODO Auto-generated method stub
		this.skill = skill;
	}

	@Override
	public void task() {
		// TODO Auto-generated method stub
		System.out.println("Tester with Skill: "+this.skill + " with Job: "+ Job);
	}
	
}
class EmployeeFactory{
	
	static Map<String,Employee> empMap = new HashMap<>();
	public static Employee getEmployee(String employeeType){
		Employee e = null;
		
		if(empMap.containsKey(employeeType)){
			e = empMap.get(employeeType);
		}else{
			switch(employeeType){
			
			 case "Developer":
				 System.out.println("Developer Created");
				 e = new Developer();
				 break;
			 case "Tester":
				 System.out.println("Tester Created");
				 e = new Tester();
				 break;
			  }
			empMap.put(employeeType, e);
	     }
		return e;
	}
}
public class Flyweight {
    
	private static String EmpType[] = {"Developer","Tester"};
	private static String Skills[] = {"Java","C++","Golang","Python"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		for(int i=0;i<10;i++){
			
			Employee emp = EmployeeFactory.getEmployee(getRandEmployee());
			emp.assignSkill(getRandSkill());
			emp.task();
		}
	}
	private static String getRandEmployee() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int idx = r.nextInt(EmpType.length);
		
		return EmpType[idx];
	}

	private static String getRandSkill() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int idx = r.nextInt(Skills.length);
		return Skills[idx];
	}

	

}
