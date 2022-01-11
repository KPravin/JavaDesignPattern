package structural.decorator.example2;

public class DecoratorPattern {

    public static void main(String args[]) {
        IoTDevice fa = new SmartFireAlarm();
        IoTDevice ac = new SmartAirConditioner();

        fa.configure();;
        fa.connect();

        ac.configure();
        ac.connect();

        /////////////////////////////////////////////////////////////////////////////////////
        SmartAirConditionerDecorator decorator = new SmartAirConditionerDecorator(ac);
        decorator.configure();
        decorator.connect();


        IoTDevice ac1 = new SmartAirConditionerDecorator(new SmartAirConditioner());


        /////////////////////////////////////////////////////////////////////////////////
    }
}


interface IoTDevice {
    public void configure();
    public void connect();
}

class SmartFireAlarm implements IoTDevice {
    @Override
    public void configure() {  System.out.println("SmartFireAlarm configured.");  }

    @Override
    public void connect() { System.out.println("SmartFireAlarm Connected.");   }
}

class SmartAirConditioner implements IoTDevice {
    @Override
    public void configure() {  System.out.println("SmartAirConditioner configured.");  }

    @Override
    public void connect() { System.out.println("SmartAirConditioner Connected.");   }
}

class SmartAirConditionerDecorator implements IoTDevice {

    private IoTDevice iotDevice;

    public SmartAirConditionerDecorator(IoTDevice iotDevice) {
        this.iotDevice = iotDevice;
    }

    @Override
    public void configure() {
        double temp = getTemperatureFromSensor();
        System.out.println("Set SmartAirConditioner temperature to " + temp);
        iotDevice.configure();
    }

    @Override
    public void connect() {

        iotDevice.connect();
    }

    public double getTemperatureFromSensor() { return 19.7 ; }
}