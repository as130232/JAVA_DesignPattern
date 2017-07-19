package observerPattern.subject;

import observerPattern.model.MfcPrc012Bean;
import observerPattern.observer.Observer;

public interface Subject {
	
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObserver(MfcPrc012Bean mfcPrc012Bean, String taskStatus);
}
