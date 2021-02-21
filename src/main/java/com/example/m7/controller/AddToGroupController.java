package com.example.m7.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.m4.services.UserDetailsImpl;
import com.example.m7.exception.ErrorExc;
import com.example.m7.request.AddToGroupRequest;
import com.example.m7.response.AddToGroupResponse;
import com.example.m7.service.AddToGroupService;

@RestController
@RequestMapping("/api/group")
public class AddToGroupController {
	
	@Autowired
	AddToGroupService addToGroupService;

	@PostMapping("/add-to-group")
	public ResponseEntity<AddToGroupResponse> registerUser(@Valid @RequestBody AddToGroupRequest request) throws ErrorExc {
		UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return addToGroupService.processAddToGroup(user.getId(), request);
	}

}
