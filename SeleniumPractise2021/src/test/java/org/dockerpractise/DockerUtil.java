package org.dockerpractise;

import org.testng.Assert;

import java.io.*;
import java.util.Calendar;

public class DockerUtil {

    public static void startDocker() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        File file = new File("docker_up_log.txt");
        BufferedReader bufferedReader = null;
        String currLine =  null;
        boolean serverStarted = false;

        if(file.exists()){
            file.delete();
        }
        try {
            runtime.exec("cmd /c start docker_up.bat");
            Thread.sleep(3000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 45);
        long stopTime = calendar.getTimeInMillis();
//        String file = "docker_up_log.txt";
        while (System.currentTimeMillis() < stopTime){
            bufferedReader = new BufferedReader(new FileReader(String.valueOf("docker_up_log.txt")));
            do {
                try {
                    currLine = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(currLine!= null && currLine.contains("Node has been added")){
                    System.out.println("Grid has been started");
                    serverStarted = true;
                    break;
                }
            } while(currLine!=null && !serverStarted);
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(serverStarted, "Docker failed to start");

    }


    public static void stopDocker() throws FileNotFoundException {
        Runtime runtime = Runtime.getRuntime();
        File file = new File("docker_down_log.txt");
        BufferedReader bufferedReader = null;
        String currLine =  null;
        boolean serverStopped = false;

        if(file.exists()){
            file.delete();
        }
        try {
            runtime.exec("cmd /c start docker_down.bat");
            Thread.sleep(3000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 45);
        long stopTime = calendar.getTimeInMillis();
        while (System.currentTimeMillis() < stopTime){
            bufferedReader = new BufferedReader(new FileReader(String.valueOf("docker_down_log.txt")));
            do {
                try {
                    currLine = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(currLine!= null && currLine.contains("Node has been stopped")){
                    System.out.println("Grid has been stopped");
                    serverStopped = true;
                    break;
                }
            } while(currLine!=null && !serverStopped);
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//         no logs are written on closing docker compose
//        Assert.assertTrue(serverStopped, "Docker failed to stop");

    }

}
