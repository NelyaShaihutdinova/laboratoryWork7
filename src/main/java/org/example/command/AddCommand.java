package org.example.command;

import org.example.entities.*;

import java.util.*;

public class AddCommand implements Command {
    public AddCommand(CollectionManager cm) {
        this.cm = cm;
    }

    private CollectionManager cm;

    @Override
    public void execute(){
        System.out.println("print name:");
        Scanner scanner = new Scanner(System.in);
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
        int newId = random.nextInt();

        Coordinates newCoordinates = new Coordinates(newX, newY);
        Car newCar = new Car(newCool);
        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
        Mood mood  = Mood.fromInteger(newMood);
        HumanBeing humanBeing = new HumanBeing(newId, newName, newCoordinates, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);

        cm.add(humanBeing);
    }
    public String descr(){
        return "add - добавить новый элемент в коллекцию";
    }
}
