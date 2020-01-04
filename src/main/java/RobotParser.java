import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotParser {

    private Robot robot;

    public RobotParser(){
        robot = new Robot();
    }

    public void mainLoop(){

        List<String> knownCommands = new ArrayList<>();
        knownCommands.add("naladuj");
        knownCommands.add("ruch");
        knownCommands.add("wylacz");
        knownCommands.add("wlacz");
        knownCommands.add("status");
        knownCommands.add("help");


        boolean robotRuns = true;
        Scanner input = new Scanner(System.in);

        while (robotRuns)
        {
            String command = input.nextLine();

            //tokenize
            String[] tokens = command.split(" ");

            if(knownCommands.contains(tokens[0]) == false)continue;

            switch (tokens[0])
            {
                case "status":
                    System.out.println("Battery Level: "+robot.getBatteryLevel());
                    break;
                case "help":
                    knownCommands.forEach(item-> System.out.println(item));
                    break;
                case "naladuj":
                    robot.setBatteryLevel(100.0);
                    break;
                case "wylacz":
                    robot.setPowerOn(false);
                    break;
                case "wlacz":
                    robot.setPowerOn(true);
                    break;


                case "ruch":
                    if(tokens.length<3 || robot.getPowerOn() == false)break;

                    switch (tokens[1])
                    {
                        case "lewo":

                                switch (tokens[2])
                                {
                                    case "reka":
                                        if(robot.getBatteryLevel()-
                                                robot.getBatteryUsageMapping().get(RuchRobota.RUCH_REKA_LEWA)>=0)
                                        robot.setBatteryLevel(robot.getBatteryLevel()-
                                                robot.getBatteryUsageMapping().get(RuchRobota.RUCH_REKA_LEWA));
                                        break;
                                    case "noga":
                                        if(robot.getBatteryLevel()-
                                                robot.getBatteryUsageMapping().get(RuchRobota.KROK_LEWA)>=0)
                                        robot.setBatteryLevel(robot.getBatteryLevel()-
                                                robot.getBatteryUsageMapping().get(RuchRobota.KROK_LEWA));

                                        break;
                                }

                            break;
                        case "prawo":
                            switch (tokens[2])
                            {
                                case "reka":
                                    if(robot.getBatteryLevel()-
                                            robot.getBatteryUsageMapping().get(RuchRobota.RUCH_REKA_PRAWA)>=0)
                                    robot.setBatteryLevel(robot.getBatteryLevel()-
                                            robot.getBatteryUsageMapping().get(RuchRobota.RUCH_REKA_PRAWA));
                                    break;
                                case "noga":
                                    if(robot.getBatteryLevel()-
                                            robot.getBatteryUsageMapping().get(RuchRobota.KROK_PRAWA)>=0)
                                    robot.setBatteryLevel(robot.getBatteryLevel()-
                                            robot.getBatteryUsageMapping().get(RuchRobota.KROK_PRAWA));
                                    break;
                            }
                            break;

                    }

                    break;
            }

        }


    }


}
