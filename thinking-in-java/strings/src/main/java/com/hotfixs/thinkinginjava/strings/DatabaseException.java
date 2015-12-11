package com.hotfixs.thinkinginjava.strings;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class DatabaseException extends Exception {
    public DatabaseException(int transactionId, int queryId, String message) {
        super(String.format("(t%d, q%d, %s)", transactionId, queryId, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(7, 3, "some error");
        } catch (DatabaseException e) {
            print(e);
        }
    }
}

