package practice.lld.machine.structural;

/**
 * when we have hierarchies in both interfaces as well as implementations
 * & we want to hide the implementation from client 
 * it's bridging between TC and remote hierarchies
 * @author Yash
 *
 */
abstract class TV{
	Remote remote;
	TV(Remote r){
		this.remote = r;
	}
	abstract void on();
	abstract void off();
}
class SonyTV extends TV{
    Remote remoteType;
    SonyTV(Remote r){  // Important : accept which remote is it Old OR New
    	super(r);
    	this.remoteType = r;
    }
	@Override
	void on() {
		System.out.print("Sony TV On: ");
		remoteType.on();
	}

	@Override
	void off() {
		System.out.print("Sont TV Off: ");
		remoteType.off();
	}
	
}
class SamsungTV extends TV{
	Remote remoteType;
	SamsungTV(Remote r){
		super(r);
		this.remoteType = r;
	}
	@Override
	void on() {
		System.out.print("Samsung TV On: ");
		remoteType.on();
	}
	@Override
	void off() {
		System.out.print("Samsung TV Off: ");
		remoteType.off();
	}
	
}
interface Remote{
	void on();
	void off();
}
class NewRemote implements Remote{

	@Override
	public void on() {
		System.out.println("Turned ON by New Remote");
	}

	@Override
	public void off() {
		System.out.println("Turned OFF by New Remote");
	}
	
}
class OldRemote implements Remote{

	@Override
	public void on() {
		System.out.println("Turned ON by Old Remote");
	}

	@Override
	public void off() {
		System.out.println("Turned OFF by Old Remote");
	}
	
}
public class Bridge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           
		TV samsungTVNewRemote = new SamsungTV(new NewRemote());
		samsungTVNewRemote.on();
		samsungTVNewRemote.off();
		
		System.out.println();
		
		TV SonyTVOldRemote = new SonyTV(new OldRemote());
		SonyTVOldRemote.on();
		SonyTVOldRemote.off();
	}

}

