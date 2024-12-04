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
('Domain 7: Rights and Responsibilities','In seeking to become a Nation of Sanctuary, as well as through implementing the Anti Racist Wales Action Plan, the Welsh Government is seeking to eliminate inequalities and support integration. For people to fully integrate with Welsh communities, they need to understand their rights and responsibilities. Host community members equally have responsibilities to follow the law, engage with democratic processes and participate in local communities. Individuals also need to be able to exercise their rights to ensure they have the safety net which is sometimes required. This is why advice services and awareness-raising activities can play a critical role in supporting integration. Awareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.\n\nAwareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.');

insert into sub_rights(sub_title,description,title_id) values
('Key Indicators of Integration', 'Although there are many ways to measure the integration of migrants in terms of rights and responsibilities, we have selected a few key indicators which we will use for the purposes of this Framework.',1),
('Indicator 1: percent registering to vote','Does data exist for UK-born individuals in Wales? Yes: Electoral statistics for the UK.
Does data exist for migrants in Wales? Yes: Overseas, anonymous, opted-out, EU citizens and Parliamentary electors by local authority.',1),
('Indicator 2: percentage utilising advice services','Does data exist for UK-born individuals in Wales? Yes: National Survey for Wales.
Does data exist for migrants in Wales? No.

Questions asked:

In the last 12 months, have you had advice or support from any organisations in these areas of life?

Debt
Financial matters other than debt
Welfare benefits
Housing
Employment
Discrimination
Divorce or problems relating to relationship breakdown
Social care
Goods and services you have bought
None of these
Other',1),
('Indicator 3: percentage reporting knowledge of rights','Does data exist for UK-born individuals in Wales? No.
Does data exist for migrants in Wales? No.

Questions to ask:

Which of the following best describes your knowledge of ...?

Human Rights Act
Equality Act
Social Services and Well-being Act

Response options for each:

I know nothing at all
I know a little
I know a fair amount
I know a great deal

If you or your organisation are working with migrants in Wales and could ask some of the questions above, we would like to discuss this with you. Please contact us via migrationpolicy@gov.wales for us to arrange a conversation.',1),
('Approaches','We know that certain approaches can improve the integration of migrants in terms of education. We encourage relevant organisations to embed the approaches below to support better outcomes.

Provide information about living in Wales (or local areas) which is tailored to your migrant audience and communicate it via community support organisations and community communication channels (e.g. Telegram, Whatsapp, Facebook etc).
Ensure you monitor the uptake of advice services and receipt of information by migrant communities to ensure services are accessible. Take active steps to improve uptake where needed.
Actively consider how to involve migrant communities in registration drives and political participation initiatives.

Swansea produced a Step-by-Step Guide on how to register to vote in multiple languages which was housed on the local authority\'s website. The guide was provided in 10 languages and helped removed a crucial barrier to accessing information. The approach proved successful, and the number of registered qualifying foreign nationals almost doubled from January to April 2022.

Read more about this successful approach in our accompanying case studies document.',1);

insert into rights_FAQs(que,answer,title_id) values
('Does data exist for UK-born individuals in Wales regarding voter registration?','Yes, data for UK-born individuals regarding voter registration in Wales is available through official electoral statistics. These statistics help track voter participation rates and show how many eligible voters, including UK-born citizens, are registered to vote. This data helps us understand civic engagement within Wales.',1),
('Does data exist for migrants in Wales regarding voter registration?','Yes, there is data for migrants, though it’s more segmented. This data includes overseas voters, anonymous voters, opted-out voters, EU citizens, and parliamentary electors by local authority. For the Polish community, this data is particularly important, as many EU migrants, including Polish nationals, are eligible to vote in local elections and referenda. However, registration data for non-EU migrants is less readily available, making it harder to gauge overall participation.',1),
('Does data exist for UK-born individuals in Wales regarding the use of advice services?','Yes, the National Survey for Wales collects data about UK-born individuals and their use of advice services. The survey covers areas like housing, welfare benefits, debt, employment, and more. This helps identify which services are most used and whether there are any gaps in service provision.',1),
('Does data exist for migrants in Wales regarding the use of advice services?','No, unfortunately, there is no comprehensive data available specifically for Polish or other migrant communities in Wales regarding the use of advice services. This is a significant gap, as it makes it difficult to assess whether migrants are accessing the help they need. Migrants, especially those who are newly arrived or with limited English skills, may face barriers in accessing services such as housing advice, welfare support, or legal assistance.',1),
('What questions are asked in the survey to assess the use of advice services?',' The survey asks whether individuals, including migrants, have accessed advice or support in the past 12 months for a range of issues that Polish immigrants may face, including:
\nDebt: Have you sought help for managing or clearing debt, such as credit cards, loans, or unpaid bills?
\nFinancial matters other than debt: Have you received assistance with budgeting, saving, or managing your finances?
\nWelfare benefits: Have you accessed support for benefits such as Universal Credit or housing benefits?
\nHousing: Have you sought help with housing issues, such as finding accommodation or understanding your tenancy rights?
\nEmployment: Have you needed support regarding your rights as an employee, finding a job, or resolving workplace issues?
\nDiscrimination: Have you experienced or sought help regarding discrimination in employment, housing, or public services?
\nDivorce or problems relating to relationship breakdown: Have you sought advice on family law matters?
\nSocial care: Have you needed support related to health, social care, or the care of a family member?
\nGoods and services: Have you experienced issues with consumer rights, faulty products, or services?
\nOther: Have you sought advice on any other issues not listed above?
\nNone of these: Have you not used any advice services in the past year?
\nThese questions help assess whether migrants, including the Polish community, are accessing services that can assist with integration and provide support for common challenges.',1),
('Does data exist for UK-born individuals in Wales regarding knowledge of rights?','No, there is no specific data available for UK-born individuals in Wales regarding their knowledge of rights. While there is general awareness of rights in the UK, the lack of segmented data makes it hard to measure the depth of understanding among UK-born citizens about laws like the Equality Act, Human Rights Act, and Social Services and Well-being Act.',1),
('Does data exist for migrants in Wales regarding knowledge of rights?','No, there is no data available for migrants, including Polish nationals, specifically regarding knowledge of their rights. For Polish immigrants, this is particularly important, as many may not be fully aware of the protections available to them under UK law. There may also be confusion about the changes to immigration laws, benefits, and access to services since the UK’s exit from the EU.',1),
('What questions could be asked to assess knowledge of rights?','To better understand how Polish migrants feel about their legal rights, we could ask:

\nHuman Rights Act: How much do you know about your rights, such as the right to life, freedom from discrimination, or the right to a fair trial?
\nEquality Act: How familiar are you with the law protecting against discrimination in work, housing, and public services based on race, gender, disability, or other characteristics?
\nSocial Services and Well-being Act: How well do you understand your rights regarding access to social services, healthcare, and other support systems in Wales?
\nRespondents can rate their knowledge as:

\nI know nothing at all
\nI know a little
\nI know a fair amount
\nI know a great deal
\nThese questions would help identify whether Polish migrants, in particular, understand their rights in relation to key legislation and if they feel equipped to navigate challenges in Wales.',1),
('What approaches can improve the integration of migrants, especially the Polish community, in education?','Several key approaches can significantly enhance the integration of Polish migrants in Wales:
\nProvide tailored information: Clear and accessible information should be provided in Polish, focusing on living and working in Wales. This could cover essential topics like understanding the UK benefits system, knowing your rights in the workplace, housing, and healthcare. Community-based organisations can help distribute this information, especially through platforms like WhatsApp, Facebook, or local Polish-language newspapers.
Monitor advice service uptake: To ensure Polish migrants are using services effectively, it’s essential to regularly monitor and assess the accessibility of advice services. This includes providing translation services, offering advice in Polish, and ensuring migrant-specific needs are addressed, such as support for people with limited English skills.
\nPromote political participation: Encouraging Polish migrants to register to vote and participate in elections is crucial. Initiatives should actively involve Polish community leaders, local organisations, and bilingual materials to make voting accessible and understandable. This could include information about local and national elections, eligibility, and the benefits of participating in the democratic process.',1);