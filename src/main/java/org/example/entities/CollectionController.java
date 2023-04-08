package org.example.entities;


import org.example.command.Invoker;
import org.example.xmlParser.Writer;

import java.io.File;
import java.io.IOException;
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
        //    this.collection = collection;
    }

    public HashSet<HumanBeing> getCollection() {
        return collection;
    }

    //    public void addAll(HumanBeings humanBeings) {
//
//        //    collection.addAll(List.of(humanBeings.getHumanBeing()));
//    }
    public void add(HumanBeing humanBeing) {
        collection.add(humanBeing);
        sort();
    }

    private void sort() {
        collection = collection.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
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
        System.out.println("Тип: HashSet" + " Количество элементов: " + collection.size());
    }

    public void updateId(String param) {
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId() == Integer.parseInt(String.valueOf(param))) {
                System.out.println("print name:");
                Scanner scanner = new Scanner(in);
                String newName = scanner.nextLine();

                System.out.println("print x:");
                Double newX = scanner.nextDouble();

                System.out.println("print y:");
                Integer newY = scanner.nextInt();

                System.out.println("print creationDate:");
                String newCreationDate0 = scanner.nextLine();
                Date newCreationDate = new Date(newCreationDate0);

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

                Coordinates newCoordinates = new Coordinates(newX, newY);
                Car newCar = new Car(newCool);
                WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
                Mood mood = Mood.fromInteger(newMood);
                int newId = humanBeing.getId();

                HumanBeing newHumanBeing = new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);

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
//        for (HumanBeing humanBeing : collection) {
//            if (humanBeing.getId() == Integer.parseInt(String.valueOf(param))) {
//                humanBeingItr.remove()
//            }
//        }
//        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
//            Integer integer = iterator.next();
//            if(integer == 2) {
//                iterator.remove();
//            }
//        }
        collection.removeIf(humanBeing -> humanBeing.getId() == Integer.parseInt(String.valueOf(param)));
    }

    public void addIfMin() {
        System.out.println("print name:");
        Scanner scanner = new Scanner(in);
        String newName = scanner.nextLine();

        System.out.println("print x:");
        Double newX = scanner.nextDouble();

        System.out.println("print y:");
        Integer newY = scanner.nextInt();

        System.out.println("print creationDate:");
        String newCreationDate0 = scanner.nextLine();
        Date newCreationDate = new Date(newCreationDate0);

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
        int newId = random.nextInt();
        Coordinates newCoordinates = new Coordinates(newX, newY);
        Car newCar = new Car(newCool);
        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
        Mood mood = Mood.fromInteger(newMood);

        HumanBeing newHumanBeing = new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);


        if (collection.size() == 0) {
            sort();
        } else if (collection.size() == 1) {
            for (HumanBeing humanBeing : collection) {
                if (humanBeing.getImpactSpeed() > newHumanBeing.getImpactSpeed()) {
                    collection.add(newHumanBeing);
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
        System.out.println("print name:");
        Scanner scanner = new Scanner(in);
        String newName = scanner.nextLine();

        System.out.println("print x:");
        Double newX = scanner.nextDouble();

        System.out.println("print y:");
        Integer newY = scanner.nextInt();

        System.out.println("print creationDate:");
        String newCreationDate0 = scanner.nextLine();
        Date newCreationDate = new Date(newCreationDate0);

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
        int newId = random.nextInt();
        Coordinates newCoordinates = new Coordinates(newX, newY);
        Car newCar = new Car(newCool);
        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
        Mood mood = Mood.fromInteger(newMood);

        HumanBeing newHumanBeing = new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);

        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() > newImpactSpeed);
    }

    public void removeLower() {
        System.out.println("print name:");
        Scanner scanner = new Scanner(in);
        String newName = scanner.nextLine();

        System.out.println("print x:");
        Double newX = scanner.nextDouble();

        System.out.println("print y:");
        Integer newY = scanner.nextInt();
        System.out.println("print creationDate:");
        String newCreationDate0 = scanner.nextLine();
        Date newCreationDate = new Date(newCreationDate0);

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
        int newId = random.nextInt();
        Coordinates newCoordinates = new Coordinates(newX, newY);
        Car newCar = new Car(newCool);
        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
        Mood mood = Mood.fromInteger(newMood);

        HumanBeing newHumanBeing = new HumanBeing(newId, newName, newCoordinates, newCreationDate, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);

        collection.removeIf(humanBeing -> humanBeing.getImpactSpeed() < newImpactSpeed);
    }

    public void countGreater(String param) {
        int counter = 0;
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getImpactSpeed() > Integer.parseInt(String.valueOf(param))) {
                counter += 1;
            }
            ;
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


    public void executeScript(String param) throws IOException {
        Invoker invoker = new Invoker(this);
        invoker.readCommandsScript(param);

    }
}