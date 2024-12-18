import java.util.*;

class Time {
    int min, sec;
    
    Time(String len) {
        String[] min_sec = len.split(":");
        
        this.min = Integer.valueOf(min_sec[0]);
        this.sec = Integer.valueOf(min_sec[1]);
    }
    
    public void prev() {
        this.sec -= 10;
        
        if (this.sec < 0 && this.min > 0) {
            this.sec += 60;
            this.min--;
        } else if (this.sec < 0) {
            this.sec = 0;
            this.min = 0;
        }
    }
    
    public void next() {
        this.sec += 10;
        
        if (this.sec >= 60) {
            this.sec -= 60;
            this.min++;
        }
    }
    
    public boolean afterTime(Time opening) {
        return this.min > opening.min || (this.min == opening.min && this.sec >= opening.sec);
    }
    
    public boolean beforeTime(Time ending) {
        return this.min < ending.min || (this.min == ending.min && this.sec <= ending.sec);
    }
}

class Solution {
    private boolean afterTime(Time pos, Time opening) {
        return pos.min > opening.min || (pos.min == opening.min && pos.sec >= opening.sec);
    }
    
    private boolean beforeTime(Time pos, Time ending) {
        return pos.min < ending.min || (pos.min == ending.min && pos.sec <= ending.sec);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        Time videoTime = new Time(video_len);
        Time nowPos = new Time(pos);
        Time op_startTime = new Time(op_start);
        Time op_endTime = new Time(op_end);
        
        if (nowPos.afterTime(op_startTime) && nowPos.beforeTime(op_endTime)) {
            nowPos.min = op_endTime.min;
            nowPos.sec = op_endTime.sec;
        }
        
        for (String command: commands) {
            switch (command) {
                case "prev" -> nowPos.prev();
                case "next" -> nowPos.next();
            }
            
            if (nowPos.afterTime(videoTime)) {
                nowPos.min = videoTime.min;
                nowPos.sec = videoTime.sec;
            }
            
            if (nowPos.afterTime(op_startTime) && nowPos.beforeTime(op_endTime)) {
                nowPos.min = op_endTime.min;
                nowPos.sec = op_endTime.sec;
            }
        }
        
        return String.format("%02d:%02d", nowPos.min, nowPos.sec);
    }
}