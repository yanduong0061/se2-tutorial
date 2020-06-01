package tuts.tut10.to_dos.bridge.devices;

public class Radio implements Device {
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;
	 
	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	//TO-DO: Implement getVolume() method
	@Override
	public int getVolume() {
		return this.volume;
	}

	//TO-DO: Implement setVolume() method
	@Override
	public void setVolume(int volume) {
		if(volume < 0) {
			System.err.println("Volume can no be smaller than 0");
			
		} else if(volume > 100){
			System.err.println("Volume can not be larger than 100");
		} else {
			this.volume = volume;
		}
		//use 'if-elseif-else' structure to limit the volume from 0 to 100
		//outside the range is invalid
	 
	}

	//TO-DO: Implement getChannel() method
	@Override
	public int getChannel() {
		return this.channel;
	}

	//TO-DO: Implement setChannel() method
	@Override
	public void setChannel(int channel) {
		 if(channel < 0) {
			 System.err.println("Channel can not be smaller than 0");
		 } else {
			 this.channel = channel;
		 }
	}

	//TO-DO: Implement printStatus() method
	@Override
	public void printStatus() {
		//Show the current device is radio
		System.out.println("Radio starting...");
		//Show the current status: enabled or disabled
		if(isEnabled()) {
			enable();
		} else {
			disable();
		}
		//Show the current volume
		
		System.out.println("Current volume: " + this.volume);
		//Show the current channel
		System.out.println("Current channel: " + this.channel);
 
	}
}
