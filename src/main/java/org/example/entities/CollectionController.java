package org.example.entities;


import org.example.command.Invoker;
import org.example.exception.ExecuteScriptException;
import org.example.exception.ValidException;
import org.example.parser.Writer;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class CollectionController {
    private final Writer<HumanBeing> writer;
    private final Validator<HumanBeing> humanValidator;
    private final RecursionChecker recursionChecker = new RecursionChecker();
    private final File file;
    private HashSet<HumanBeing> collection;
    private ZonedDateTime creationDate;

    public CollectionController(List<HumanBeing> collection, Writer<HumanBeing> writer, File file, Validator<HumanBeing> validator) {
        this.collection = new HashSet<>(collection);
        this.file = file;
        this.writer = writer;
        this.creationDate = ZonedDateTime.now();
        this.humanValidator = validator;
    }

    public void addNewHuman() {
        HumanBeing newHumanBeing = personBuild();
        collection.add(newHumanBeing);
        sort();
    }

    public void addNewHumanScript(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuildScript(param);
        humanValidator.checkElement(newHumanBeing);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");
        System.out.println("Тип: HashSet" + " Дата инициализации: " + creationDate.format(formatter) + " Количество элементов: " + collection.size());
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

    public void updateIdScript(String personData, String param) throws ValidException {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId() == Integer.parseInt(String.valueOf(param))) {

                HumanBeing newHumanBeing = personBuildScript(personData);
                humanValidator.checkElement(newHumanBeing);

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

    public void removeId(String param) throws ValidException {
        if (param.matches("^[0-9]+$")) {
            collection.removeIf(humanBeing -> humanBeing.getId() == Integer.parseInt(String.valueOf(param)));
        } else {
            throw new ValidException("Uncorrected id");
        }
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

    public void addIfMinScript(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuildScript(param);
        humanValidator.checkElement(newHumanBeing);
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

    public void removeGreaterScript(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuildScript(param);
        humanValidator.checkElement(newHumanBeing);
        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() > newHumanBeing.getImpactSpeed());
    }

    public void removeLower() {
        HumanBeing newHumanBeing = personBuild();
        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() < newHumanBeing.getImpactSpeed());
    }

    public void removeLowerScript(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuildScript(param);
        humanValidator.checkElement(newHumanBeing);
        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() < newHumanBeing.getImpactSpeed());
    }

    public void countGreater(String param) throws ValidException {
        if (param.matches("^[-+]?[0-9]*\\\\.?[0-9]+$") && Double.parseDouble(param) > -992) {
            int counter = 0;
            for (HumanBeing humanBeing : collection) {
                if (humanBeing.getImpactSpeed() > Integer.parseInt(String.valueOf(param))) {
                    counter += 1;
                }
            }
            System.out.println(counter);
        } else {
            throw new ValidException("Uncorrected ImpactSpeed");
        }
    }

    public void filterContains(String param) throws ValidException {
        if (param != null) {
            for (HumanBeing humanBeing : collection) {
                if (humanBeing.getSoundtrackName().contains(param)) {
                    System.out.println(humanBeing);
                }
            }
        } else {
            throw new ValidException("Uncorrected SoundTrackName");
        }
    }

    public void filterGreater(String param) throws ValidException {
        if (param.matches("^[-+]?[0-9]*\\.?[0-9]+$") && Double.parseDouble(param) > -992) {
            for (HumanBeing humanBeing : collection) {
                if (humanBeing.getImpactSpeed() > Integer.parseInt(String.valueOf(param))) {
                    System.out.println(humanBeing);
                }
            }
        } else {
            throw new ValidException("Uncorrected ImpactSpeed");
        }
    }

    public void save() {
        writer.writeCollectionToFile(writer.parsingPersonsToXml(new ArrayList<>(collection)), file);

    }

    public void executeScript(String param) throws ValidException, ExecuteScriptException {
        recursionChecker.addFile(param);
        Invoker invoker = new Invoker(this);
        invoker.readCommandsScript(param);
    }

    public HumanBeing personBuildScript(String param) throws ValidException {
        String[] data = param.split(" ");
        if ((data[0] != null) && (data[1].matches("^[-+]?[0-9]*\\.?[0-9]+$")) &&
                (data[2].matches("^[-+]?[0-9]+$") && Double.parseDouble(param) < 945) &&
                (data[5].matches("^[-+]?[0-9]*\\.?[0-9]+$") && Double.parseDouble(param) > -992) &&
                (data[6] != null) && (data[7].matches("^[1-3]$")) && (data[8].matches("^[1-4]$"))) {
            String newName = data[0];
            Double newX = Double.valueOf(data[1]);
            Integer newY = Integer.valueOf(data[2]);
            Boolean newRealHero = Boolean.valueOf(data[3]);
            Boolean newHasToothpick = Boolean.valueOf(data[4]);
            Double newImpactSpeed = Double.valueOf(data[5]);
            String newSoundtrackName = data[6];
            Integer newWeaponType = Integer.valueOf(data[7]);
            Integer newMood = Integer.valueOf(data[8]);
            Boolean newCool = Boolean.valueOf(data[9]);
            Random random = new Random(new Date().getTime());
            int newId = random.nextInt(10000000);
            Coordinates newCoordinates = new Coordinates(newX, newY);
            Car newCar = new Car(newCool);
            WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
            Mood mood = Mood.fromInteger(newMood);
            ZonedDateTime newCreationDate = ZonedDateTime.now();
            return new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);
        } else {
            throw new ValidException("Uncorrected person data");
        }
    }

    public HumanBeing personBuild() {
        Scanner scanner = new Scanner(in);
        String newName = null;
        while (newName == null || newName == "") {
            System.out.println("print name (String):");
            try {
                newName = scanner.nextLine();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите имя ещё раз:)");
                scanner.nextLine();
            }
        }
        Double newX = null;
        while (newX == null) {
            System.out.println("print x (Double):");
            try {
                newX = scanner.nextDouble();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите x ещё раз:)");
                scanner.nextLine();
            }
        }
        Integer newY = null;
        while (newY == null || newY > 945) {
            System.out.println("print y (Integer):");
            try {
                newY = scanner.nextInt();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите x ещё раз:)");
                scanner.nextLine();
            }
        }
        Boolean newRealHero = null;
        while (newRealHero == null) {
            System.out.println("print realHero (Boolean):");
            try {
                newRealHero = scanner.nextBoolean();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите realHero ещё раз:)");
                scanner.nextLine();
            }
        }

        Boolean newHasToothpick = null;
        while (newHasToothpick == null) {
            System.out.println("print hasToothpick (Boolean):");
            try {
                newHasToothpick = scanner.nextBoolean();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите hasToothpick ещё раз:)");
                scanner.nextLine();
            }
        }

        Double newImpactSpeed = null;
        while (newImpactSpeed == null || newImpactSpeed <= -992) {
            System.out.println("print impactSpeed (Double):");
            try {
                newImpactSpeed = scanner.nextDouble();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите impactSpeed ещё раз:)");
                scanner.nextLine();
            }
        }

        scanner.nextLine();
        String newSoundtrackName = null;
        while (newSoundtrackName == null) {
            System.out.println("print soundTrackName (String):");
            try {
                newSoundtrackName = scanner.nextLine();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите имя саундтрека ещё раз:)");
                scanner.nextLine();
            }
        }
        Boolean newCool = null;
        while (newCool == null) {
            System.out.println("print cool (Boolean):");
            try {
                newCool = scanner.nextBoolean();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите cool ещё раз:)");
                scanner.nextLine();
            }
        }
        Integer newWeaponType = null;
        while (newWeaponType == null || newWeaponType < 1 || newWeaponType > 3) {
            System.out.println("print WeaponType (Boolean):");
            try {
                newWeaponType = scanner.nextInt();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите WeaponType ещё раз:)");
                scanner.nextLine();
            }
        }
        Integer newMood = null;
        while (newMood == null || newMood < 1 || newMood > 4) {
            System.out.println("print Mood (Boolean):");
            try {
                newMood = scanner.nextInt();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Ошибка! Введите Mood ещё раз:)");
                scanner.nextLine();
            }
        }
        Random random = new Random(new Date().getTime());
        int newId = random.nextInt(10000000);
        Coordinates newCoordinates = new Coordinates(newX, newY);
        Car newCar = new Car(newCool);
        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
        Mood mood = Mood.fromInteger(newMood);
        ZonedDateTime newCreationDate = ZonedDateTime.now();

        return new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);
    }

    private static class RecursionChecker {
        private final HashSet<String> history;
        private int size;

        private RecursionChecker() {
            history = new HashSet<>();
        }

        private void addFile(String file) throws ExecuteScriptException {
            history.add(file);
            size += 1;
            checkRecursion();
        }

        private void checkRecursion() throws ExecuteScriptException {
            if (history.size() != size) {
                throw new ExecuteScriptException("RECURSION:(");
            }
        }

        private HashSet<String> getHistory() {
            return history;
        }

        private void setSize() {
            this.size = 0;
        }
    }
}
