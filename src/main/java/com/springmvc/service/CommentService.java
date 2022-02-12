package com.springmvc.service;

import com.springmvc.pojo.Comment;
import com.springmvc.pojo.User;

public interface CommentService {
	Comment addComment(String content, int productId, User createtor);
}
