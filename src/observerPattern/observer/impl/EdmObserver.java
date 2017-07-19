package observerPattern.observer.impl;

import observerPattern.model.EdmMfc000Bean;
import observerPattern.model.MfcPrc012Bean;
import observerPattern.observer.Observer;

public class EdmObserver implements Observer{
	
	private MfcPrc012Bean mfcPrc012Bean;
	
	public EdmObserver(MfcPrc012Bean mfcPrc012Bean){
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
		//��l���Ȫ��A:�s�{�o�G
		Integer taskStatus = 0;
		edmMfc000Bean.setTaskStatus(taskStatus);
		//dao.insert(edmMfc000Bean);
		System.out.println("insert DB:edmMfc000Bean�A��l���Ȫ��A��:" + taskStatus);
	}

	@Override
	public void update(String taskStatus) {
		updateDB(mfcPrc012Bean, taskStatus);
	}

	private void updateDB(MfcPrc012Bean mfcPrc012Bean, String taskStatus) {
		Integer mfcPrc012Id = mfcPrc012Bean.getMfcPrc012Id();
		EdmMfc000Bean whereCondition = new EdmMfc000Bean();
		whereCondition.setMfcPrc012Id(mfcPrc012Id);
		//���o�Ӥu�q
		//EdmMfc000Bean edmMfc000Bean = edmMfc000Dao.findOne(whereCondition);
		//���Ȫ��A��s���s�{���`�X
		//edmMfc000Bean.setTaskStatus(taskStatus);
		//dao.update(edmMfc000Bean);
		System.out.println("update DB:edmMfc000Bean�A���Ȫ��A�קאּ:" + taskStatus);
	}

		
	
}
