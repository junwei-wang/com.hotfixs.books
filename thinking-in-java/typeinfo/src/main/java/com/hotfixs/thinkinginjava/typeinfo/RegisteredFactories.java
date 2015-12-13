package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<>();

    static {
        partFactories.add(new FuelFilter.InnerFactory());
        partFactories.add(new AirFilter.InnerFactory());
        partFactories.add(new CabinAirFilter.InnerFactory());
        partFactories.add(new OilFilter.InnerFactory());
        partFactories.add(new FanBelt.InnerFactory());
        partFactories.add(new GeneratorBelt.InnerFactory());
        partFactories.add(new PowerSteeringBelt.InnerFactory());
    }

    private static Random random = new Random(47);

    public static Part createRandom() {
        int next = random.nextInt(partFactories.size());
        return partFactories.get(next).create();
    }
}

abstract class Filter extends Part {
}

class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:
    public static class InnerFactory implements Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class InnerFactory implements Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class InnerFactory implements Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class InnerFactory implements Factory<OilFilter> {
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class InnerFactory implements Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class InnerFactory implements Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class InnerFactory implements Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            print(Part.createRandom());
        }
    }
}
