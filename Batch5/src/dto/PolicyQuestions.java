package dto;
public class PolicyQuestions {
	
	public String polQuesId;
	public Integer polQuesSeq;
	public String busSegId;
	public String polQuesDesc;
	public String polQuesAns1;
	public Integer polQuesAns1Weightage;
	public String polQuesAns2;
	public Integer polQuesAns2Weightage;
	public String polQuesAns3;
	public Integer polQuesAns3Weightage;
	public String polQuesAns4;
	public Integer polQuesAns4Weightage;
	public String polQuesAns5;
	public Integer polQuesAns5Weightage;
	public PolicyQuestions() {
		super();
	}

	public PolicyQuestions(String polQuesId, Integer polQuesSeq, String busSegId, String polQuesDesc,
			String polQuesAns1, Integer polQuesAns1Weightage, String polQuesAns2, Integer polQuesAns2Weightage,
			String polQuesAns3, Integer polQuesAns3Weightage,String polQuesAns4, Integer polQuesAns4Weightage,String polQuesAns5, Integer polQuesAns5Weightage) {
		super();
		this.polQuesId = polQuesId;
		this.polQuesSeq = polQuesSeq;
		this.busSegId = busSegId;
		this.polQuesDesc = polQuesDesc;
		this.polQuesAns1 = polQuesAns1;
		this.polQuesAns1Weightage = polQuesAns1Weightage;
		this.polQuesAns2 = polQuesAns2;
		this.polQuesAns2Weightage = polQuesAns2Weightage;
		this.polQuesAns3 = polQuesAns3;
		this.polQuesAns3Weightage = polQuesAns3Weightage;
		this.polQuesAns4 = polQuesAns4;
		this.polQuesAns4Weightage = polQuesAns4Weightage;
		this.polQuesAns5 = polQuesAns5;
		this.polQuesAns5Weightage = polQuesAns5Weightage;
	}
public String getPolQuesId() {
		return polQuesId;
	}

	public void setPolQuesId(String polQuesId) {
		this.polQuesId = polQuesId;
	}

	public Integer getPolQuesSeq() {
		return polQuesSeq;
	}

	public void setPolQuesSeq(Integer polQuesSeq) {
		this.polQuesSeq = polQuesSeq;
	}

	public String getBusSegId() {
		return busSegId;
	}

	public void setBusSegId(String busSegId) {
		this.busSegId = busSegId;
	}

	public String getPolQuesDesc() {
		return polQuesDesc;
	}

	public void setPolQuesDesc(String polQuesDesc) {
		this.polQuesDesc = polQuesDesc;
	}

	public String getPolQuesAns1() {
		return polQuesAns1;
	}

	public void setPolQuesAns1(String polQuesAns1) {
		this.polQuesAns1 = polQuesAns1;
	}

	public Integer getPolQuesAns1Weightage() {
		return polQuesAns1Weightage;
	}

	public void setPolQuesAns1Weightage(Integer polQuesAns1Weightage) {
		this.polQuesAns1Weightage = polQuesAns1Weightage;
	}

	public String getPolQuesAns2() {
		return polQuesAns2;
	}

	public void setPolQuesAns2(String polQuesAns2) {
		this.polQuesAns2 = polQuesAns2;
	}

	public Integer getPolQuesAns2Weightage() {
		return polQuesAns2Weightage;
	}

	public void setPolQuesAns2Weightage(Integer polQuesAns2Weightage) {
		this.polQuesAns2Weightage = polQuesAns2Weightage;
	}

	public String getPolQuesAns3() {
		return polQuesAns3;
	}

	public void setPolQuesAns3(String polQuesAns3) {
		this.polQuesAns3 = polQuesAns3;
	}

	public Integer getPolQuesAns3Weightage() {
		return polQuesAns3Weightage;
	}

	public void setPolQuesAns3Weightage(Integer polQuesAns3Weightage) {
		this.polQuesAns3Weightage = polQuesAns3Weightage;
	}
	public String getPolQuesAns4() {
		return polQuesAns4;
	}

	public void setPolQuesAns4(String polQuesAns4) {
		this.polQuesAns4 = polQuesAns4;
	}

	public Integer getPolQuesAns4Weightage() {
		return polQuesAns4Weightage;
	}

	public void setPolQuesAns4Weightage(Integer polQuesAns4Weightage) {
		this.polQuesAns4Weightage = polQuesAns4Weightage;
	}

	public String getPolQuesAns5() {
		return polQuesAns5;
	}

	public void setPolQuesAns5(String polQuesAns5) {
		this.polQuesAns5 = polQuesAns5;
	}

	public Integer getPolQuesAns5Weightage() {
		return polQuesAns5Weightage;
	}

	public void setPolQuesAns5Weightage(Integer polQuesAns5Weightage) {
		this.polQuesAns5Weightage = polQuesAns5Weightage;
	}

	@Override
	public String toString() {
		return "Policy_Questions [polQuesId=" + polQuesId + ", polQuesSeq=" + polQuesSeq + ", busSegId=" + busSegId
				+ ", polQuesDesc=" + polQuesDesc + ", polQuesAns1=" + polQuesAns1 + ", polQuesAns1Weightage="
				+ polQuesAns1Weightage + ", polQuesAns2=" + polQuesAns2 + ", polQuesAns2Weightage="
				+ polQuesAns2Weightage + ", polQuesAns3=" + polQuesAns3 + ", polQuesAns3Weightage="
				+ polQuesAns3Weightage + ", polQuesAns4=" + polQuesAns4 + ", polQuesAns4Weightage="
						+ polQuesAns4Weightage + ", polQuesAns5=" + polQuesAns5 + ", polQuesAns5Weightage="
								+ polQuesAns5Weightage + "]";
	}
	
}
