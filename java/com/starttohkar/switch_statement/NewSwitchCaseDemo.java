package com.starttohkar.switch_statement;

public class NewSwitchCaseDemo {

    public static void main(String[] args) {
        String day = "Monday";
        String result = "";
        //old ways
        switch (day){
            case "Sunday","Saturday":
                System.out.println("6am");
                break;
            case "Monday":
                System.out.println("7am");
                break;
            default:
                System.out.println("7:30am");
        }

        //new ways - there is no break statement required any more
        switch (day){
            case "Sunday","Saturday"-> System.out.println("6am");
            case "Monday" -> System.out.println("7am");
            default -> System.out.println("7:30am");
        }

        //another new way
        result = switch (day){
            case "Sunday","Saturday"-> "6am";
            case "Monday" -> "7am";
            default -> "7:30am";
        };
        System.out.println(result);

        // another new way - using yield
        result = switch (day){
            case "Sunday","Saturday": yield  "6am";
            case "Monday": yield "7am";
            default : yield "7:30am";
        };
        System.out.println(result);
    }
}
