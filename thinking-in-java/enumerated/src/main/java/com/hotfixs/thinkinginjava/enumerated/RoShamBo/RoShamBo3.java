package com.hotfixs.thinkinginjava.enumerated.roshambo;

import static com.hotfixs.thinkinginjava.enumerated.roshambo.Outcome.DRAW;
import static com.hotfixs.thinkinginjava.enumerated.roshambo.Outcome.LOSE;
import static com.hotfixs.thinkinginjava.enumerated.roshambo.Outcome.WIN;

/**
 * @author wangjunwei
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return DRAW;
                case SCISSORS:
                    return LOSE;
                case ROCK:
                    return WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return WIN;
                case SCISSORS:
                    return DRAW;
                case ROCK:
                    return LOSE;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
