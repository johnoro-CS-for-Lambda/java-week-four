# java-safezoos

Using java-zoos as a starting point (https://github.com/LambdaSchool/java-zoos.git), add security to the application. 

Use (https://github.com/LambdaSchool/java-ourcourses.git) as a model for how to add security.

Security is:
- [x] ROLE `admin` should be allowed to access /users and /admin
- [x] ROLE `user` should be allowed to access /animals and /zoos
- [x] ROLE `zoo` should be allowed to access /zoos
- [x] ROLE `animal` should be allowed to access /animals
- [x] ROLE `manager` should be allowed to only access /actuator (stretch goal).
- [x] Everyone should be allowed to access the swagger ui!

# java-zoos

This is a basic database scheme with zoos, phone number and animals at the zoo.

Create a REST API server to store and read data from a MySQL data. The table layouts should be

- [x] Zoo
  * zoo_id - long primary key
  * name - String

- [x] Telephone
  * phone_id - long primary key
  * type - String
  * number - String
  * zoo_id - foreign key
  
There is a one to many relationship between zoos and telephones. One zoo can have multiple phone numbers but each phone number can only belong to one zoo.

- [x] Animal
  * animal_id - long primary key
  * type - String

There is a many to many relationship between zoos and animals. A zoo may have many animal types and an animal type may be at many zoos.

- [x] End points should return the data worked with or nothing if no data was found.
- [x] Swagger should be used to document your API, The default documentation is sufficient assuming appropriate names are used in your coding.

Expose the following end points

- [x] GET /zoos - returns all zoos with their phone numbers and animals
- [x] GET /zoos/{name} - return the zoo with this name with its phone numbers and animals

- [x] GET /animals - returns all animals with their zoos
- [x] GET /animals/{type} - return the animal with a list of zoos where they can be found

For the PUT and POST you can assume you are sent all the data with the appropriate ids included

- [x] PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
- [x] PUT /admin/telephones/{id} - update the telephone referenced by the id number with the provided information
- [x] PUT /admin/animals/{id} - update the animal referenced by the id number with the provided information

- [x] POST /admin/zoos - add the zoo
- [x] POST /admin/telephones - add the phone number
- [x] POST /admin/animals - add the animal
- [ ] POST /admin/zoos/animals - add the zooId, animalId combination to the zoo animals relations table

- [x] DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
- [x] DELETE /admin/telephones/{id} - delete the phone number associated with this id
- [x] DELETE /admin/animals/{id} - delete the animal associated with this id including all the appropriate zoo animal combinations
- [ ] DELETE /admin/zoos/{zooId}/animals/{animalId} - delete the zoo animal combination based off of ids. 
  * Hint: @PathVariable("zooId", long zooId), @PathVariable("animalId") long animalId

Expose at least the following actuator endpoints to help with system management
- [ ] /health
- [ ] /info
- [ ] /metrics

Stretch Goals
- [ ] Update each of the three actuator endpoints to report your own messages
- [ ] Expose the end point /animals/count that returns a JSON object list listing the animals and a count of how many zoos where they can be found.
- [ ] Log to the console each time a record in the database is changed.
