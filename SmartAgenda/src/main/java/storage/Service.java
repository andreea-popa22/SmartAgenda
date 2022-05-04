package storage;

import entities.Client;
import entitiesHelpers.Gender;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    public static boolean phoneNumberValidation( String phone) {
            Pattern pattern = Pattern.compile("^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$");
            Matcher matcher = pattern.matcher(phone);
            return(matcher.matches());
    }

    public static Client addNewClient(){
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Name: ");
        String name = scanner1.nextLine();

        System.out.println("Client id: ");
        int id = scanner1.nextInt();

        boolean selected = false;
        String phone = scanner1.nextLine();
        while(!selected){
            System.out.println("Phone: ");
            phone = scanner1.nextLine();
            System.out.println("");
            if (Service.phoneNumberValidation(phone))
            {
                selected = true;
            }
            else {
                System.out.println("Invalid phone number. Try again!");
            }
        }


        System.out.println("Email: ");
        String email = scanner1.nextLine();

        System.out.println("Age: ");
        Integer age = scanner1.nextInt();

        selected = false;
        Gender gender = Gender.OTHER;
        String genderInput = scanner1.nextLine();
        while(!selected)
        {
            System.out.println("Gender (M/F/O): ");
            genderInput = scanner1.nextLine();
            System.out.println("");
            switch (genderInput){
                case "M":
                    gender = Gender.MALE;
                    selected = true;
                    break;
                case "F":
                    gender = Gender.FEMALE;
                    selected = true;
                    break;
                case "O":
                    gender = Gender.OTHER;
                    selected = true;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }

        Client client = Client.builder()
                .clientId(id)
                .name(name)
                .age(age)
                .email(email)
                .phone(phone)
                .gender(gender)
                .build();
        // bug
        //PersonRepository.getInstance().getClients().add(client);
        return client;
    }
}
