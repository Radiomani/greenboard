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
- curl -X GET http://localhost:8080/announcements/{student_id}
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
	    "ann_description" : ";Red dot tree implementation",
	    timestamp: 1684165484
    },
    ...
    ]
 
- [x]  curl -X GET http://localhost:8080/announcements/{student_id}/{course_id}

## Deadline checking

This will show the upcoming deadlines of the assignment deadlines

## Calendar checking
 adding / editting the tasks for each students.
## Note for part 2

When testing POST and PUT method, please use the following commands

```bash
curl -X POST http://localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```
```bash
curl -X PUT http://localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'
```

If you use the original `curl` command given in the handout, you will always recieve `400 - Bad request` due to a typo in the assignment handout.

---

## Open Endpoints

* [Query rating](#query-rating) : `GET /ratings/:rating`

* [Query user](#query-user) : `GET /users/:id`

* [Insert user](#insert-user) : `POST /users`

* [Update user](#update-user) : `PUT /users/:id`

## API Documentation

### Query rating
Returns the list of those movies with average rating greater or equal to the given rating score.

* URL:

    `/ratings/:rating`

* Method:

    `GET`

* URL Params:

    **Required**:
    - `rating=[double]`

* Data Params:

    None

* Success Response:

    - Code: 200

        Content: 
`[
{
  "movie_name" : "Toy Story (1995)",
  "genre": "Animation|Children's|Comedy"
},
{
    "movie_name": "xxx",
    "genre": "xxx",
},
...
]
`

* Error Response:

    - Code: 406 Not Acceptable

        Content: `"Parameter is not in the range of [1, 5]!"` or `"Parameter is not a number!"`

* Sample Call:

Returns a list of movies whose average ratings are greater or equal to 4.
```bash
curl -X GET http://localhost:8080/ratings/4
```

### Query user
Returns a user object with a given user ID.

* URL:

    `/users/:id`

* Method:

    `GET`

* URL Params:

    **Required**:
    - `id=[integer]`

* Data Params:

    None

* Success Response:

    - Code: 200

        Content: 
`
{
  "id" : "64299cd2b2afe565a469eba2",
  "user_id" : 3,
  "gender" : "M",
  "age" : 25,
  "occupation" : 15,
  "zip_code" : "55117",
  "userId" : 3,
  "zipCode" : "55117"
}
`

* Error Response:

    - Code: 406 Not Acceptable

        Content: `"Parameter is not a number!"`

    Or

    - Code: 404 Not Found

        Content: `"User id does not exist!"`


* Sample Call:

Returns a user object with a given user ID 3. 
```bash
curl -X GET http://localhost:8080/users/3
```

### Insert user
Inserts a new user data to the database and returns a newly inserted user object given in data param.

* URL:

    `/users`

* Method:

    `POST`

* URL Params:

    None

* Data Params:

```json
{
    "gender": "M", 
    "age": 21, 
    "occupation": 7, 
    "zip_code": "100000"
}
```

* Success Response:

    - Code: 200

        Content: 
`
{
  "id" : "642c1427ce91314b8fb3c3b0",
  "user_id" : 6061,
  "gender" : "M",
  "age" : 21,
  "occupation" : 7,
  "zip_code" : "100000"
}
`

* Error Response:

    - Code: 500 Internal Server Error

        Content: `"Something wrong when saving the user"`


* Sample Call:

Returns a newly inserted user with given information `{"gender": "M", "age": 21, "occupation": 7, "zip_code": "100000"}`.
```bash
curl -X POST http://localhost:8080/users -H 'Content-type:application/json' -d '{"gender": "M", "age": 21, "occupation": 7, "zip_code": "100000"}'
```

### Update user
Updates an existing user data in database and returns the updated user object given in data param.

* URL:

    `/users/:id`

* Method:

    `PUT`

* URL Params:

    **Required**:
    - `id=[integer]`

* Data Params:

```json
{
    "gender": "F", 
    "age": 18, 
    "occupation": 5, 
    "zip_code": "100"
}
```

* Success Response:

    - Code: 200

        Content: 
`
{
  "id" : "642c1427ce91314b8fb3c3b0",
  "user_id" : 6061,
  "gender" : "F",
  "age" : 18,
  "occupation" : 5,
  "zip_code" : "100"
}
`

* Error Response:

    - Code: 406 Not Acceptable

        Content: `"Parameter is not a number!"`

    Or

    - Code: 404 Not Found

        Content: `"User id does not exist!"`

    Or

    - Code: 500 Internal Server Error

        Content: `"Something wrong when saving the user"`


* Sample Call:

Change the user with id 6041 to `{"gender": "F", "age": 18, "occupation": 5, "zip_code": "100"}`
```bash
curl -X PUT http://localhost:8080/users/6041 -H 'Content-type:application/json' -d '{"gender": "F", "age": 18, "occupation": 5, "zip_code": "100"}'
```
