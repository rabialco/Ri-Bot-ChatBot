package com.bot.ribot.handler.state;

import com.bot.ribot.handler.message.Messages;
import com.bot.ribot.model.LineUser;
import org.springframework.stereotype.Component;

@Component
public class ActiveState extends State {
    public static final String DB_COL_NAME = "ACTIVE";

    public String register(String userId, String displayName) {
        return Messages.ALREADY_REGISTERED;
    }

    /**
     * Handle when user's want to create a game.
     */
    public String makeSession(String userId) {
        LineUser user = lineUserRepository.findLineUserByUserId(userId);
        user.setState(ChooseGameState.DB_COL_NAME);
        lineUserRepository.save(user);
        
        //tambahin tapi nanti
        return Messages.ACTIVE_STATE_MAKE_SESSION;
    }

    public String others(String userId, String command) {
        return Messages.ACTIVE_STATE_WRONG_COMMAND;
    }
    



}