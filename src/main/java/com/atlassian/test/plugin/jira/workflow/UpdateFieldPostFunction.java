package com.atlassian.test.plugin.jira.workflow;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.ModifiedValue;
import com.atlassian.jira.issue.util.IssueChangeHolder;
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder;
import com.atlassian.jira.workflow.function.issue.AbstractJiraFunctionProvider;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.WorkflowException;
import java.sql.Timestamp;
import java.util.Map;

public class UpdateFieldPostFunction extends AbstractJiraFunctionProvider {
    public static final String FIELD_MESSAGE = "customField";

    public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
        MutableIssue issue = getIssue(transientVars);
        String custFieldId = (String)args.get(FIELD_MESSAGE);
        if (custFieldId != null) {
            CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager();
            CustomField cf = customFieldManager.getCustomFieldObject(custFieldId);
            Timestamp valueField = (Timestamp)issue.getCustomFieldValue(cf);
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            IssueChangeHolder changeHolder = new DefaultIssueChangeHolder();
            cf.updateValue(null, issue, new ModifiedValue(valueField, currentTimestamp), changeHolder);
        }
    }
}