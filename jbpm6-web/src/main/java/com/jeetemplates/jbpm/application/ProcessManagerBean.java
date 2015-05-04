/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeetemplates.jbpm.application;

import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.model.DeploymentUnit;

/**
 * Use ProcessManagerBean (custom singleton EJB) and only this class to manage
 * processes. Implement all calls to jBPM API here (for transactions).
 *
 * @author paoesco
 */
@ApplicationScoped
public class ProcessManagerBean {

    @Inject
    private ProcessService processService;
    @Inject
    private DeploymentService deploymentService;
    private String myUnitId = "";

    /**
     * Starts a process.
     *
     * @param processId
     */
    public void startProcess(final String processId) {
        startProcess(processId, null);
    }

    /**
     * Starts a process with parameters.
     *
     * @param processId
     * @param parameters
     */
    public void startProcess(final String processId, final Map<String, Object> parameters) {
        if (deploymentService.getDeployedUnit(myUnitId) == null) {
            DeploymentUnit unit = new KModuleDeploymentUnit("com.jeetemplates.bpm", "jbpm6-mykjar", "1.0.0-SNAPSHOT");
            myUnitId = unit.getIdentifier();
            deploymentService.deploy(unit);
        }
        processService.startProcess(myUnitId, processId, parameters);
    }

}
