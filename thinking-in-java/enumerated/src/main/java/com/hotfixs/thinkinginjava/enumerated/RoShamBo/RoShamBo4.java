package com.hotfixs.thinkinginjava.enumerated.roshambo;

import static com.hotfixs.thinkinginjava.enumerated.roshambo.Outcome.DRAW;
import static com.hotfixs.thinkinginjava.enumerated.roshambo.Outcome.LOSE;
import static com.hotfixs.thinkinginjava.enumerated.roshambo.Outcome.WIN;

/**
 * @author wangjunwei
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };

    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return (opponent == this) ? DRAW : ((opponent == loser) ? WIN : LOSE);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
