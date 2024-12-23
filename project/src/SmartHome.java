interface Command {
    void execute();
    void undo();
}

class LightingSystem {
    private boolean isOn;

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Світло ввімкнено.");
        } else {
            System.out.println("Світло вже горить.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Світло вимкнено.");
        } else {
            System.out.println("Світло вже вимкнено.");
        }
    }
}

class TemperatureSystem {
    int temperature;

    public void setTemperature(int temp) {
        if (temp < 14 || temp > 30) {
            System.out.println("Температура поза діапазоном. Встановіть від 14 до 30 градусів.");
        } else {
            temperature = temp;
            System.out.println("Температуру встановлено на " + temperature + " градусів.");
        }
    }
}

class SecuritySystem {
    private boolean isArmed;

    public void arm() {
        if (!isArmed) {
            isArmed = true;
            System.out.println("Охоронна система активована.");
        } else {
            System.out.println("Охоронна система вже активована.");
        }
    }

    public void disarm() {
        if (isArmed) {
            isArmed = false;
            System.out.println("Охоронна система деактивована.");
        } else {
            System.out.println("Охоронна система вже деактивована.");
        }
    }
}

class TurnOnLightCommand implements Command {
    private final LightingSystem lightingSystem;

    public TurnOnLightCommand(LightingSystem lightingSystem) {
        this.lightingSystem = lightingSystem;
    }

    @Override
    public void execute() {
        lightingSystem.turnOn();
    }

    @Override
    public void undo() {
        lightingSystem.turnOff();
    }
}

class TurnOffLightsCommand implements Command {
    private final LightingSystem lightingSystem;

    public TurnOffLightsCommand(LightingSystem lightingSystem) {
        this.lightingSystem = lightingSystem;
    }

    @Override
    public void execute() {
        lightingSystem.turnOff();
    }

    @Override
    public void undo() {
        lightingSystem.turnOn();
    }
}

class SetTemperatureCommand implements Command {
    private final TemperatureSystem temperatureSystem;
    private final int temperature;
    private int previousTemperature;

    public SetTemperatureCommand(TemperatureSystem temperatureSystem, int temperature) {
        this.temperatureSystem = temperatureSystem;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        previousTemperature = temperatureSystem.temperature;
        temperatureSystem.setTemperature(temperature);
    }

    @Override
    public void undo() {
        temperatureSystem.setTemperature(previousTemperature);
    }
}

class ArmSecurityCommand implements Command {
    private final SecuritySystem securitySystem;

    public ArmSecurityCommand(SecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    @Override
    public void execute() {
        securitySystem.arm();
    }

    @Override
    public void undo() {
        securitySystem.disarm();
    }
}

class DisarmSecurityCommand implements Command {
    private final SecuritySystem securitySystem;

    public DisarmSecurityCommand(SecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    @Override
    public void execute() {
        securitySystem.disarm();
    }

    @Override
    public void undo() {
        securitySystem.arm();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

class SmartHomeFacade {
    private final LightingSystem lightingSystem;
    private final TemperatureSystem temperatureSystem;
    private final SecuritySystem securitySystem;

    public SmartHomeFacade(LightingSystem lightingSystem, TemperatureSystem temperatureSystem, SecuritySystem securitySystem) {
        this.lightingSystem = lightingSystem;
        this.temperatureSystem = temperatureSystem;
        this.securitySystem = securitySystem;
    }

    public void activateAllSystems() {
        lightingSystem.turnOn();
        temperatureSystem.setTemperature(22);
        securitySystem.arm();
        System.out.println("Всі системи активовані.\n");
    }

    public void deactivateAllSystems() {
        lightingSystem.turnOff();
        securitySystem.disarm();
        System.out.println("Всі системи деактивовані.\n");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        LightingSystem lightingSystem = new LightingSystem();
        TemperatureSystem temperatureSystem = new TemperatureSystem();
        SecuritySystem securitySystem = new SecuritySystem();

        SmartHomeFacade smartHome = new SmartHomeFacade(lightingSystem, temperatureSystem, securitySystem);

        Command turnOnLights = new TurnOnLightCommand(lightingSystem);
        Command turnOffLights = new TurnOffLightsCommand(lightingSystem);
        Command setTemperature = new SetTemperatureCommand(temperatureSystem, 24);
        Command setTemperature2 = new SetTemperatureCommand(temperatureSystem, 26);
        Command armSecurity = new ArmSecurityCommand(securitySystem);
        Command disarmSecurity = new DisarmSecurityCommand(securitySystem);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnLights);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(setTemperature);
        remote.pressButton();
        remote.setCommand(setTemperature2);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(armSecurity);
        remote.pressButton();
        remote.pressUndo();

        System.out.println("\nВикористання Фасаду:");
//        smartHome.activateAllSystems();
        smartHome.deactivateAllSystems();
    }
}