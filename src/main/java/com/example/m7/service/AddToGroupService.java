package com.example.m7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.m1.dao.GroupArticleDao;
import com.example.m1.model.GroupArticle;
import com.example.m7.request.AddToGroupRequest;
import com.example.m7.response.AddToGroupResponse;

@Service
public class AddToGroupService {
	
	@Autowired
	GroupArticleDao groupArticleDao;
	
	public ResponseEntity<AddToGroupResponse> processAddToGroup(Integer userId,AddToGroupRequest request){
		if(groupArticleDao.checkOwnershipOfGroup(userId, request.getGroupId())) {
			GroupArticle groupArticle = new GroupArticle();
			groupArticle.setGroupsId(request.getGroupId());
			groupArticle.setArticleId(request.getArticleId());
			groupArticleDao.insertToGroupArticle(groupArticle);
			return ResponseEntity.ok(new AddToGroupResponse("Added to group successfully!"));
		}
		
		return ResponseEntity
				.badRequest()
				.body(new AddToGroupResponse("Error: YOU are not the owner!"));
	}

}
