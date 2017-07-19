package observerPattern.observer;

import observerPattern.model.MfcPrc012Bean;

public interface Observer {
	
	public void create();
	
	public void update(String taskStatus);
}
