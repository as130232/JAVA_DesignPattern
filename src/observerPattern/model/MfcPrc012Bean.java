package observerPattern.model;

public class MfcPrc012Bean {
	private Integer mfcPrc012Id;
	private String moldNo;
	private String partNo;
	private String subPartNo;
	private String sectionId;
	private String mfcNo;
	
	public MfcPrc012Bean(){
	}
	
	public MfcPrc012Bean(Integer mfcPrc012Id, String moldNo, String partNo, String subPartNo, String sectionId, String mfcNo){
		this.mfcPrc012Id = mfcPrc012Id;
		this.moldNo = moldNo;
		this.partNo = partNo;
		this.subPartNo = subPartNo;
		this.sectionId = sectionId;
		this.mfcNo = mfcNo;
	}
	
	public String getMoldNo() {
		return moldNo;
	}

	public Integer getMfcPrc012Id() {
		return mfcPrc012Id;
	}

	public void setMfcPrc012Id(Integer mfcPrc012Id) {
		this.mfcPrc012Id = mfcPrc012Id;
	}

	public void setMoldNo(String moldNo) {
		this.moldNo = moldNo;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getSubPartNo() {
		return subPartNo;
	}

	public void setSubPartNo(String subPartNo) {
		this.subPartNo = subPartNo;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getMfcNo() {
		return mfcNo;
	}

	public void setMfcNo(String mfcNo) {
		this.mfcNo = mfcNo;
	}
	
	
	
}
