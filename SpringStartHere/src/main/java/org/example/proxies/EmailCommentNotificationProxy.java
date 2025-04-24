package org.example.proxies;

import org.example.model.Comment;
import org.example.repositories.CommentRepository;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getText());
    }
}
