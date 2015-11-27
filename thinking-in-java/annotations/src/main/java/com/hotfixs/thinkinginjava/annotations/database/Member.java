package com.hotfixs.thinkinginjava.annotations.database;

/**
 * @author wangjunwei
 */
@DBTable(name = "Member")
public class Member {
    @SqlString(30)
    String firstName;

    @SqlString(50)
    String lastName;

    @SqlInteger
    Integer age;

    @SqlString(value = 30, constrains = @Constrains(primaryKey = true))
    String handle;

    @SqlFloat
    Float height;

    public String getHandle() {
        return this.handle;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String toString() {
        return this.handle;
    }

    public Integer getAge() {
        return this.age;
    }

    public Float getHeight() {
        return this.height;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
