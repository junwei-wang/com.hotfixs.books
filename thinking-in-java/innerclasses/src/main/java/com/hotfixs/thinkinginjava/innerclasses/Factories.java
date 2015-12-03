package com.hotfixs.thinkinginjava.innerclasses;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class ServiceImpl1 implements Service {
    private ServiceImpl1(){}

    @Override
    public void method1() {
        print("ServiceImpl1.method1");
    }

    @Override
    public void method2() {
        print("ServiceImpl1.method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImpl1();
        }
    };
}

class ServiceImpl2 implements Service {
    private ServiceImpl2(){}

    @Override
    public void method1() {
        print("ServiceImpl2.method1");
    }

    @Override
    public void method2() {
        print("ServiceImpl2.method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImpl2();
        }
    };
}

public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        Factories.serviceConsumer(ServiceImpl1.factory);
        Factories.serviceConsumer(ServiceImpl2.factory);
    }
}
