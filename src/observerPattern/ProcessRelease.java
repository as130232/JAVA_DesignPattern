package observerPattern;

import java.util.Scanner;

import observerPattern.model.MfcPrc011Bean;
import observerPattern.subject.impl.ProcessSubject;

public class ProcessRelease {

	public static void main(String[] args){
		
		ProcessSubject process = new ProcessSubject();
		String moldNo = "NT170010";
		String partNo = "F001";
		String subPartNo = "AAA";
		MfcPrc011Bean mfcPrc011Bean = new MfcPrc011Bean();
		mfcPrc011Bean.setMfcPrc011Id(1);
		mfcPrc011Bean.setMoldNo(moldNo);
		mfcPrc011Bean.setPartNo(subPartNo);
		mfcPrc011Bean.setPartNo(subPartNo);

		
		System.out.println("------------------");
		while(true){
			System.out.println("�п�J���O�X:");
			Scanner in = new Scanner(System.in);
			int command = in.nextInt();
			switch(command){
			case 1:
				//�s�{�o�G
				process.release(mfcPrc011Bean);
				break;
			case 2:
				//�s�{�ӽв��`���s�{
				String taskStatus = "999";
				process.applicationChange(mfcPrc011Bean, taskStatus);
				break;
			case 3:
				//EdmCam����
				
			}
		}
	}
}
