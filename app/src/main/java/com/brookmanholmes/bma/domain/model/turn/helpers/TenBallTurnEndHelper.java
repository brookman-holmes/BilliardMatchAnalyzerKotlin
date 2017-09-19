package com.brookmanholmes.bma.domain.model.turn.helpers;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.turn.ITableStatus;

/**
 * Created by Brookman Holmes on 10/30/2015.
 */
class TenBallTurnEndHelper extends RotationTurnEndHelper {
    TenBallTurnEndHelper(GameStatus game, ITableStatus tableStatus) {
        super(game, tableStatus);
    }

    @Override
    boolean showWin() {
        return tableStatus.isGameBallMade();
    }

    @Override
    boolean checkFoul() {
        return tableStatus.getDeadBallsOnBreak() > 0;
    }
}
