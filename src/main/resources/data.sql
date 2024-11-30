# delete
# from users;
#
# insert into users (id, name, surname, email, password_hash)
# values (1, 'hajar', 'nefaa', 'hajarnefaa@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m');
# insert into users (id, name, surname, email, password_hash)
# values (2, 'sara', 'Doe', 'sara@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m');
#

INSERT INTO users (id, name, surname, email, password_hash)
SELECT 1, 'hajar', 'nefaa', 'hajarnefaa@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 1);

INSERT INTO users (id, name, surname, email, password_hash)
SELECT 2, 'sara', 'Doe', 'sara@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 2);






