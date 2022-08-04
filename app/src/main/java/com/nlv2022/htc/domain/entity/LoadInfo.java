package com.nlv2022.htc.domain.entity;

public class LoadInfo {
    private boolean status;
    private String time;


    public LoadInfo(boolean status, String time) {
        this.status = status;
        this.time = time;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoadInfo loadInfo = (LoadInfo) o;

        if (status != loadInfo.status) return false;
        return time != null ? time.equals(loadInfo.time) : loadInfo.time == null;
    }

    @Override
    public int hashCode() {
        int result = (status ? 1 : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "LoadInfo{" +
                "status=" + status +
                ", time='" + time + '\'' +
                '}';
    }
}
