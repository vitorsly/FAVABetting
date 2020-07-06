package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

public enum MessageHandler {
    GETBALANCE("balance",new BalanceMsg()),
    BETINGSTART("betTime",new BettingPhaseStartMessage()),
    HORSES("HorseList",new HorsesMessage()),
    BETOK("betOK",new BetOk()),
    INVALID("",new InvalidMessage());

    private String cmd;
    private Message action;

    MessageHandler(String cmd,Message action){
        this.cmd=cmd;
        this.action=action;
    }

    public static MessageHandler getActionFromString(String msg) {

        if(msg == null || msg.equals("")) {
            return INVALID;
        }

        String actionStr = msg.split(" ")[0];

        for (MessageHandler actions : values()){
            if(actions.cmd.equals(actionStr)){
                return actions;
            }
        }

        return INVALID;
    }

    public  Message getAction(){return action;}

}
