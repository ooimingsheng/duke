# User Guide

## Features 

### Feature 1

List all tasks in the reminder system.

## Usage

### `list` - Lists all tasks in the reminder system.

Type in command list to display a list of all the tasks in the reminder system.

Example of usage: 

`list`

Expected outcome:

`Here are the tasks in your list:
      1.[T][X] 1sda
      2.[T][done] asd
      3.[T][done] catch
      4.[T][X] damn
      5.[E][X] wash rat (at: backyard)`   
 

### Feature 2

Add a task to the reminder system.

## Usage

### `todo` - Adds a generic task to the system
### `deadline` - Adds a task with a deadline to the system
### `event` - Adds a task with a venue to the system

Type in the task type followed by the task description.

For deadline and event types, please also type "/by" and "/at" respectively, followed by 
deadline/event venue accordingly.

This will add a task of the appropriate event type and description to the reminder system.

Example of usage 1: 

`todo wash dog`

Expected outcome 1:

`Got it. I've added this task:`
`[T][X] wash dog`
`Now you have 5 tasks in the list.`

Example of usage 2: 

`deadline wash cat /by Sunday`

Expected outcome 2:

`Got it. I've added this task:`
`[D][X] wash cat (by: Sunday)`
`Now you have 5 tasks in the list.`


Example of usage 3: 

`event wash rat /at backyard`

Expected outcome 3:

`Got it. I've added this task:`
`[E][X] wash rat (at: backyard)`
`Now you have 5 tasks in the list.`


### Feature 3

Marks a task to the reminder system as completed.

## Usage

### `done` - Marks a task as completed.

Type in command and the index of the task that has been completed.

Example of usage: 

`done 5`

Expected outcome:

`Nice! I've marked this task as done:
 [D][done] wash cat (by: Sunday)`


### Feature 4

Removes a task from the reminder system.

## Usage

### `delete` - Removes a task from the reminder system

Type in command and the index of the task that you want removed from the system.

Example of usage: 

`delete 5`

Expected outcome:

`Noted. I've removed this task:
[D][done] wash cat (by: Sunday)
Now you have 5 tasks in the list.`


### Feature 5

Finds tasks from the reminder system that contain a particular substring.

## Usage

### `find` - Finds tasks from the reminder system that contain a particular substring.

Type in command and the substring that you want to find in the task description.

Example of usage: 

`find ash`

Expected outcome:

`Here are the tasks in your list:
1.[E][X] wash rat (at: backyard)
2.[T][X] wash cat`
