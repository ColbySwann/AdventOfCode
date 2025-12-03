import javax.management.StringValueExp;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        long password = 0L;
        int numEven = 0;
        int numOdd = 0;

//        String[] originString = new String[29];

//        originString = {197-407,262128-339499,557930-573266,25-57,92856246-93001520,2-12,1919108745-1919268183,48414903-48538379,38342224-38444598,483824-534754,1056-1771,4603696-4688732,75712519-75792205,20124-44038,714164-782292,4429019-4570680,9648251-9913729,6812551522-6812585188,58-134,881574-897488,648613-673853,5261723647-5261785283,60035-128980,9944818-10047126,857821365-857927915,206885-246173,1922-9652,424942-446151,408-1000};

        File myFile = new File("day2.txt");

        try (Scanner myReader =  new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] originString = data.split(",");
//                System.out.println(Arrays.toString(originString));
//
//                System.out.println(originString.length);

                for (int i = 0; i <= originString.length - 1; i++) {
                    String range = originString[i];
                    String[] split = range.split("-");
                    String start = split[0];
                    String end = split[1];
                    long begin = Long.parseLong(start);
                    long ending = Long.parseLong(end);

//                    System.out.println(begin);

                    for (long j = begin; j <= ending; j++) {
                        String stringJ = String.valueOf(j);

                        int length = stringJ.length();

                        if (length % 2 == 0) {
                            String frontHalf = stringJ.substring(0, stringJ.length()/2);
                            String backHalf = stringJ.substring(stringJ.length()/2);

                            if (frontHalf.equals(backHalf)){
                                System.out.println(stringJ);
//                                System.out.println(frontHalf + " " + backHalf);
//                                System.out.println(true);
                                password+= Long.parseLong(stringJ);


                            }

                        }
                        else {
                            char firstChar = stringJ.charAt(0);
                            for (int k = 1; k < stringJ.length(); k++) {
                                if (stringJ.charAt(k) != firstChar){
                                    break;
                                }
                                if (k == stringJ.length()-1){
                                    System.out.println(stringJ);
                                    password += Long.parseLong(stringJ);
                                }

                            }

                        }
                    }

                }
//                System.out.println(numEven);
                System.out.println(password);
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

//        int currentDialNum = 50;
//        int password = 0;
//        int passwordRotation = 0;
//
//
//        File myFile = new File("filename.txt");
//
//        try (Scanner myReader =  new Scanner(myFile)) {
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
////                System.out.println(data);
//                String rotation = data.substring(0, 1);
////                System.out.println(rotation);
//                String rotateNumString = data.substring(1);
//                int rotationNumber = Integer.parseInt(rotateNumString);
////                System.out.println(rotationNumber);
//
//                if (rotation.equals("L")) {
//                    if (rotationNumber > 100) {
//                        passwordRotation += rotationNumber/100;
//                        while (rotationNumber >= 100){
//                            rotationNumber-=100;
//                        }
//                    }
//                    currentDialNum -= rotationNumber;
//                    System.out.println("current after " +currentDialNum);
//                    while (currentDialNum < 0) {
//                        if (currentDialNum == -rotationNumber){
//                            passwordRotation--;
//                        }
//                        currentDialNum += 100;
//                        if (currentDialNum != 0) {
//                            passwordRotation++;
//                        }
//                    }
//                    if (currentDialNum == 0) {
//                        password++;
//                        System.out.println("After Lands on 0 " + password);
//                    }
////                    System.out.println(currentDialNum);
//                }
//
//                if (rotation.equals("R")) {
//                    if (rotationNumber > 100) {
//                        passwordRotation += rotationNumber/100;
//                        while (rotationNumber >= 100){
//                            rotationNumber-=100;
//                        }
//                    }
//                    currentDialNum += rotationNumber;
//                    System.out.println("current after " +currentDialNum);
//                    while (currentDialNum > 99) {
//                        if (currentDialNum != 100) {
//                            passwordRotation++;
//                        }
//                        currentDialNum -= 100;
//                    }
//                    if (currentDialNum == 0) {
//                        password++;
//                    }
//                }
//
//            }
//        }catch (FileNotFoundException e) {
//            System.out.println("An error occured.");
//            e.printStackTrace();
//        }
//
//        System.out.println(password);
//        System.out.println(passwordRotation);
//        System.out.println(password + passwordRotation);
    }


}
