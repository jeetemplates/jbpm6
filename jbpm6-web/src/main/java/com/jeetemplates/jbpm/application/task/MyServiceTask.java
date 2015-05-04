package com.jeetemplates.jbpm.application.task;

/**
 * A simple service task called by jBPM simple process. If moved or renamed,
 * don't forget to change it in jBPM process.
 *
 * @author paoesco
 */
public class MyServiceTask {

    public String myOperation(String parameter) {
        System.out.println("Test");
        return "test";
    }

}
