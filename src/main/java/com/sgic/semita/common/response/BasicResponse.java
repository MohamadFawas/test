package com.sgic.semita.common.response;

import com.sgic.semita.enums.RestApiResponseStatus;

public class BasicResponse extends ApiResponse {
	private String message;

	public BasicResponse(RestApiResponseStatus restApiResponseStatus) {
		super(restApiResponseStatus);
	}

	public BasicResponse() {
		super(RestApiResponseStatus.OK);
	}

	public BasicResponse(RestApiResponseStatus restApiResponseStatus, String message) {
		super(restApiResponseStatus);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
