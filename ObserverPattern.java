package practice.lld.machine.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Whenever there is change in data , we notify other related micro-services 
 * @author Yash
 *
 */
interface Subject{
	
	void register(Observer obj);
	void unregister(Observer obj);
	void notifyObservers();
}
class DeliveryData implements Subject{ // Topic

	private List<Observer> observers;
	private String location;
	DeliveryData(){
		this.observers = new ArrayList<>();
	}
	@Override
	public void register(Observer obj) {
		observers.add(obj);
	}

	@Override
	public void unregister(Observer obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.update(location);
		}
	}  
	
	// you get notified when location changed
	public void locationChanged(){
		this.location = getLocation();
		notifyObservers();
	}
	private String getLocation() {
		// TODO Auto-generated method stub
		return "Jaipur";  // hard coded
	}
	
}
interface Observer{
	void update(String location);  // can made it to generic -> data
}
class Seller implements Observer{

	private String location;
	@Override
	public void update(String location) {
		this.location = location;
		showLocation();
	}
	private void showLocation() {
		System.out.println("Notification to Seller - Current location: "+ location);
	}
	
}
class User implements Observer{
	
    private String location;
	@Override
	public void update(String location) {
		// TODO Auto-generated method stub
		this.location = location;
		showLocation();
	}
	private void showLocation() {
		System.out.println("Notification to User: Current Location: "+ location);
	}
	
}
class WareHouseCenter implements Observer{
    
	private String location;
	@Override
	public void update(String location) {
		this.location = location;
		showLocation();
	}
	private void showLocation() {
		System.out.println("Notifcation to WareHouse Center: Current Location: "+ location);
	}
	
}
public class ObserverPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeliveryData deliveryData = new DeliveryData();
        
        Observer seller = new Seller();
        Observer  user = new User();
        Observer wareHouse = new WareHouseCenter();
        
        deliveryData.register(seller);
        deliveryData.register(user);
        deliveryData.register(wareHouse);
        
        deliveryData.locationChanged();
        
        deliveryData.unregister(seller);
        System.out.println();
        
        deliveryData.locationChanged();
	}

}
