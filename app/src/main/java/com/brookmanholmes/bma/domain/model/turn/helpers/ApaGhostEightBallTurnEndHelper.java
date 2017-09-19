package com.brookmanholmes.bma.domain.model.turn.helpers;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.turn.ITableStatus;
import com.brookmanholmes.bma.domain.model.turn.TableUtils;

/**
 * Created by Brookman Holmes on 10/24/2016.
 */

class ApaGhostEightBallTurnEndHelper extends ApaEightBallTurnEndHelper {
    ApaGhostEightBallTurnEndHelper(GameStatus game, ITableStatus tableStatus) {
        super(game, tableStatus);
    }

    @Override
    boolean showWin() {
        return ((TableUtils.getSolidsRemaining(tableStatus.getBallStatuses()) == 0 ||
                TableUtils.getStripesRemaining(tableStatus.getBallStatuses()) == 0) &&
                tableStatus.isGameBallMade()) || tableStatus.isGameBallMadeOnBreak();
    }

    @Override
    boolean seriousFoul() {
        return tableStatus.isGameBallMadeIllegally();
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
    boolean showSafety() {
        return false;
    }

    @Override
    boolean showSafetyMiss() {
        return false;
    }

    @Override
    boolean showMiss() {
        return !showBreakMiss();
    }

    @Override
    boolean showBreakMiss() {
        return game.newGame && tableStatus.getBreakBallsMade() == 0;
    }
}
