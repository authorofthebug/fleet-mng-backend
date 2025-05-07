package solutions.qowin.fleet.schedule.domain.constants;

public final class ScheduleConstants {
    private ScheduleConstants() {}

    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 100;
    public static final int CODE_MIN_LENGTH = 2;
    public static final int CODE_MAX_LENGTH = 50;
    public static final int DESCRIPTION_MAX_LENGTH = 200;
    public static final int STATUS_MAX_LENGTH = 50;
    public static final String DEFAULT_STATUS = "50";
    public static final String STATUS_ACTIVE = "STATUS_ACTIVE";
    public static final String STATUS_INACTIVE = "STATUS_INACTIVE";
}