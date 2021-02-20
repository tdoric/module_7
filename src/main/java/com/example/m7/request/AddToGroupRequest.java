package com.example.m7.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddToGroupRequest {
	@NotNull
	private Integer groupId;
	@NotNull
	private Integer articleId;

}
