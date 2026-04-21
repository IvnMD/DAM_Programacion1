PRAGMA foreign_keys = ON;

INSERT INTO category (id, name) VALUES
(1, 'Programming'),
(2, 'Database'),
(3, 'Cloud'),
(4, 'Management'),
(5, 'Analytics');

INSERT INTO skill (id, name, category_id) VALUES
(1, 'Java', 1),
(2, 'Python', 1),
(3, 'JavaScript', 1),
(4, 'SQL', 2),
(5, 'SQLite', 2),
(6, 'PostgreSQL', 2),
(7, 'AWS', 3),
(8, 'Docker', 3),
(9, 'Leadership', 4),
(10, 'Scrum', 4),
(11, 'Power BI', 5),
(12, 'Excel', 5);

INSERT INTO rol (id, name, salary) VALUES
(1, 'Junior Developer', 24000),
(2, 'Developer', 32000),
(3, 'Senior Developer', 42000),
(4, 'Tech Lead', 52000),
(5, 'Project Manager', 48000),
(6, 'Data Analyst', 35000),
(7, 'DevOps Engineer', 45000);

INSERT INTO employee (id, name, surname, start_date, reports_to, rol_id) VALUES
(1, 'Laura', 'Martin', '2018-02-12', NULL, 5),
(2, 'Carlos', 'Sanchez', '2019-04-01', 1, 4),
(3, 'Ana', 'Lopez', '2020-01-10', 2, 3),
(4, 'Mario', 'Ruiz', '2021-06-15', 2, 2),
(5, 'Lucia', 'Fernandez', '2022-03-21', 3, 1),
(6, 'Diego', 'Navarro', '2020-09-01', 1, 7),
(7, 'Elena', 'Gil', '2021-11-08', 1, 6),
(8, 'Pablo', 'Moreno', '2023-01-17', 6, 2),
(9, 'Sara', 'Iglesias', '2022-07-05', 7, 6),
(10, 'Jorge', 'Castro', '2023-09-10', 2, 1),
(11, 'Nuria', 'Vega', '2019-12-20', 1, 3),
(12, 'Alberto', 'Prieto', '2024-02-14', 3, 1);

INSERT INTO resume (id, summary, experience_years, employee_id) VALUES
(1, 'Project manager with experience in software delivery and team coordination.', 10, 1),
(2, 'Technical lead focused on backend architecture and mentoring.', 8, 2),
(3, 'Senior backend developer specialized in Java and SQL.', 6, 3),
(4, 'Full stack developer with strong frontend and API skills.', 4, 4),
(5, 'Junior developer with internship experience and rapid growth.', 1, 5),
(6, 'DevOps engineer with cloud automation experience.', 7, 6),
(7, 'Analyst with reporting and dashboarding background.', 5, 7),
(8, 'Business analyst with strong BI and Excel skills.', 3, 9),
(9, 'Senior developer with experience in integrations and refactoring.', 7, 11);

INSERT INTO employee_skill (employee_id, skill_id, level_id) VALUES
(1, 9, 'advanced'),
(1, 10, 'advanced'),
(1, 12, 'advanced'),
(2, 1, 'advanced'),
(2, 4, 'advanced'),
(2, 9, 'advanced'),
(2, 10, 'advanced'),
(3, 1, 'advanced'),
(3, 2, 'intermediate'),
(3, 4, 'advanced'),
(3, 6, 'intermediate'),
(3, 8, 'intermediate'),
(4, 2, 'intermediate'),
(4, 3, 'intermediate'),
(4, 4, 'intermediate'),
(4, 5, 'intermediate'),
(5, 2, 'basic'),
(5, 4, 'basic'),
(5, 12, 'intermediate'),
(6, 4, 'advanced'),
(6, 7, 'advanced'),
(6, 8, 'advanced'),
(6, 10, 'intermediate'),
(7, 4, 'intermediate'),
(7, 11, 'advanced'),
(7, 12, 'advanced'),
(8, 2, 'intermediate'),
(8, 4, 'intermediate'),
(8, 8, 'basic'),
(9, 11, 'advanced'),
(9, 12, 'advanced'),
(9, 10, 'basic'),
(10, 3, 'basic'),
(10, 4, 'basic'),
(11, 1, 'advanced'),
(11, 4, 'advanced'),
(11, 6, 'advanced'),
(11, 9, 'intermediate'),
(12, 2, 'basic'),
(12, 4, 'basic');
