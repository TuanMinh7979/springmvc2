package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.pojo.Comment;
import com.springmvc.pojo.User;
import com.springmvc.service.CommentService;

@RestController

public class ApiCommentController {
	@Autowired
	private CommentService commentService;

	@PostMapping("/api/add-comment")
	// dung ajax post len
	public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> param, HttpSession ses) {
		User u= (User)ses.getAttribute("currentUser");
		if(u!=null) {
		try {
			String content = param.get("content");
			int productId = Integer.valueOf(param.get("productId"));
			Comment c = commentService.addComment(content, productId, u);
			return new ResponseEntity<>(c, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

}
