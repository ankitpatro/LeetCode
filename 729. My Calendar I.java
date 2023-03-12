class MyCalendar {

TreeMap<Integer, Integer> meetings;
    public MyCalendar() {
        meetings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        Integer floor = meetings.floorKey(start);
        Integer ceiling = meetings.ceilingKey(start);

        if(floor != null && start < meetings.get(floor) || ceiling != null && end > ceiling) return false;

        
            meetings.put(start, end);
            return true;
    
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
