package com.hotfixs.thinkinginjava.annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjunwei
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("Argument: annotated classes");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = field.getName().toUpperCase();
                Annotation[] annotations = field.getDeclaredAnnotations();

                if (annotations.length < 1) {
                    continue;
                }

                if (annotations[0] instanceof SqlInteger) {
                    SqlInteger sqlInteger = (SqlInteger) annotations[0];
                    if (sqlInteger.name().length() > 0) {
                        columnName = sqlInteger.name();
                    }

                    columnDefs.add(columnName + " INT" + getConstrains(sqlInteger.constrains()));
                }
                if (annotations[0] instanceof SqlFloat) {
                    SqlFloat sqlFloat = (SqlFloat) annotations[0];
                    if (sqlFloat.name().length() > 0) {
                        columnName = sqlFloat.name();
                    }

                    columnDefs.add(columnName + " FLOAT" + getConstrains(sqlFloat.constrains()));
                }

                if (annotations[0] instanceof SqlString) {
                    SqlString sqlString = (SqlString) annotations[0];
                    if (sqlString.name().length() > 0) {
                        columnName = sqlString.name();
                    }

                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")"
                            + getConstrains(sqlString.constrains()));
                }
            }

            StringBuilder sb = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                sb.append("\n    " + columnDef + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(");");
            String createTableCommand = sb.toString();
            System.out.println("Table Creation SQL for " + className + " is: " + createTableCommand);
            execute(createTableCommand);
        }
    }

    private static String getConstrains(Constrains constrains) {
        String cons = "";
        if (!constrains.allowNull()) {
            cons += " NOT NULL";
        }
        if (constrains.primaryKey()) {
            cons += " PRIMARY KEY";
        }
        if (constrains.unique()) {
            cons += " UNIQUE";
        }

        return cons;
    }

    private static void execute(String sql) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            stmt.execute(sql);

            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }
    }
}
