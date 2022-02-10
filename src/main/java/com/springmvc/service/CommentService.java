package com.springmvc.service;

import com.springmvc.pojo.Comment;

public interface CommentService {
	Comment addComment(String content, int productId);
}
