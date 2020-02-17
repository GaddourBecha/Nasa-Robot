import config.PlateauConstants;
import config.PlateauSpecs;
import exception.CommandNotValidException;
import exception.DirectionNotValidException;
import exception.PositionNotValidException;
import model.Robot;

import java.io.*;
public class Main {

    public static void main(String[] args) {
        try {
            if(args[0]==null)
                throw new RuntimeException();
            Robot p = null;
            BufferedReader br = new BufferedReader(new FileReader(new File( args[0])));
            String[] lineElements;
            String st = br.readLine();
            if(st != null){
                lineElements = st.split(" ");
                PlateauSpecs.maxX=Integer.valueOf(lineElements[0]);
                PlateauSpecs.maxY=Integer.valueOf(lineElements[1]);
            }

            while ((st = br.readLine()) != null){
               lineElements = st.trim().split(" ");
               if(lineElements.length==3){
                    p = new Robot(Integer.valueOf(lineElements[0]),Integer.valueOf(lineElements[1]),lineElements[2].charAt(0));
               }else if(lineElements.length==1){
                   sendCommand(p,st);
                   System.out.println(p);
               }else{
                   throw new RuntimeException();
               }
            }
        } catch (DirectionNotValidException e) {
            System.out.println(e.getMessage());
        } catch (PositionNotValidException e) {
            System.out.println(e.getMessage());
        } catch (CommandNotValidException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Input file is not correct");
        }

    }

    public static void sendCommand(Robot p, String command){
        for(int i =0 ;i<command.length();i++){
            switch(command.charAt(i)){
                case PlateauConstants.TURN_LEFT : p.turnLeft(); break;
                case PlateauConstants.TURN_RIGHT : p.turnRight(); break;
                case PlateauConstants.MOVE_FORWARD : p.moveForward(); break;
                default: throw new CommandNotValidException();
            }
        }
    }


}
