package observerPattern.model;

public class MfcPrc011Bean {
	private Integer mfcPrc011Id;
	private String moldNo;
	private String partNo;
	private String subPartNo;
	
	public MfcPrc011Bean(){
	}
	
	public MfcPrc011Bean(Integer mfcPrc011Id, String moldNo, String partNo, String subPartNo){
		this.mfcPrc011Id = mfcPrc011Id;
		this.moldNo = moldNo;
		this.partNo = partNo;
		this.subPartNo = subPartNo;
	}
	
	public String getMoldNo() {
		return moldNo;
	}

	public Integer getMfcPrc011Id() {
		return mfcPrc011Id;
	}

	public void setMfcPrc011Id(Integer mfcPrc011Id) {
		this.mfcPrc011Id = mfcPrc011Id;
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
	
	
}
