package ru.itsjava;

import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        menu();
        System.out.println("Досвидания!");
    }

    private static void menu() {
        String mainMenu = "1. Показать все велосипеды." +
                "\n2. Добавить велосипед." +
                "\n3. Приобрести велосипед." +
                "\n4. Показать велосипеды в аренде." +
                "\n5. Завершить аренду велосипеда." +
                "\n6. Отсортировать велосипеды." +
                "\n0. Выход.";
        String subMenu3 = "1. В аренду." +
                "\n2. Купить." +
                "\n0. Выход.";
        String[] bikesInShop = new String[]{"Aist", "Maist", "BMX", "BMW"};
        String[] rentBikes = new String[0];
        Scanner scan = new Scanner(System.in);
        int numOfMenu;
        while ((numOfMenu = menuSelector(scan, 6, mainMenu)) != 0) {
            switch (numOfMenu) {
                case 1:
                    showAllBikes(bikesInShop);
                    break;
                case 2:
                    bikesInShop = addBike(scan, bikesInShop);
                    System.out.println("Новый список велосипедов: ");
                    showAllBikes(bikesInShop);
                    break;
                case 3:
                    int numOfSubmenu;
                    while ((numOfSubmenu = menuSelector(scan, 2, subMenu3)) != 0) {
                        switch (numOfSubmenu) {
                            case 1:
                                System.out.println("Выберите велосипед, который вы хотите взять в аренду: ");
                                showBikesChose(bikesInShop);
                                int bikeToRent = scan.nextInt();
                                while ((bikeToRent < 1) || (bikeToRent > bikesInShop.length)) {
                                    System.out.println("Такой позиции нет в списке");
                                    bikeToRent = scan.nextInt();
                                }
                                rentBikes = addBike(rentBikes, bikesInShop[bikeToRent - 1]);
                                System.out.println("Велосипед " + bikesInShop[bikeToRent - 1] + " успешно сдан в аренду");
                                bikesInShop = delItem(bikeToRent, bikesInShop);
                                break;
                            case 2:
                                System.out.println("Выберите велосипед для покупки: ");
                                showBikesChose(bikesInShop);
                                int bikeToBuy = scan.nextInt();
                                while ((bikeToBuy < 1) || (bikeToBuy > bikesInShop.length)) {
                                    System.out.println("Такой позиции нет в списке");
                                    bikeToBuy = scan.nextInt();
                                }
                                System.out.println("Велосипед " + bikesInShop[bikeToBuy - 1] + " покинул склад.");
                                bikesInShop = delItem(bikeToBuy, bikesInShop);
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Список арендованных велосипедов: ");
                    showAllBikes(rentBikes);
                    break;
                case 5:
                    if (rentBikes.length == 0) {
                        System.out.println("Отсутствуют велосипеды в аренде");
                        break;
                    }
                    System.out.println("возврат арендованного велосипеда.\nВыберите позицию для возврата: ");
                    showBikesChose(rentBikes);
                    int bikeToReturn = scan.nextInt();
                    while ((bikeToReturn < 1) || (bikeToReturn > bikesInShop.length)) {
                        System.out.println("Такой позиции нет в списке");
                        bikeToReturn = scan.nextInt();
                    }
                    bikesInShop = addBike(bikesInShop, rentBikes[bikeToReturn - 1]);
                    System.out.println(rentBikes[bikeToReturn - 1] + " успешно возвращён на склад.\nНовый список велосипедов: ");
                    rentBikes = delItem(bikeToReturn - 1, rentBikes);
                    showAllBikes(bikesInShop);
                    break;
                case 6:
                    System.out.println("Список до сортировки");
                    showAllBikes(bikesInShop);
                    sortBikes(bikesInShop);
                    System.out.println("Список после сортировки");
                    showAllBikes(bikesInShop);
                    break;
            }
        }
        scan.close();
    }

    private static void sortBikes(String[] bikes) {
        for (int i = 0; i < bikes.length; i++) {
            for (int j = 0; j < bikes.length - 1 - i; j++) {
                if (aBiggerB(bikes[j], bikes[j + 1])) {
                    swap(bikes, j, j + 1);
                }
            }
        }
    }

    private static void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static boolean aBiggerB(String stringA, String stringB) {
        int shortestString = Math.min(stringA.length(), stringB.length());
        for (int i = 0; i < shortestString; i++) {
            if (stringA.charAt(i) > stringB.charAt(i)) {
                return true;
            } else if (stringA.charAt(i) < stringB.charAt(i)) {
                return false;
            }
        }
        return stringA.length() > shortestString;
    }

    private static String[] delItem(int bikeToRent, String[] bikesInShop) {
        String[] newBikesInShop = new String[bikesInShop.length - 1];
        if (newBikesInShop.length == 0) {
            return newBikesInShop;
        }
        int j = 0;
        for (int i = 0; i < bikesInShop.length; i++) {
            if ((bikeToRent - 1) == i) {
                continue;
            }
            newBikesInShop[j] = bikesInShop[i];
            j++;
        }
        return newBikesInShop;
    }

    private static String[] addBike(Scanner scan, String[] arrayOfBikes) {
        System.out.println("Добавьте велосипеды через \",\"");
        scan.nextLine();
        String input = scan.nextLine();
        String[] inputSplit = input.split(",");
        for (String each : inputSplit) {
            each = each.strip();
            arrayOfBikes = Arrays.copyOf(arrayOfBikes, arrayOfBikes.length + 1);
            arrayOfBikes[arrayOfBikes.length - 1] = each;
        }
        return arrayOfBikes;
    }

    private static String[] addBike(String[] arrayOfBikes, String nameOfBike) {
        arrayOfBikes = Arrays.copyOf(arrayOfBikes, arrayOfBikes.length + 1);
        arrayOfBikes[arrayOfBikes.length - 1] = nameOfBike;
        return arrayOfBikes;
    }

    private static void showBikesChose(String[] bikesInShop) {
        if (bikesInShop.length == 0) {
            System.out.println("В списке нет ни одного велосипеда.");
            return;
        }
        int i = 1;
        for (String each : bikesInShop) {
            System.out.println(i + ". " + each);
            i++;
        }
    }

    private static void showAllBikes(String[] bikesInShop) {
        if (bikesInShop.length == 0) {
            System.out.println("В списке нет ни одного велосипеда.");
            return;
        }
        for (int i = 0; i < bikesInShop.length; i++) {
            if (i < bikesInShop.length - 1) {
                System.out.print(bikesInShop[i] + ", ");
            } else
                System.out.println(bikesInShop[i]);
        }
    }

    private static void printMenu(String menuString) {
        System.out.println(menuString);
    }

    private static int menuSelector(Scanner scan, int maxPoint, String menuString) {
        int input;
        System.out.println("Выберите пункт меню: ");
        printMenu(menuString);
        while ((input = scan.nextInt()) != 0) {
            if ((input > 0) && (input <= maxPoint)) {
                return input;
            } else {
                System.out.println("Неизвестная команда.");
                System.out.println("Выберите пункт меню: ");
                printMenu(menuString);
            }
        }
        return 0;
    }
}
