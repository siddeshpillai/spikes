package com.novoda.tpbot.bot;

import com.novoda.tpbot.Direction;

interface BotView {

    void onConnect(String room, String serverAddress);

    void onDisconnect();

    void onError(String message);

    void moveIn(Direction direction);

}
