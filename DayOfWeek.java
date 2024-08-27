public enum DayOfWeek {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");

    private final int dayNumber;
    private final String displayString;

    DayOfWeek(int dayNumber, String displayString) {
        this.dayNumber = dayNumber;
        this.displayString = displayString;
    }

    public int getDayNumber() {
        return this.dayNumber;
    }
}
