import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

class CandidateSolution {
    private static final int NUMBER_OF_ROOMS = 8;

    private Map<Integer, List<Reservation>> reservations = new HashMap<>();

//    private void removeRooms() {
//        for(Map.Entry<Integer, List<Reservation>> reservs : reservations.entrySet()) {
//            for(Reservation r : reservs.getValue()) {
//                if(r.endTime.isAfter(Instant.EPOCH)) {
//                    List<Reservation> newList = reservs.getValue();
//                    newList.remove(r);
//                    reservations.put(reservs.getKey(), newList);
//                }
//            }
//
//        }
//    }

    public int reserveRoom(long startEpochSeconds, long endEpochSeconds) {
//        Runnable r = this::removeRooms;
//
//        new Thread(r).start();
//        removeRooms();

        Instant start =  Instant.ofEpochSecond(startEpochSeconds);
        Instant end = Instant.ofEpochSecond(endEpochSeconds);

        if(!validMeetingTime(start, end) || !validMeetingLength(start, end)) {
            return -2;
        }

        //TODO Validate for Meetings in past

        if(reservations.size() == 0 || reservations.size() < NUMBER_OF_ROOMS) {
            int room = getRandomRoomNumber();
            List<Reservation> temp = new ArrayList<>();
            temp.add(new Reservation(start, end, room));
            reservations.put(room, temp);
            return room;
        }

        for(Map.Entry<Integer, List<Reservation>> reses : reservations.entrySet()) {
            for(Reservation res : reses.getValue()) {
              if(isFreeRoom(start, end, res)) {
                  Reservation temp = new Reservation(start, end, res.getRoomNumber());
                  List<Reservation> newList = reses.getValue();
                  newList.add(temp);
                  reservations.put(res.getRoomNumber(), newList);
                  return res.getRoomNumber();
              }
            }
        }

        return  -1;
    }


    private boolean isFreeRoom(Instant start, Instant end, Reservation reservation) {
        return (start.isAfter(reservation.getEndTime()) || start.equals(reservation.endTime))
                || (start.isBefore(reservation.startTime) && end.isBefore(reservation.startTime));
    }

    private int getRandomRoomNumber() {
        Random rand = new Random();
        int roomNumber = rand.nextInt(NUMBER_OF_ROOMS) + 1;
        if (!reservations.containsKey(roomNumber)) {
            return roomNumber;
        } else {
            return getRandomRoomNumber();
        }
    }

    private boolean validMeetingTime(Instant startEpochSeconds, Instant endEpochSeconds) {
        int start = LocalDateTime.ofInstant(startEpochSeconds, ZoneId.systemDefault()).getMinute();
        int end = LocalDateTime.ofInstant(endEpochSeconds, ZoneId.systemDefault()).getMinute();

        return start % 5 == 0 && end % 5 == 0;
    }

    private boolean validMeetingLength(Instant startEpochSeconds, Instant endEpochSeconds) {
        long between = Duration.between(startEpochSeconds, endEpochSeconds).toMinutes();
        int sevenDaysInMinutes = 7 * 24 * 60;

        return between >= 5 && between <= sevenDaysInMinutes;

    }

    class Reservation {
        private Instant startTime;
        private Instant endTime;
        private int roomNumber;

        public Reservation(Instant startTime, Instant endTime, int roomNumber) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.roomNumber = roomNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Reservation that = (Reservation) o;
            return roomNumber == that.roomNumber &&
                    Objects.equals(startTime, that.startTime) &&
                    Objects.equals(endTime, that.endTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startTime, endTime, roomNumber);
        }

        public Instant getStartTime() {
            return startTime;
        }

        public void setStartTime(Instant startTime) {
            this.startTime = startTime;
        }

        public Instant getEndTime() {
            return endTime;
        }

        public void setEndTime(Instant endTime) {
            this.endTime = endTime;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }
    }

}

