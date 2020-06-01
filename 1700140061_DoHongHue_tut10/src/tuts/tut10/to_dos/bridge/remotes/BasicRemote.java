package tuts.tut10.to_dos.bridge.remotes;

import tuts.tut10.to_dos.bridge.devices.Device;

public class BasicRemote implements Remote {
	protected Device device;

	public BasicRemote() {
	}

	public BasicRemote(Device device) {
		this.device = device;
	}

	@Override
	public void power() {
		System.out.println("Remote: power toggle");
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
		}
	}

	//TO-DO: Implement the volumeDown() method
	@Override
	public void volumeDown() {
		//Display the current status is 'volume down'
        System.out.println("The volume is down");
        //Decrease the current volume for 10
        device.setVolume(device.getVolume() - 10);
		
	}

	//TO-DO: Implement the volumeUp() method
	@Override
	public void volumeUp() {
		//Display the current status is 'volume up'
        System.out.println("Volume is up!");
        //Increase the current volume for 10
        device.setVolume(device.getVolume() + 10);
		
	}

	//TO-DO: Implement the channelDown() method
	@Override
	public void channelDown() {
		System.out.println("Channel down");
		//Display the current status is 'channel down'
        device.setChannel(device.getChannel() - 1);
        //Decrease the current channel for 1
		
	}
	
	//TO-DO: Implement the channelUp() method
	@Override
	public void channelUp() {
		System.out.println("Channel up!");
		//Display the current status is 'channel up'
        device.setChannel(device.getChannel() + 1);
        //Increase the current channel for 1
		
	}
}
