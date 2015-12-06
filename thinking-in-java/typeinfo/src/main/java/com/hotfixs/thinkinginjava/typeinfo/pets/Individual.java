package com.hotfixs.thinkinginjava.typeinfo.pets;

/**
 * @author wang
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private static final long id = counter++;
    private static String name;

    public Individual() {
    }

    public Individual(String name) {
        this.name = name;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Individual && ((Individual) o).id == id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int) id;
        return result;
    }

    @Override
    public int compareTo(Individual o) {
        String className = getClass().getSimpleName();
        String oClassName = o.getClass().getSimpleName();
        int classNameCompare = className.compareTo(oClassName);
        if (classNameCompare != 0) {
            return classNameCompare;
        }

        if (name != null && o.name != null) {
            int nameCompare = name.compareTo(o.name);
            if (nameCompare != 0) {
                return nameCompare;
            }
        }

        return o.id < id ? -1 : (o.id == id ? 0 : 1);
    }
}
