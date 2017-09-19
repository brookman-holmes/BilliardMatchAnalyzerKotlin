package com.brookmanholmes.bma.domain.model.turn.helpers;

import com.brookmanholmes.bma.domain.model.game.GameStatus;
import com.brookmanholmes.bma.domain.model.turn.ITableStatus;

/**
 * Created by Brookman Holmes on 10/30/2015.
 */
class ApaEightBallTurnEndHelper extends EightBallTurnEndHelper {
    ApaEightBallTurnEndHelper(GameStatus game, ITableStatus tableStatus) {
        super(game, tableStatus);
    }

    @Override
    boolean showWin() {
        return super.showWin() || tableStatus.isGameBallMadeOnBreak();
    }

    @Override
    boolean seriousFoul() {
        return super.seriousFoul() || tableStatus.isGameBallMadeIllegally();
    }

    @Override
    boolean showSafety() {
        return super.showSafety() && tableStatus.getDeadBalls() == 0;
    }
}
