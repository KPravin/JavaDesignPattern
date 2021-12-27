/**
 * Immutable objects are the objects whose state can not be changed once created.
 *
 * @author Pravin Kumar
 */

public class Immutable {
    public static void main(String[] args) {

        DeviceConfiguration deviceConfiguration = new DeviceConfiguration("BLR", "5 volts");
        Device device = new Device("Lidar", "1232", deviceConfiguration);

    }
}

/**
 * Device class is Immutable class.
 * Class declared as final, so that child class can't be created.
 */
final class Device {
    private final String deviceName;
    private final String deviceId;
    private final DeviceConfiguration deviceConfiguration;

    public Device(String deviceName, String deviceId, DeviceConfiguration deviceConfiguration) {
        this.deviceName = deviceName;
        this.deviceId = deviceId;

        //deep copy
        DeviceConfiguration deepCopyDeviceConfiguration = new DeviceConfiguration(deviceConfiguration.getLocation(), deviceConfiguration.getVoltage());
        this.deviceConfiguration = deepCopyDeviceConfiguration;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public DeviceConfiguration getDeviceConfiguration() {
        return deviceConfiguration;
    }
}

class DeviceConfiguration {
    private String location;
    private String voltage;

    public DeviceConfiguration(String location, String voltage) {
        this.location = location;
        this.voltage = voltage;
    }

    public String getLocation() {
        return location;
    }

    public String getVoltage() {
        return voltage;
    }
}


