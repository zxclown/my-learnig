package com.zxclown.learning.statemachine.constants;

import java.util.HashSet;
import java.util.Set;

/**
 * The enum Claim states.
 */
public class ClaimStates {
    public static final String IN_REPORTING = "IN_REPORTING";
    public static final String REPORTED = "REPORTED";
    public static final String IN_REGISTERING = "IN_REGISTERING";
    public static final String REGISTERED = "REGISTERED";
    public static final String IN_ADJUSTING = "IN_ADJUSTING";
    public static final String ADJUSTED = "ADJUSTED";
    public static final String IN_CLOSING = "IN_CLOSING";
    public static final String CLOSED = "CLOSED";
    public static final String CANCELED = "CANCELED";
    public static final String PAID_SUCCESS = "PAID_SUCCESS";
    public static final String PAID_FAILURE = "PAID_FAILURE";
    public static final String RETAIN = "RETAIN";
    public static final String WITHDRAW = "WITHDRAW";
    public static final String CUSTOMER_REPORTING = "CUSTOMER_REPORTING";
    public static final String START = "START";
    public static final String END = "END";
    public static final Set<String> STATES = new HashSet<>();

    static {
        STATES.add(IN_REPORTING);
        STATES.add(REPORTED);
        STATES.add(IN_REGISTERING);
        STATES.add(REGISTERED);
        STATES.add(IN_ADJUSTING);
        STATES.add(ADJUSTED);
        STATES.add(IN_CLOSING);
        STATES.add(CLOSED);
        STATES.add(CANCELED);
        STATES.add(PAID_SUCCESS);
        STATES.add(PAID_FAILURE);
        STATES.add(RETAIN);
        STATES.add(WITHDRAW);
        STATES.add(CUSTOMER_REPORTING);
        STATES.add(START);
        STATES.add(END);
    }
}
