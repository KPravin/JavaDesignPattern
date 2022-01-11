package structural.decorator.example1;

public class DecoratorPattern {

    public static void main(String args[]) {
        IoTDevice fa = new SmartFireAlarm();
        IoTDevice ac = new SmartAirConditioner();

        fa.configure();;
        fa.connect();

        ac.configure();
        ac.connect();

        /////////////////////////////////////////////////////////////////////////////////

        IoTDevice ac1 = new SmartAirConditionerDecorator(new SmartAirConditioner());



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

abstract class IoTDeviceDecorator implements IoTDevice {
    protected IoTDevice decoratedIoTDevice;

    public IoTDeviceDecorator(IoTDevice decoratedIoTDevice) {
        this.decoratedIoTDevice = decoratedIoTDevice;
    }

    @Override
    public void configure() {  decoratedIoTDevice.configure();  }

    @Override
    public void connect() { decoratedIoTDevice.connect();   }
}

class SmartAirConditionerDecorator extends IoTDeviceDecorator {

    public SmartAirConditionerDecorator(IoTDevice decoratedIoTDevice) {
        super(decoratedIoTDevice);
    }

    @Override
    public void configure() {
        double temp = getTemperatureFromSensor();
        System.out.println("Set SmartAirConditioner temperature to " + temp);
        decoratedIoTDevice.configure();
    }

    @Override
    public void connect() {

        decoratedIoTDevice.connect();
    }

    public double getTemperatureFromSensor() { return 19.7 ; }
}