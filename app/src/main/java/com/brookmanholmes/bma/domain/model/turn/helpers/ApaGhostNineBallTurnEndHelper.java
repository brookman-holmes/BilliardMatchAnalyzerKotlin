package com.brookmanholmes.bma.domain.model.turn.helpers;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.turn.ITableStatus;

/**
 * Created by Brookman Holmes on 4/27/2016.
 */
class ApaGhostNineBallTurnEndHelper extends TurnEndHelper {
    ApaGhostNineBallTurnEndHelper(GameStatus game, ITableStatus tableStatus) {
        super(game, tableStatus);
    }

    @Override
    boolean showWin() {
        return tableStatus.isGameBallMade() || tableStatus.isGameBallMadeOnBreak();
    }

    @Override
    boolean seriousFoul() {
        return false;
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
    boolean showBreakMiss() {
        return false;
    }
}
