package com.atlassian.test.plugin.jira.workflow;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.plugin.workflow.AbstractWorkflowPluginFactory;
import com.atlassian.jira.plugin.workflow.WorkflowPluginFunctionFactory;
import com.atlassian.jira.workflow.JiraWorkflow;
import com.atlassian.jira.workflow.WorkflowManager;
import com.opensymphony.workflow.loader.*;
import java.util.HashMap;
import java.util.Map;
import webwork.action.ActionContext;

public class UpdateFieldPostFunctionFactory extends AbstractWorkflowPluginFactory implements WorkflowPluginFunctionFactory {
    public static final String FIELD_MESSAGE = "customField";

    private WorkflowManager workflowManager;

    public UpdateFieldPostFunctionFactory() {
        this.workflowManager = ComponentAccessor.getWorkflowManager();
    }

    @Override
    protected void getVelocityParamsForInput(Map<String, Object> velocityParams) {
        Map<String, String[]> myParams = ActionContext.getParameters();
        final JiraWorkflow jiraWorkflow = workflowManager.getWorkflow(myParams.get("workflowName")[0]);
    }

    @Override
    protected void getVelocityParamsForEdit(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        getVelocityParamsForInput(velocityParams);
        getVelocityParamsForView(velocityParams, descriptor);
    }

    @Override
    protected void getVelocityParamsForView(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        if (!(descriptor instanceof FunctionDescriptor)) {
            throw new IllegalArgumentException("Descriptor must be a FunctionDescriptor.");
        }

        FunctionDescriptor functionDescriptor = (FunctionDescriptor)descriptor;
        String message = (String)functionDescriptor.getArgs().get(FIELD_MESSAGE);

        //if (message == null) {
        //    message = "";
        //}

        velocityParams.put(FIELD_MESSAGE, message);
    }

    public Map<String,?> getDescriptorParams(Map<String, Object> formParams) {
        Map params = new HashMap();

        String message = extractSingleParam(formParams, FIELD_MESSAGE);
        params.put(FIELD_MESSAGE, message);

        return params;
    }
}