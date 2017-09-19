package com.brookmanholmes.bma.domain.model.player.controller;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.game.PlayerTurn;
import com.brookmanholmes.bma.domain.model.player.Pair;
import com.brookmanholmes.bma.domain.model.player.Player;
import com.brookmanholmes.bma.domain.model.turn.ITurn;

/**
 * Created by Brookman Holmes on 1/12/2016.
 * A controller for adding up player stats for BCA 10 ball
 */
class TenBallController extends PlayerController {
    public TenBallController(String playerId, String opponentId, String playerName, String opponentName, int playerRank, int opponentRank) {
        super(playerId, opponentId, playerName, opponentName, playerRank, opponentRank);
    }

    @Override
    public Pair<Player> addTurn(GameStatus gameStatus, ITurn turn) {
        Pair<Player> pair = super.addTurn(gameStatus, turn);

        if (turn.isSeriousFoul()) {
            if (gameStatus.turn == PlayerTurn.PLAYER)
                pair.getPlayer().addEarlyWin();
            if (gameStatus.turn == PlayerTurn.OPPONENT)
                pair.getOpponent().addEarlyWin();
        }

        return pair;
    }

    @Override
    void addRunOutStats(Player player) {
        super.addRunOutStats(player);

        if (turn.getBallsRemaining() > 0)
            player.addEarlyWin();
    }
}
