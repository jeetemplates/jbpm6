package com.jeetemplates.jbpm.application.environment;

import javax.enterprise.context.ApplicationScoped;
import org.jbpm.services.cdi.impl.DeploymentServiceCDIImpl;

/**
 * Used to fix org.jboss.weld.exceptions.DeploymentException: WELD-001408
 * Unsatisfied dependencies for type [DeploymentService] with qualifiers
 * [@Default] at injection point [[field] @Inject private
 * org.jbpm.services.cdi.impl.store.DeploymentSyncManager.deploymentService]
 *
 * @author paoesco
 */
@ApplicationScoped
//@Kjar
public class MyDeploymentService extends DeploymentServiceCDIImpl {

}
