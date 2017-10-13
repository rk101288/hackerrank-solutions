import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricks on 9/25/17.
 */
public class DoesCircleExist {

    public static void main(String args[]) {
        String[] example = new String[]{"G", "L"};
        String[] results = doesCircleExist(example);

    }

    static String[] doesCircleExist(String[] commands) {
        int currentDirection = 1;
        String[] responses = new String[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int x = 0;
            int y = 0;

            String[] realCommands = commands[i].split("");
            for (int j = 0; j < realCommands.length; j++) {
                switch (realCommands[j]) {
                    case "L":
                        currentDirection = currentDirection == 1 ? 4 : currentDirection - 1;
                        break;
                    case "R":
                        currentDirection = currentDirection == 4 ? 1 : currentDirection + 1;
                        break;
                    case "G":
                        switch (currentDirection) {
                            case 1:
                                y = y + 1;
                                break;
                            case 2:
                                x = x + 1;
                                break;
                            case 3:
                                y = y - 1;
                                break;
                            case 4:
                                x = x - 1;
                                break;
                        }
                        break;
                    default:
                        throw new RuntimeException("Invalid direction");
                }
            }


            responses[i] = x == 0 && y == 0 ? "YES" : "NO";
        }

        return responses;
    }
}
