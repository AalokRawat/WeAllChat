package chat.data;/*
 * Project Horizon
 * (c) 2018-2019 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */

public class Message {
    private String content;
    private String sender;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
