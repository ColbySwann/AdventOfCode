import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int currentDialNum = 50;
        int password = 0;
        int passwordRotation = 0;


        File myFile = new File("filename.txt");

        try (Scanner myReader =  new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                String rotation = data.substring(0, 1);
//                System.out.println(rotation);
                String rotateNumString = data.substring(1);
                int rotationNumber = Integer.parseInt(rotateNumString);
//                System.out.println(rotationNumber);

                if (rotation.equals("L")) {
                    currentDialNum -= rotationNumber;
                    while (currentDialNum < 0) {
                        currentDialNum += 100;
                        passwordRotation++;
                    }
                    if (currentDialNum == 0) {
                        password++;
                        System.out.println("After Lands on 0 " + password);
                    }
//                    System.out.println(currentDialNum);
                }

                if (rotation.equals("R")) {
                    currentDialNum += rotationNumber;
                    while (currentDialNum > 99) {
                        if (currentDialNum != 100) {
                            passwordRotation++;
                        }
                        currentDialNum -= 100;
                    }
                    System.out.println("After Loop " + password);
                    if (currentDialNum == 0) {
                        password++;
                        System.out.println("After Lands of 0 " + password);
                    }
                }







            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        System.out.println(password);
        System.out.println(passwordRotation);
    }


}
