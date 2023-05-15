# Milestone 2

## Part I

we created the milestone2 branch in github to work on the milestone 2

## Part II feature development
## The description for our features:

Our application includes 3 features: Announcemnent checking, Deadlines checking, Calendar checking


## Announcement checking

Announcement will display the announcemenet such as assignment deadlines, or announcement from professor to students.

REST API functionality:

@GetMapping("/{student_id}")

This will retrieve the announcement for a particular student by their student id.
Curl command:
```bash
- curl -X GET http://localhost:8080/announcements/20182028 
```
Expected output:
    [
    {
        "course_id": "CSE333",
        "course_name": "HCI",
        "ann_header" : "Assignment 2",
	    "ann_description" : "Milestone 1 (docker)",
	    timestamp: 1684125941

    },
    {
        "course_id": "CSE345",
        "course_name": "Intro to Algorithm",
        "ann_header" : "Assignment 1",
	    "ann_description" : "Red dot tree implementation",
	    timestamp: 1684165484
    },
    ...
    ]
```bash
 
- curl -X GET http://localhost:8080/announcements/20182014/CSE333

```
Expected output:
    [
    {
        "course_id": "CSE333",
        "course_name": "HCI",
        "ann_header" : "Assignment 2",
	    "ann_description" : "Milestone 1 (docker)",
	    timestamp: 1684125941

    },

    {
        "course_id": "CSE333",
        "course_name": "HCI",
        "ann_header" : "Assignment 1 grade",
	    "ann_description" : "Your grades were released",
	    timestamp: 1684168879
    },
    ...
    ]
## Deadline checking

This will show the upcoming deadlines of the assignment deadlines

Curl commands:
```bash
curl -X GET http://localhost:8080/dashboard/deadlines/20182011
```

Expected Output:

[
    {
    "assignment_id": "4",
    deadline : 1684172135,
    "course_id" :"CSE402",
    "course_name": "Natural Language Processing"

    },
    {
    "assignment_id": "5",
    deadline : 1684198778,
    "course_id" :"CSE468",
    "course_name": "Information Visualization"
    },
    ...
]
```bash
curl -X GET http://localhost:8080/dashboard/deadlines/20161562/5
```
Expected Output:
[
    {
    "assignment_id": "5",
    deadline : 1684198778,
    "course_id" :"CSE468",
    "course_name": "Information Visualization"
    },
    ...
]
```bash
- [x]  curl -X GET http://localhost:8080/dashboard/deadlines/20171120/SLA46101/7
```
Expected Output:

[
    {
    "assignment_id": "7",
    deadline : 1684187795,
    "course_id" :"SLA46101",
    "course_name": "Philosophy of Science"
    }
]

## Calendar checking
 adding / editting the tasks for each students.

Curl commands:
```bash
 - [x]  curl -X GET http://localhost:8080/calendar/tasks/20182014
```

Expected Output:
4,running,exercise with friends for events,1684190941,normal
5,dinning,dinning with family in west town,1684805941,low
6,reading,finish the road to heaven books,1684140941,normal
7,watching movie,watch the new fiction series on netflix,1684125441,high

[
    {
        "task_id": "4"
        "task_name": "running",
        "description":"exercise with friends for events",
        deadline: 1684190941,
        "priority": "normal"

    },
    {
        "task_id": "6"
        "task_name": "reading",
        "description":"finish the road to heaven books",
        deadline: 1684140941,
        "priority": "normal"
    },
    ...
]

```bash
- [x]  curl -X GET http://localhost:8080/calendar/tasks/20991203/7
```

Expected Output:

[
    {
        "task_id": "7"
        "task_name": "watching movie",
        "description":"watch the new fiction series on netflix",
        deadline: 1684125441,
        "priority": "high"

    }
]

