package org.example.entities;


import org.example.command.Invoker;
import org.example.parser.Writer;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class CollectionController {
    private final Writer<HumanBeing> writer;
    private final File file;
    private HashSet<HumanBeing> collection;

    public CollectionController(List<HumanBeing> collection, Writer writer, File file) {
        this.collection = new HashSet<HumanBeing>(collection);
        this.file = file;
        this.writer = writer;
    }

    public void addNewHuman() {
        HumanBeing newHumanBeing = personBuild();
        collection.add(newHumanBeing);
        sort();
    }

    private void sort() {
        collection = collection.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void show() {
        for (HumanBeing humanBeing : collection) {
            System.out.println(humanBeing);
        }
    }

    public void clear() {
        collection.clear();
    }

    public void info() {
        System.out.println("Тип: HashSet" + " Дата инициализации: " + " Количество элементов: " + collection.size());
    }

    public void updateId(String param) {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId() == Integer.parseInt(String.valueOf(param))) {

                HumanBeing newHumanBeing = personBuild();

                humanBeing.setName(newHumanBeing.getName());
                humanBeing.setCar(newHumanBeing.getCar());
                humanBeing.setCoordinates(newHumanBeing.getCoordinates());
                humanBeing.setCreationDate(newHumanBeing.getCreationDate());
                humanBeing.setRealHero(newHumanBeing.getRealHero());
                humanBeing.setHasToothpick(newHumanBeing.getHasToothpick());
                humanBeing.setImpactSpeed(newHumanBeing.getImpactSpeed());
                humanBeing.setSoundtrackName(newHumanBeing.getSoundtrackName());
                humanBeing.setWeaponType(newHumanBeing.getWeaponType());
                humanBeing.setMood(newHumanBeing.getMood());
            }
        }
        sort();
    }

    public void removeId(String param) {
        collection.removeIf(humanBeing -> humanBeing.getId() == Integer.parseInt(String.valueOf(param)));
    }

    public void addIfMin() {
        HumanBeing newHumanBeing = personBuild();
        if (collection.size() == 0) {
            sort();
        } else if (collection.size() == 1) {
            for (HumanBeing humanBeing : collection) {
                if (humanBeing.getImpactSpeed() > newHumanBeing.getImpactSpeed()) {
                    collection.add(newHumanBeing);
                    sort();
                }
            }
        } else {
            for (HumanBeing humanBeing : collection) {
                if (collection.iterator().hasNext()) {
                    if ((humanBeing.getImpactSpeed() < collection.iterator().next().getImpactSpeed()) && (humanBeing.getImpactSpeed()) > newHumanBeing.getImpactSpeed()) {
                        collection.add(newHumanBeing);
                        sort();
                    }
                }
            }
        }
    }

    public void removeGreater() {
        HumanBeing newHumanBeing = personBuild();
        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() > newHumanBeing.getImpactSpeed());
    }

    public void removeLower() {
        HumanBeing newHumanBeing = personBuild();
        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() < newHumanBeing.getImpactSpeed());
    }

    public void countGreater(String param) {
        int counter = 0;
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getImpactSpeed() > Integer.parseInt(String.valueOf(param))) {
                counter += 1;
            }
        }
        System.out.println(counter);
    }

    public void filterContains(String param) {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getSoundtrackName().contains(param)) {
                System.out.println(humanBeing);
            }
        }
    }

    public void filterGreater(String param) {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getImpactSpeed() > Integer.parseInt(String.valueOf(param))) {
                System.out.println(humanBeing);
            }
        }
    }

    public void save() {
        writer.writeCollectionToFile(writer.parsingPersonsToXml(new ArrayList<>(collection)), file);

    }

    public void executeScript(String param) {
        Invoker invoker = new Invoker(this);
        invoker.readCommandsScript(param);
    }

    public HumanBeing personBuild() {
        System.out.println("print name:");
        Scanner scanner = new Scanner(in);
        String newName = scanner.nextLine();

        System.out.println("print x:");
        Double newX = scanner.nextDouble();

        System.out.println("print y:");
        Integer newY = scanner.nextInt();

        System.out.println("print realHero:");
        Boolean newRealHero = scanner.nextBoolean();

        System.out.println("print hasToothpicks:");
        Boolean newHasToothpick = scanner.nextBoolean();

        System.out.println("print impactSpeed:");
        Double newImpactSpeed = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("print soundtrackName:");
        String newSoundtrackName = scanner.nextLine();

        System.out.println("print cool:");
        Boolean newCool = scanner.nextBoolean();

        System.out.println("print WeaponType:");
        Integer newWeaponType = scanner.nextInt();

        System.out.println("print Mood:");
        Integer newMood = scanner.nextInt();

        Random random = new Random(new Date().getTime());
        int newId = random.nextInt(10000000);
        Coordinates newCoordinates = new Coordinates(newX, newY);
        Car newCar = new Car(newCool);
        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
        Mood mood = Mood.fromInteger(newMood);
        ZonedDateTime newCreationDate = ZonedDateTime.now();

        return new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);
    }
}