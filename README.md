# Jira Date Plugin

**Description**:  This plugin allows current date/time stamping of custom date fields and custom date time fields within Jira workflows. On transition of a Jira ticket this plugin is available as a post function within the workflow.

Other things to include:

  - **Technology stack**: This plugin is written in Java and is intended for use with Jira Server software.
  - **Status**: This project is stable and at a version 1.0.0 release.


## Dependencies

To use this plugin you must have Jira Server.

To work on this plugin you must have Java installed, as well as the Atlassian Plugin SDK.

## Installation

Details for installation can be found in the [INSTALL](INSTALL.md) document.

## Usage

To use this feature in Jira server you must have a custom date or a custom date time field created.

Navigate to the workflow this is to be added to and select the transition where this date time stamp should occur.
Under the 'Post Function' tab click add post function.
Select the post function titled 'Update Custom Field with current date Post Function' and click 'Add'.
On the next screen, put the id of the custom date or date time field you would like the post function to stamp.
    It should resemble 'customfield_13701'.
Then click 'Add'.
If that is all the changes you would like to make to the workflow you can then publish the workflow.
Now the custom field will be stamped when stories that use that workflow go through that transition.

## Known issues

You can only include one Post function of this type per transition.

## Getting help

If you have questions, concerns, bug reports, etc, please file an issue in this repository's Issue Tracker.

## Getting involved

This project has a lot of room to grow. Some of the upcoming features to be implimented are: Adding custom fields via name instead of id, being able to stamp other dates besides just the current date, and being able to add multiple post functions of this type to a transition.

General instructions on _how_ to contribute are available in the [CONTRIBUTING](CONTRIBUTING.md) document.


----

## Open source licensing info
1. [TERMS](TERMS.md)
2. [LICENSE](LICENSE)
3. [CFPB Source Code Policy](https://github.com/cfpb/source-code-policy/)
