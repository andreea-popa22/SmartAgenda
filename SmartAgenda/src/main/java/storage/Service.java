package storage;

import entities.*;
import entitiesHelpers.Gender;
import entitiesHelpers.ServiceType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public static Client getClientByPhoneNumber(String phone){
        List<Client> list = PersonRepository.getInstance().getClients().stream().filter(p -> Objects.equals(p.getPhone(), phone)).map(p -> Client.builder()
                        .clientId(p.getClientId())
                        .name(p.getName())
                        .age(p.getAge())
                        .email(p.getEmail())
                        .phone(p.getPhone())
                        .gender(p.getGender())
                        .build())
                .collect(Collectors.toList());
        // error if not found
        return list.get(0);
    }

    public static Client getClientById(int id){
        List<Client> list = PersonRepository.getInstance().getClients().stream().filter(p -> Objects.equals(p.getClientId(), id)).map(p -> Client.builder()
                        .clientId(p.getClientId())
                        .name(p.getName())
                        .age(p.getAge())
                        .email(p.getEmail())
                        .phone(p.getPhone())
                        .gender(p.getGender())
                        .build())
                .collect(Collectors.toList());
        // error if not found
        return list.get(0);
    }

    public static Provider getProviderById(int id){
        return PersonRepository.getInstance().getProviders().stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }

    public static Location getLocationById(int id){
        return LocationRepository.getInstance().getLocations().stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }

    public static Appointment addNewAppointment() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Id: ");
        int id = scanner.nextInt();

        System.out.println("Duration: ");
        float duration = scanner.nextFloat();

        System.out.println("Date (DD/MM/YYYY): ");
        String dateInput = scanner.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInput);

        System.out.println("Time (hh:mm): ");
        Hour time = Service.stringToHour(scanner.nextLine());

        System.out.println("Client id: ");
        int clientId = scanner.nextInt();
        Client client = Service.getClientById(clientId);

        System.out.println("Provider id: ");
        int providerId = scanner.nextInt();
        Provider provider = Service.getProviderById(providerId);

        System.out.println("Location id: ");
        int locationId = scanner.nextInt();
        Location location = Service.getLocationById(locationId);

        System.out.println("Service Type: ");
        // TODO print all service types
        String serviceTypeString = scanner.nextLine();
        ServiceType serviceType = ServiceType.valueOf(serviceTypeString);

        System.out.println("Price: ");
        int price = scanner.nextInt();

        // TODO add appointment to client and provider schedule
        Appointment appointment = Appointment.builder()
                .id(id)
                .duration(duration)
                .date(date)
                .time(time)
                .client(client)
                .provider(provider)
                .location(location)
                .serviceType(serviceType)
                .price(price)
                .build();
        return appointment;
    }

    public static Hour stringToHour(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int minutes = Integer.parseInt(s.substring(3, 5));
        Hour h = Hour.builder()
                .hour(hour)
                .minutes(minutes)
                .build();
        return h;
    }
}
