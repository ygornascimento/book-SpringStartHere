package org.example.proxies;

import org.example.model.Comment;

public class SMSCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for SMS comment: " + comment.getText());
    }
}
