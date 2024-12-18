import java.util.*;

class Solution {
    private int toSec(String time) {
        String[] times = time.split(":");
        
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = toSec(video_len);
        int posSec = toSec(pos);
        int opStartSec = toSec(op_start);
        int opEndSec = toSec(op_end);
        
        if (posSec >= opStartSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }
        
        for (String command: commands) {
            switch(command) {
                case "prev" -> posSec = (posSec - 10 < 0) ? 0 : posSec - 10;
                case "next" -> posSec = (posSec + 10 > videoLenSec) ? videoLenSec : posSec + 10;
            }
            
            if (posSec >= opStartSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }
        
        return String.format("%02d:%02d", posSec/60, posSec%60);
    }
}