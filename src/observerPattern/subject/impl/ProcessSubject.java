package observerPattern.subject.impl;

import java.util.ArrayList;
import java.util.List;

import observerPattern.model.MfcPrc011Bean;
import observerPattern.model.MfcPrc012Bean;
import observerPattern.observer.Observer;
import observerPattern.observer.impl.CncObserver;
import observerPattern.observer.impl.EdmObserver;
import observerPattern.subject.Subject;

public class ProcessSubject implements Subject{

	private List<Observer> observers = null;
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		System.out.println("���U�[��̪��󦨥\�I");
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver(MfcPrc012Bean mfcPrc012Bean, String taskStatus) {
		for(Observer observer : observers){
			observer.update(taskStatus);
		}
	}
	

	public List<MfcPrc012Bean> getSections(String moldNo, String partNo, String subPartNo){
		//Integer mfcPrc012Id, String moldNo, String partNo, String subPartNo, String sectionId, String mfcNo
		MfcPrc012Bean mfcPrc012Bean1 = new MfcPrc012Bean(1, moldNo, partNo, subPartNo, "CNC", "1");
		MfcPrc012Bean mfcPrc012Bean2 = new MfcPrc012Bean(2, moldNo, partNo, subPartNo, "EDM", "2");
		List<MfcPrc012Bean> mfcPrc012Bean = new ArrayList<>();
		mfcPrc012Bean.add(mfcPrc012Bean1);
		mfcPrc012Bean.add(mfcPrc012Bean2);
		return mfcPrc012Bean;
	}
	
	public void init(MfcPrc011Bean mfcPrc011Bean) {
		//���M���[��̪���C��
		observers = new ArrayList<>();
		System.out.println("��l��..");
		String moldNo = mfcPrc011Bean.getMoldNo();
		String partNo = mfcPrc011Bean.getPartNo();
		String subPartNo = mfcPrc011Bean.getSubPartNo();
		//���o�ӻs�{�ưt���Ҧ��u�q
		List<MfcPrc012Bean> mfcPrc012BeanList = getSections(moldNo, partNo, subPartNo);
		
		for(MfcPrc012Bean mfcPrc012Bean:mfcPrc012BeanList){
			String section = mfcPrc012Bean.getMoldNo() + "_" + mfcPrc012Bean.getPartNo() + "_" + mfcPrc012Bean.getSubPartNo()
							+ "_" + mfcPrc012Bean.getSectionId() + "_" + mfcPrc012Bean.getMfcNo();
			System.out.println("�ӻs�{�u�q:" + section);
			//���o�Ӥu�q���[��̪���A�ñN�u�q��T�j�w�[��̪���
			Observer observer = getSectionObserver(mfcPrc012Bean);
			if(observer != null){
				//���U�[��̪���
				this.registerObserver(observer);
			}
		}
	}
	
	public Observer getSectionObserver(MfcPrc012Bean mfcPrc012Bean){
		String sectionId = mfcPrc012Bean.getSectionId();
		switch(sectionId){
		case "EDM":
			System.out.println("�إ� EDM �[��̪���");
			return new EdmObserver(mfcPrc012Bean);
		case "CNC":
			System.out.println("�إ� CNC �[��̪���");
			return new CncObserver(mfcPrc012Bean);
		case "WE":
			
		default:
			throw new NullPointerException("NullPointer");
		}
	}
	
	//�s�{�o�G
	public void release(MfcPrc011Bean mfcPrc011Bean) {
		System.out.println("�s�{�o�G");
		init(mfcPrc011Bean);
		for(Observer observer : observers){
			observer.create();
		}
	}
	
	//�s�{�ӽв��`/�]��
	public void applicationChange(MfcPrc011Bean mfcPrc011Bean, String taskStatus){
		System.out.println("�Τ�ӽв��`/�]�ܡA���`���A�XtaskStatus:" + taskStatus);
		init(mfcPrc011Bean);
		for(Observer observer : observers){
			observer.update(taskStatus);
		}
		//notifyObserver(mfcPrc012Bean, taskStatus);
	}
	
}
