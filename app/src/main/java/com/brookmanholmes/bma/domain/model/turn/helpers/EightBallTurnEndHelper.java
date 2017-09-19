package com.brookmanholmes.bma.domain.model.turn.helpers;

import com.brookmanholmes.bma.domain.model.game.BallStatus;
import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.game.PlayerColor;
import com.brookmanholmes.bma.domain.model.turn.ITableStatus;
import com.brookmanholmes.bma.domain.model.turn.TableUtils;

/**
 * Created by Brookman Holmes on 10/30/2015.
 */
class EightBallTurnEndHelper extends TurnEndHelper {
    EightBallTurnEndHelper(GameStatus game, ITableStatus tableStatus) {
        super(game, tableStatus);
    }

    @Override
    boolean showWin() {
        return !currentPlayerBallsRemaining() && tableStatus.isGameBallMade();
    }

    @Override
    boolean seriousFoul() {
        return tableStatus.getBallStatus(8) != BallStatus.GAME_BALL_DEAD_ON_BREAK &&
                tableStatus.isGameBallMadeIllegally() ||
                (currentPlayerBallsRemaining() && tableStatus.isGameBallMade());
    }

    @Override
    boolean checkFoul() {
        return super.checkFoul() || seriousFoul();
    }

    @Override
    boolean showSafety() {
        return super.showSafety() && !seriousFoul();
    }

    @Override
    boolean showPush() {
        return false;
    }

    @Override
    boolean showTurnSkip() {
        return false;
    }

    @Override
    boolean reallyLostGame() {
        return tableStatus.getBallStatus(8) != BallStatus.GAME_BALL_DEAD_ON_BREAK && seriousFoul();
    }

    /**
     * Returns whether the current player has any balls remaining on the table
     *
     * @return True if the player has balls remaining, false otherwise
     */
    private boolean currentPlayerBallsRemaining() {
        if (game.currentPlayerColor == PlayerColor.SOLIDS) {
            return TableUtils.getSolidsRemaining(tableStatus.getBallStatuses()) > 0;
        } else if (game.currentPlayerColor == PlayerColor.STRIPES) {
            return TableUtils.getStripesRemaining(tableStatus.getBallStatuses()) > 0;
        } else {
            return TableUtils.getSolidsRemaining(tableStatus.getBallStatuses()) > 0 && TableUtils.getStripesRemaining(tableStatus.getBallStatuses()) > 0;
        }
    }
}