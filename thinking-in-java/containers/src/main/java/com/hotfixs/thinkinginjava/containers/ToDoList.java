package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.PriorityQueue;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String td, char pri, int sec) {
            this.item = td;
            this.primary = pri;
            this.secondary = sec;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return 1;
            } else if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return 1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }

            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public void add(String td, Character pri, int sec) {
        super.add(new ToDoItem(td, pri, sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);

        while (!toDoList.isEmpty()) {
            print(toDoList.remove());
        }
    }
}
