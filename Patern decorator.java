import java.util.ArrayList;
import java.util.List;

// Interface Command
interface Command {
    void execute();
    void undo();
}

// Classe Light représentant une lampe dans le système
class Light {
    private boolean isOn;
    private int brightness;

    public Light() {
        isOn = false;
        brightness = 0;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("La lumière est allumée");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("La lumière est éteinte");
    }

    public void adjustBrightness(int brightness) {
        this.brightness = brightness;
        System.out.println("L'intensité lumineuse est réglée à : " + brightness);
    }
}

// Classe LightControlPanel agissant comme un panneau de contrôle pour les lampes
class LightControlPanel {
    private List<Light> lights;

    public LightControlPanel() {
        lights = new ArrayList<>();
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public void removeLight(Light light) {
        lights.remove(light);
    }

    public void turnOnLights() {
        for (Light light : lights) {
            light.turnOn();
        }
    }

    public void turnOffLights() {
        for (Light light : lights) {
            light.turnOff();
        }
    }

    public void adjustBrightness(int brightness) {
        for (Light light : lights) {
            light.adjustBrightness(brightness);
        }
    }
}

// Classe TurnOnLightCommand pour allumer la lumière
class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// Classe TurnOffLightCommand pour éteindre la lumière
class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Classe AdjustBrightnessCommand pour régler l'intensité lumineuse
class AdjustBrightnessCommand implements Command {
    private Light light;
    private int previousBrightness;
    private int newBrightness;

    public AdjustBrightnessCommand(Light light, int newBrightness) {
        this.light = light;
        this.newBrightness = newBrightness;
    }

    @Override
    public void execute() {
        previousBrightness = light.getBrightness();
        light.adjustBrightness(newBrightness);
    }

    @Override
    public void undo() {
        light.adjustBrightness(previousBrightness);
    }
}

// Classe de test
public class Main {
    public static void main(String[] args) {
        // Création du panneau de contrôle d'éclairage
        LightControlPanel controlPanel = new LightControlPanel();

        // Création des lampes
        Light livingRoomLight = new Light();
        Light kitchenLight = new Light();

        // Ajout des lampes au panneau de contrôle
        controlPanel.addLight(livingRoomLight);
        controlPanel.addLight(kitchenLight);

        // Commandes pour allumer, éteindre et ajuster l'intensité lumineuse
        Command turnOnLivingRoomLight = new TurnOnLightCommand(livingRoomLight);
        Command turnOffLivingRoomLight = new TurnOffLightCommand(livingRoomLight);
        Command adjustLivingRoomLightBrightness = new AdjustBrightnessCommand(livingRoomLight, 50);

        // Exécution des commandes
        turnOnLivingRoomLight.execute();
        adjustLivingRoomLightBrightness.execute();
        turnOffLivingRoomLight.execute();
    }
}
