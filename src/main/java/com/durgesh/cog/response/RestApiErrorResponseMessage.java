package com.durgesh.cog.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestApiErrorResponseMessage {
	
	private Integer errorCode;
	private String msg;
	private Date date;
	

}
