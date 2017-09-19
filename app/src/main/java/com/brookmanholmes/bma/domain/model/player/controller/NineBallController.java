package com.brookmanholmes.bma.domain.model.player.controller;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.game.PlayerTurn;
import com.brookmanholmes.bma.domain.model.player.Pair;
import com.brookmanholmes.bma.domain.model.player.Player;
import com.brookmanholmes.bma.domain.model.turn.ITurn;

/**
 * Created by Brookman Holmes on 10/28/2015.
 * A controller for adding up player stats for BCA 9 ball
 */
class NineBallController extends PlayerController {
    public NineBallController(String playerId, String opponentId, String playerName, String opponentName, int playerRank, int opponentRank) {
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
    void addBreakingStats(Player player) {
        super.addBreakingStats(player);

        if (turn.isGameBallMadeOnBreak())
            player.addWinOnBreak();
    }

    @Override
    void addRunOutStats(Player player) {
        super.addRunOutStats(player);

        if (turn.getBallsRemaining() > 0)
            player.addEarlyWin();
    }
}
