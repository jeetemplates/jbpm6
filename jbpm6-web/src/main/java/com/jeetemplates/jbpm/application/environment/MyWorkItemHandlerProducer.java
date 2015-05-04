package com.jeetemplates.jbpm.application.environment;

import java.util.HashMap;
import java.util.Map;
import org.jbpm.bpmn2.handler.ServiceTaskHandler;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.runtime.manager.WorkItemHandlerProducer;

/**
 *
 * @author paoesco
 */
public class MyWorkItemHandlerProducer implements WorkItemHandlerProducer {

    @Override
    public Map<String, WorkItemHandler> getWorkItemHandlers(String identifier, Map<String, Object> params) {
        Map<String, WorkItemHandler> handlers = new HashMap<>();
        handlers.put("Service Task", new ServiceTaskHandler());
        // Add more handlers if needed
        return handlers;
    }

}
