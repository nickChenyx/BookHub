package com.chenyx.dto;

import com.chenyx.entity.Appointment;
import com.chenyx.enums.AppointStateEnum;

/**
 * Created by Administrator on 2017/4/5.
 */
public class AppointExecution {

    private long bookId;

    private int state;

    private String stateInfo;

    private Appointment appointment;

    public AppointExecution(){}

    /**
     * 预约成功
     * @param bookId
     * @param stateEnum
     */
    public AppointExecution(long bookId, AppointStateEnum stateEnum){
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 预约失败
     * @param bookId
     * @param stateEnum
     * @param appointment
     */
    public AppointExecution(long bookId, AppointStateEnum stateEnum,Appointment appointment){
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "[ bookId: " + bookId + " , state: " + state +" , stateInfo: "+stateInfo
                +" , appointment: " + appointment;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
