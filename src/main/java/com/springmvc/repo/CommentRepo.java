package com.springmvc.repo;

import com.springmvc.pojo.Comment;

public interface CommentRepo {
	// trasient -> persistence
	Comment addComment(Comment c);
}
