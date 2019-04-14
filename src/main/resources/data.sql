DELETE FROM zoos_join_animals;
DELETE FROM animals;
DELETE FROM telephones;
DELETE FROM zoos;
DELETE FROM users;

INSERT INTO zoos (zoo_id, name)
  VALUES(1, 'Regal Zoo'),
        (2, 'Dog Zoo'),
        (3, 'Cat Zoo');

INSERT INTO telephones (telephone_id, type, number, zoo_id)
  VALUES(1, 'office', 5555555555, 1),
        (2, 'cell', 4444444444, 1),
        (3, 'office', 1221122112, 2),
        (4, 'office', 0123456789, 3);

INSERT INTO animals (animal_id, type)
  VALUES(1, 'elephant'),
        (2, 'dog'),
        (3, 'cat'),
        (4, 'moose'),
        (5, 'zebra');

INSERT INTO zoos_join_animals (zoo_id, animal_id)
  VALUES(1, 1),
        (1, 4),
        (1, 5),
        (2, 2),
        (3, 3);

INSERT INTO users (user_id, name, password, role)
  VALUES(1, 'admin', 'pass', 'admin'),
        (2, 'user', 'pass', 'user'),
        (3, 'manager', 'pass', 'manager');
