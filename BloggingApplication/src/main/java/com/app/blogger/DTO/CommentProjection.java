package com.app.blogger.DTO;

import java.time.LocalDateTime;

public interface CommentProjection {

	Long getCommentId();
	String getCommentDescription();
	LocalDateTime getDateTime();
	
}
