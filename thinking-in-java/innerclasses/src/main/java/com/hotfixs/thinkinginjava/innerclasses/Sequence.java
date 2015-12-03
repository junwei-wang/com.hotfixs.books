package com.hotfixs.thinkinginjava.innerclasses;
import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public int size() {
        return items.length;
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new Selector() {
            private int i = items.length - 1;

            @Override
            public boolean end() {
                return i == -1;
            }

            @Override
            public Object current() {
                return items[i];
            }

            @Override
            public void next() {
                if (i >= 0) {
                    i--;
                }
            }
        };
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < sequence.size(); i++) {
            sequence.add(i);
        }

        Selector selector = sequence.selector();
        while (!selector.end()) {
            print(selector.current());
            selector.next();
        }

        Selector reverseSelector = sequence.reverseSelector();
        while (!reverseSelector.end()) {
            print(reverseSelector.current());
            reverseSelector.next();
        }
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}
