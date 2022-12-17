package miu.edu.springsecuritylab6.constant;

public class Authority {

    public static final String[] USER_AUTHORITIES = {"user:read"};

    public static final String[] ADMIN_AUTHORITIES = {"user:read", "user:create", "user:update","user:delete"};

}
