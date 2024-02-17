package com.gkmonk.finalgeekmonkeyapp.model;


public class TaskModel {

    private String taskName;
    private int imgid;



    private Modules module;
    public TaskModel(String dsa, int icMenuCamera, Modules module) {
        this.taskName = dsa;
        this.imgid = icMenuCamera;
        this.module = module;
    }


    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getTaskName() {
        return taskName;
    }

    public Modules getModule() {
        return module;
    }

    public void setModule(Modules module) {
        this.module = module;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}

