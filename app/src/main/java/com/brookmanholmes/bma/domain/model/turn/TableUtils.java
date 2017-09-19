package com.brookmanholmes.bma.domain.model.turn;

import com.brookmanholmes.bma.domain.model.game.BallStatus;
import com.brookmanholmes.bma.domain.model.game.PlayerColor;

import java.util.Collections;
import java.util.List;

import static com.brookmanholmes.bma.domain.model.game.BallStatus.DEAD;
import static com.brookmanholmes.bma.domain.model.game.BallStatus.DEAD_ON_BREAK;
import static com.brookmanholmes.bma.domain.model.game.BallStatus.MADE;
import static com.brookmanholmes.bma.domain.model.game.BallStatus.MADE_ON_BREAK;
import static com.brookmanholmes.bma.domain.model.game.BallStatus.ON_TABLE;
import static com.brookmanholmes.bma.domain.model.game.PlayerColor.SOLIDS;
import static com.brookmanholmes.bma.domain.model.game.PlayerColor.STRIPES;

/**
 * Created by Brookman Holmes on 11/7/2015.
 * A utility class providing static methods for figuring out what stripes/solids were made
 * given a set of ball statuses
 */
public class TableUtils {

    /**
     * Calculates the number of stripes that were illegally pocketed, does not include balls made on
     * the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of stripes dead
     */
    public static int getDeadStripes(List<BallStatus> ballStatuses) {
        return getDeadBalls(ballStatuses, STRIPES);
    }

    /**
     * Calculates the number of solids that were illegally pocketed, does not include balls made on
     * the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of solids dead
     */
    public static int getDeadSolids(List<BallStatus> ballStatuses) {
        return getDeadBalls(ballStatuses, SOLIDS);
    }

    /**
     * Calculates the number of solids that were illegally pocketed on the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of solids dead on the break
     */
    public static int getDeadSolidsOnBreak(List<BallStatus> ballStatuses) {
        return getDeadBallsOnBreak(ballStatuses, SOLIDS);
    }

    /**
     * Calculates the number of stripes that were illegally pocketed on the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of stripes dead on the break
     */
    public static int getDeadStripesOnBreak(List<BallStatus> ballStatuses) {
        return getDeadBallsOnBreak(ballStatuses, STRIPES);
    }

    /**
     * Calculates the number of stripes that were legally pocketed on the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of stripes made on the break
     */
    public static int getStripesMadeOnBreak(List<BallStatus> ballStatuses) {
        return getColorMadeOnBreak(ballStatuses, STRIPES);
    }

    /**
     * Calculates the number of solids that were legally pocketed on the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of solids made on the break
     */
    public static int getSolidsMadeOnBreak(List<BallStatus> ballStatuses) {
        return getColorMadeOnBreak(ballStatuses, SOLIDS);
    }

    /**
     * Calculates the number of solids that were legally pocketed, does not include balls made on
     * the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of solids made
     */
    public static int getSolidsMade(List<BallStatus> ballStatuses) {
        return getColorMade(ballStatuses, SOLIDS);
    }

    /**
     * Calculates the number of stripes that were legally pocketed, does not include balls made on
     * the break
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of stripes made
     */
    public static int getStripesMade(List<BallStatus> ballStatuses) {
        return getColorMade(ballStatuses, STRIPES);
    }

    /**
     * Calculates the number of solids that remain on the table
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of solids on the table
     */
    public static int getSolidsRemaining(List<BallStatus> ballStatuses) {
        return getColorRemaining(ballStatuses, SOLIDS);
    }

    /**
     * Calculates the number of stripes that remain on the table
     *
     * @param ballStatuses A list of balls on the table, must be of size 15
     * @return the number of stripes on the table
     */
    public static int getStripesRemaining(List<BallStatus> ballStatuses) {
        return getColorRemaining(ballStatuses, STRIPES);
    }

    private static int getDeadBalls(List<BallStatus> ballStatuses, PlayerColor colorToCount) {
        return Collections.frequency(getBallStatusOfColor(ballStatuses, colorToCount), DEAD);
    }


    private static int getDeadBallsOnBreak(List<BallStatus> ballStatuses, PlayerColor colorToCount) {
        return Collections.frequency(getBallStatusOfColor(ballStatuses, colorToCount), DEAD_ON_BREAK);
    }

    private static int getColorMadeOnBreak(List<BallStatus> ballStatuses, PlayerColor colorToCount) {
        return Collections.frequency(getBallStatusOfColor(ballStatuses, colorToCount), MADE_ON_BREAK);
    }

    private static int getColorRemaining(List<BallStatus> ballStatuses, PlayerColor colorToCount) {
        return Collections.frequency(getBallStatusOfColor(ballStatuses, colorToCount), ON_TABLE);
    }

    private static int getColorMade(List<BallStatus> ballStatuses, PlayerColor colorToCount) {
        return Collections.frequency(getBallStatusOfColor(ballStatuses, colorToCount), MADE);
    }

    private static List<BallStatus> getBallStatusOfColor(List<BallStatus> ballStatuses, PlayerColor colorToChoose) {
        int from, to;
        if (colorToChoose == SOLIDS) {
            from = 0;
            to = 7;
        } else if (colorToChoose == STRIPES) {
            from = 8;
            to = 15;
        } else
            return Collections.emptyList();

        return ballStatuses.subList(from, to);
    }
}
