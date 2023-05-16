git clone https://github.com/Radiomani/greenboard.git
cd greenboard
git checkout milestone2

#Create User Administrator MongoDB
mongod --fork --logpath /var/log/mongodb.log
mongosh admin --eval "db.createUser({ user: 'admin', pwd: 'password', roles: ['userAdminAnyDatabase'] })"

#Import data/*.csv to MongoDB
mongoimport --db=cse364 --collection=announcements --authenticationDatabase admin --username admin --password password --type=csv --file=data/announcements.csv --fields=couse_id.string\(\),course_name.string\(\),ann_header.string\(\),ann_description.string\(\),timestamp.int32\(\) --columnsHaveTypes 
mongoimport --db=cse364 --collection=assignments --authenticationDatabase admin --username admin --password password --type=csv --file=data/assignments.csv --fields=assignment_id.string\(\),deadline.int32\(\),course_id.string\(\),course_name.string\(\) --columnsHaveTypes 
mongoimport --db=cse364 --collection=courses --authenticationDatabase admin --username admin --password password --type=csv --file=data/courses.csv --fields=course_id.string\(\),course_name.string\(\),professor_name.string\(\) --columnsHaveTypes 
mongoimport --db=cse364 --collection=students --authenticationDatabase admin --username admin --password password --type=csv --headerline --useArrayIndexFields --file=data/students.csv
#mongoimport --db=cse364 --collection=students --authenticationDatabase admin --username admin --password password --type=csv --file=data/students.csv --fields=student_id.string\(\),name.string\(\),email.string\(\) --columnsHaveTypes 
mongoimport --db=cse364 --collection=tasks --authenticationDatabase admin --username admin --password password --type=csv --file=data/tasks.csv --fields=task_id.string\(\),student_id.string\(\),task_name.string\(\),description.string\(\),deadline.string\(\),priority.string\(\) --columnsHaveTypes 

#mvn jacoco:report
mvn package
java -jar ./target/cse364-project-1.0-SNAPSHOT.jar