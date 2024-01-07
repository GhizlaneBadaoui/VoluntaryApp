package fr.insa.ws.model;

import java.util.Objects;

public class Mission {
    private String requesterMail;
    private String volunteerMail;
    public String description;
    public enum State{completed, InProgress, validated};
    private State state;

    public enum Submitter{ requester, volunteer};
    private Submitter submitter;

    public Mission(String submitterMail, String description, State state, Submitter submitter) {
        if(MissionTable.checkSubmitter(submitterMail,submitter)){
            if(submitter == Submitter.volunteer)
                this.volunteerMail = submitterMail;
            else
                this.requesterMail = submitterMail;
            MissionTable.addMission(submitterMail,description,state,submitter);
            this.description = description;
            this.state = state;
            this.submitter = submitter;
        }
    }

    public static void deleteMission(int id) {
        MissionTable.deleteMission(id);
    }
    public static void updateStateMission(int id, State state) {
        MissionTable.updateState(id,state);
    }

    public static String getMission(int id) {
        return MissionTable.getMission(id);
    }

    public String getRequesterMail() {
        return requesterMail;
    }

    public void setRequesterMail(String requesterMail) {
        this.requesterMail = requesterMail;
    }

    public String getVolunteerId() {
        return volunteerMail;
    }

    public void setVolunteerId(String volunteerMail) {
        this.volunteerMail = volunteerMail;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "requesterId=" + requesterMail +
                ", volunteerId=" + volunteerMail +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}