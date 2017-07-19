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
		System.out.println("註冊觀察者物件成功！");
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
		//先清空觀察者物件列表
		observers = new ArrayList<>();
		System.out.println("初始化..");
		String moldNo = mfcPrc011Bean.getMoldNo();
		String partNo = mfcPrc011Bean.getPartNo();
		String subPartNo = mfcPrc011Bean.getSubPartNo();
		//取得該製程排配的所有工段
		List<MfcPrc012Bean> mfcPrc012BeanList = getSections(moldNo, partNo, subPartNo);
		
		for(MfcPrc012Bean mfcPrc012Bean:mfcPrc012BeanList){
			String section = mfcPrc012Bean.getMoldNo() + "_" + mfcPrc012Bean.getPartNo() + "_" + mfcPrc012Bean.getSubPartNo()
							+ "_" + mfcPrc012Bean.getSectionId() + "_" + mfcPrc012Bean.getMfcNo();
			System.out.println("該製程工段:" + section);
			//取得該工段的觀察者物件，並將工段資訊綁定觀察者物件
			Observer observer = getSectionObserver(mfcPrc012Bean);
			if(observer != null){
				//註冊觀察者物件
				this.registerObserver(observer);
			}
		}
	}
	
	public Observer getSectionObserver(MfcPrc012Bean mfcPrc012Bean){
		String sectionId = mfcPrc012Bean.getSectionId();
		switch(sectionId){
		case "EDM":
			System.out.println("建立 EDM 觀察者物件");
			return new EdmObserver(mfcPrc012Bean);
		case "CNC":
			System.out.println("建立 CNC 觀察者物件");
			return new CncObserver(mfcPrc012Bean);
		case "WE":
			
		default:
			throw new NullPointerException("NullPointer");
		}
	}
	
	//製程發佈
	public void release(MfcPrc011Bean mfcPrc011Bean) {
		System.out.println("製程發佈");
		init(mfcPrc011Bean);
		for(Observer observer : observers){
			observer.create();
		}
	}
	
	//製程申請異常/設變
	public void applicationChange(MfcPrc011Bean mfcPrc011Bean, String taskStatus){
		System.out.println("用戶申請異常/設變，異常狀態碼taskStatus:" + taskStatus);
		init(mfcPrc011Bean);
		for(Observer observer : observers){
			observer.update(taskStatus);
		}
		//notifyObserver(mfcPrc012Bean, taskStatus);
	}
	
}
