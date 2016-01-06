package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getInstance().format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("PATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            print(csm.getInfo());
        }
    }

}
