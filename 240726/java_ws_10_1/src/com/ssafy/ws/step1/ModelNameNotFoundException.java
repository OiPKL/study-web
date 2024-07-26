package com.ssafy.ws.step1;

public class ModelNameNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String modelName;
	
	public ModelNameNotFoundException(String modelName) {
		super(modelName + " 모델명을 포함하는 자동차가 존재하지 않습니다.");
		this.modelName = modelName;
	}
	
	public String getTitle() {
		return this.modelName;
	}
	
}
