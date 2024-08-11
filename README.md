# JIRA-PROJECT
# Team Sync

# Low Level Design

## 1. Task Management API

Factory or Decorator Patterns can be used, but I will use factory for simplicity of different templates creation.

### Classes and Methods

**Class: ProjectManagement**
- `createProject()`
- `updateProject()`
- `deleteProject()`
- `getProject()`

**Class: TaskManagement**
- `createTask()`
- `updateTask()`
- `deleteTask()`
- `getTask()`

## 2. Real-Time Collaboration

Observer pattern will be used to subscribe to updates and receive notifications when changes occur.

### Interface

**Interface: Observer**

### Class and Methods

**Class: RealTimeCollaboration**
- `subscribe()`
- `unsubscribe()`
- `notify()`

## 3. Project Scheduling Engine

### Class and Methods

**Class: ProjectScheduler**
- `addMilestone()`
- `getMilestone()`
- `getAllMilestones()`
- `removeMilestone()`

Set milestones such as "Feature Complete date," "Beta Release date," and "Final Release date" to track progress.

## 4. Resource Allocation Services

### Class and Methods

**Class: ResourceAllocation**
- `addResource()`
- `removeResource()`

Here I will keep in mind the project requirement and availability when implementing.

## 5. File Management System

### Class and Methods

**Class: FileManagementSystem**
- `addFiles()`
- `shareFile()`
- `deleteFile()`

## 6. Dashboard and Reporting Services

### Class and Methods

**Class: DashboardReport**
- `getAllTasks()`
- `getTaskOnMilestone()`
- `getAllProjects()`
- `getTaskOnStatus()`

Filters tasks on milestones and status.

## 7. Access Control Management

### Class and Methods

**Class: AccessControlManagement**
- `hasPermission()`

Project level access control.

## 8. Notification System

Strategy pattern will be used to send notifications by various mediums. Observer pattern to subscribe to various resources.

### Interface

**Interface: Notify**
- `notifyOnStatusChange()`
- `notifyAboutDeadlines()`
- `notifyAboutCommentsAddition()`

### Class and Methods

**Class: NotificationManagementSystem**
- `notifyBySms()`
- `notifyByEmail()`

## 9. Custom Workflow Engine

Some of it is taken care of in point no. 8, so leaving it for now.

## 10. Project Templates and Cloning

### Class and Methods

**Class: Templates**
**Class: Cloning**
- `getAllTemplates()`
- `clone()`

## 11. Time Tracking API

### Class and Methods

**Class: TimeTracking**
- `calculateDaysSpentOnSpecificTask()`