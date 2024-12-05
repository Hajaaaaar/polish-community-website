# delete
# from users;
#
# insert into users (id, name, surname, email, password_hash)
# values (1, 'hajar', 'nefaa', 'hajarnefaa@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m');
# insert into users (id, name, surname, email, password_hash)
# values (2, 'sara', 'Doe', 'sara@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m');
#

#
#
INSERT INTO users (id, name, surname, email, password_hash)
SELECT 1, 'hajar', 'nefaa', 'hajarnefaa@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 1);

INSERT INTO users (id, name, surname, email, password_hash)
SELECT 2, 'sara', 'Doe', 'sara@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 2);


INSERT INTO work_information(name, description, link, job_type, expiry_date)
VALUES
    ('Software Engineer', 'Develop and maintain software applications.', 'https://example.com/software-engineer', 'Full-Time', '2024-12-31'),
    ('Data Analyst', 'Analyse and interpret complex datasets.', 'https://example.com/data-analyst', 'Part-Time', '2024-12-15');

insert into rights(title, description) values
('Domain 7: Rights and Responsibilities','In seeking to become a Nation of Sanctuary, as well as through implementing the Anti Racist Wales Action Plan, the Welsh Government is seeking to eliminate inequalities and support integration. For people to fully integrate with Welsh communities, they need to understand their rights and responsibilities. Host community members equally have responsibilities to follow the law, engage with democratic processes and participate in local communities. Individuals also need to be able to exercise their rights to ensure they have the safety net which is sometimes required. This is why advice services and awareness-raising activities can play a critical role in supporting integration. Awareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.\nAwareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.');

insert into sub_rights(sub_title,description,title_id) values
('Indicator 1: percent registering to vote','Does data exist for UK-born individuals in Wales? Yes: Electoral statistics for the UK.
\n Does data exist for migrants in Wales? Yes: Overseas, anonymous, opted-out, EU citizens and Parliamentary electors by local authority.',1),
('test','test',1);

delete from housing_questionnaire;
delete from housing_replies;

insert into housing_questionnaire(name, email, message)
VALUES ('Hajar', 'hajarnefaa@gmail.com', 'Hello everyone I am looking for rent. Can you give me any suggestions where to look?'),
       ('Sara', 'sara@gmail.com', 'Dobry wieczór, I want to buy a house what are the documents needed?');

INSERT INTO housing_replies (name, message, question_id)
VALUES
    ('Sara Doe', 'Hello, you can check this website, you may fined some useful info:https://www.gov.wales/migrant-integration-framework-html#135676', 1),
    ('Louise', 'I also have the same question,does anyone have any idea?', 2),
    (NULL, 'Thank you!', 1);

