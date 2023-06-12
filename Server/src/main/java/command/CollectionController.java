package command;


import entities.*;
import exception.ExecuteScriptException;
import exception.FileException;
import exception.ValidException;
import parser.Writer;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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

    //считываем человека, проверяем на валидность и добавляем в коллекцию
    public void addNewHuman(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuild(param);
        humanValidator.checkElement(newHumanBeing);
        collection.add(newHumanBeing);
        sort();
    }

    //сортировка коллекции по скорости
    private void sort() {
        collection = collection.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    //вывод всех элементов коллекции
    public void show() {
        for (HumanBeing humanBeing : collection) {
            System.out.println(humanBeing);
        }
    }

    //очистка коллекции
    public void clear() {
        collection.clear();
    }

    //вывод информации о коллекции
    public void info() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");
        System.out.println("Тип: HashSet" + " Дата инициализации: " + creationDate.format(formatter) + " Количество элементов: " + collection.size());
    }

    //замена элемента с id равным введённому
    public void updateId(String param) throws ValidException {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId() == Integer.parseInt(String.valueOf(param))) {
                HumanBeing newHumanBeing = personBuild(param);
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

    //замена элемента с id равным введённому для execute_script
    public void updateIdScript(String personData, String param) throws ValidException {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId() == Integer.parseInt(String.valueOf(param))) {

                HumanBeing newHumanBeing = personBuild(personData);
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

    //удаление элемента с id равным введённому
    public void removeId(String param) throws ValidException {
        if (param.matches("^[0-9]+$")) {
            collection.removeIf(humanBeing -> humanBeing.getId() == Integer.parseInt(param));
        } else {
            throw new ValidException("Uncorrected id");
        }
    }


    //создаём человека и если он является наименьшим, то добавляем в коллекцию для execute_script
    public void addIfMin(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuild(param);
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


    public void removeGreater(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuild(param);
        humanValidator.checkElement(newHumanBeing);
        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() > newHumanBeing.getImpactSpeed());
    }

    public void removeLower(String param) throws ValidException {
        HumanBeing newHumanBeing = personBuild(param);
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
                if (humanBeing.getImpactSpeed() > Double.parseDouble(param)) {
                    System.out.println(humanBeing);
                }
            }
        } else {
            throw new ValidException("Uncorrected ImpactSpeed");
        }
    }

    public void save() throws IOException, FileException {
        writer.writeCollectionToFile(writer.parsingPersonsToXml(new ArrayList<>(collection)), file);

    }

    public void executeScript(String param) throws ValidException, ExecuteScriptException {
        recursionChecker.addFile(param);
        Invoker invoker = new Invoker(this);
        invoker.readCommandsScript(param);
    }

    public HumanBeing personBuild(String param) throws ValidException {
        String[] data = param.split(" ");
        if ((data[0] != null) && (data[1].matches("^[-+]?[0-9]*\\.?[0-9]+$")) &&
                (data[2].matches("^[-+]?[0-9]+$") && Double.parseDouble(data[2]) < 945) &&
                (data[5].matches("^[-+]?[0-9]*\\.?[0-9]+$") && Double.parseDouble(data[5]) > -992) &&
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
