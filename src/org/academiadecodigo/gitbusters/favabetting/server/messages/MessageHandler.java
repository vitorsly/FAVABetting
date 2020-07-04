package org.academiadecodigo.gitbusters.favabetting.server.messages;

public enum MessageHandler {
    BET("bet",new BetMessage()),
    INVALID("",new InvalidMessage());

    private String actionMessage;
    private Message message;

    MessageHandler(String actionMessage,Message message)
    {
        this.actionMessage=actionMessage;
        this.message=message;
    }

    public static MessageHandler getActionFromString(String actionMessage){
        if (actionMessage == null || actionMessage .equals("")) {
            return INVALID;
        }
        String action= actionMessage.split(" ")[0];
        for (MessageHandler messageHandler:values()){
            if(messageHandler.actionMessage.equals(action)){
                return messageHandler;
            }
        }
        return INVALID;
    }

    public Message getMessage() {
        return message;
    }
}
