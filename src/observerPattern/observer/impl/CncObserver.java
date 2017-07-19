package observerPattern.observer.impl;

import observerPattern.model.CncMfc000Bean;
import observerPattern.model.EdmMfc000Bean;
import observerPattern.model.MfcPrc012Bean;
import observerPattern.observer.Observer;

public class CncObserver implements Observer{
	private MfcPrc012Bean mfcPrc012Bean;
	
	public CncObserver(MfcPrc012Bean mfcPrc012Bean){
		this.mfcPrc012Bean = mfcPrc012Bean;
	}
	

	@Override
	public void create() {
		insertDB(mfcPrc012Bean);
	}
	
	private void insertDB(MfcPrc012Bean mfcPrc012Bean) {
		EdmMfc000Bean edmMfc000Bean = new EdmMfc000Bean();
		Integer mfcPrc012Id = mfcPrc012Bean.getMfcPrc012Id();
		edmMfc000Bean.setMfcPrc012Id(mfcPrc012Id);
		//初始任務狀態:製程發佈
		Integer taskStatus = 0;
		edmMfc000Bean.setTaskStatus(taskStatus);
		//dao.insert(edmMfc000Bean);
		System.out.println("insert DB:cncMfc000Bean，初始任務狀態為:" + taskStatus);
	}

	@Override
	public void update(String taskStatus) {
		updateDB(mfcPrc012Bean, taskStatus);
	}

	private void updateDB(MfcPrc012Bean mfcPrc012Bean, String taskStatus) {
		Integer mfcPrc012Id = mfcPrc012Bean.getMfcPrc012Id();
		CncMfc000Bean whereCondition = new CncMfc000Bean();
		whereCondition.setMfcPrc012Id(mfcPrc012Id);
		//取得該工段
		//CncMfc000Bean cncMfc000Bean = cncMfc000Dao.findOne(whereCondition);
		//任務狀態更新為製程異常碼
		//cncMfc000Bean.setTaskStatus(taskStatus);
		//dao.update(cncMfc000Bean);
		System.out.println("update DB:cncMfc000Bean，任務狀態修改為:" + taskStatus);
	}
}
