package com.brookmanholmes.bma.domain.model.turn.helpers;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.turn.ITableStatus;
import com.brookmanholmes.bma.domain.model.turn.TableUtils;

/**
 * Created by Brookman Holmes on 10/24/2016.
 */

class GhostEightBallTurnEndHelper extends GhostTurnEndHelper {
    GhostEightBallTurnEndHelper(GameStatus game, ITableStatus tableStatus) {
        super(game, tableStatus);
    }

    @Override
    boolean showWin() {
        return (TableUtils.getSolidsRemaining(tableStatus.getBallStatuses()) == 0 ||
                TableUtils.getStripesRemaining(tableStatus.getBallStatuses()) == 0)
                && tableStatus.isGameBallMade();
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
