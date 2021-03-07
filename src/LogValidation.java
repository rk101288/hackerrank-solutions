import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class LogValidation {
    static String regexPattern = "\"type\":\"([A-Z]+)\",\"userID\":\"([0-9]+)\",\"messageID\":\"([0-9A-Za-z]+)\",\"statusCode\":([0-9]+)";
    static Pattern pattern = Pattern.compile(regexPattern);

    //TODO Better suited as ENUM
    private static final String PERFORMANCE = "PERFORMANCE";
    private static final String ERROR = "ERROR";
    private static final String INFO = "INFO";

    static Map<String, List<String>> validateLogs(List<Log> logs) {
        Map<String, List<String>> validLogs = new HashMap<>();

        validLogs.put(ERROR, new ArrayList<>());
        validLogs.put(PERFORMANCE, new ArrayList<>());
        validLogs.put(INFO, new ArrayList<>());

        for (Log log : logs) {
            if(log.type != null && !log.type.isEmpty()) {
                if(log.statusCode >= 400 || !isValidUserId(log.userID)) {
                    List<String> errorMessages = validLogs.get(ERROR);
                    errorMessages.add(log.messageID);
                    validLogs.put(ERROR, errorMessages);
                } else {
                    List<String> listOfMessages = validLogs.get(log.type);
                    listOfMessages.add(log.messageID);
                    validLogs.put(log.type, listOfMessages);
                }
            }
        }
        return validLogs;
    }

    private static boolean isValidUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            return false;
        }

        try {
            String firstTwo = userId.substring(0, Math.min(2, userId.length()));
            Integer firstTwoInt = Integer.parseInt(firstTwo);
            Character lastChar = userId.charAt(userId.length() - 1);
            Integer lastCharInt = Character.getNumericValue(lastChar);

            return (firstTwoInt % lastCharInt) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static class Log {
        String type;
        String userID;
        String messageID;
        int statusCode;

        public Log(String type, String userID, String messageID, int statusCode) {
            this.type = type;
            this.userID = userID;
            this.messageID = messageID;
            this.statusCode = statusCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getMessageID() {
            return messageID;
        }

        public void setMessageID(String messageID) {
            this.messageID = messageID;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner input = new Scanner(System.in);
        List<Log> logs = new ArrayList<Log>();
//        do {
//            Log log = new Log();
//            Matcher matcher = pattern.matcher(input.nextLine());
//            while (matcher.find()) {
//                log.type = matcher.group(1);
//                log.userID = matcher.group(2);
//                log.messageID = matcher.group(3);
//                log.statusCode = Integer.parseInt(matcher.group(4));
//            }
//            logs.add(log);
//        }while(input.hasNext());


        logs.add(new Log("PERFORMANCE", "12345678906", "123", 200));
        logs.add(new Log("PERFORMANCE", "12345678905", "456", 200));
        logs.add(new Log("PERFORMANCE", "12345678905", "457", 200));
        logs.add(new Log("PERFORMANCE", "12345678906", "458", 400));
        logs.add(new Log("ERROR", "12345678906", "546", 401));
        logs.add(new Log("ERROR", "12345678900", "78", 401));
        logs.add(new Log("ERROR", "1", "77", 401));
        logs.add(new Log("ERROR", "", "79", 401));
        logs.add(new Log("ERROR", null, "80", 401));
        printLogResults(validateLogs(logs));
    }

    public static void printLogResults(Map<String, List<String>> processedLogs) {
        StringBuffer sb = new StringBuffer();
        sb.append("{").append("\"ERROR\":[\"").append(processedLogs.get("ERROR").stream().collect(Collectors.joining("\",\""))).append("\"],");
        sb.append("\"INFO\":[\"").append(processedLogs.get("INFO").stream().collect(Collectors.joining("\",\""))).append("\"],");
        sb.append("\"PERFORMANCE\":[\"").append(processedLogs.get("PERFORMANCE").stream().collect(Collectors.joining("\",\""))).append("\"]");
        sb.append("}");
        System.out.println(sb.toString());
    }
}

