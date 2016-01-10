package com.hotfixs.thinkinginjava.enumerated.roshambo;

/**
 * @author wangjunwei
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
