PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS resume;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS rol;

CREATE TABLE category (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE skill (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    category_id INTEGER NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE rol (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    salary INTEGER NOT NULL CHECK (salary > 0)
);

CREATE TABLE employee (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    start_date TEXT NOT NULL,
    reports_to INTEGER,
    rol_id INTEGER NOT NULL,
    FOREIGN KEY (reports_to) REFERENCES employee(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);

CREATE TABLE resume (
    id INTEGER PRIMARY KEY,
    summary TEXT,
    experience_years INTEGER NOT NULL CHECK (experience_years >= 0),
    employee_id INTEGER NOT NULL UNIQUE,
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_skill (
    employee_id INTEGER NOT NULL,
    skill_id INTEGER NOT NULL,
    level_id TEXT,
    PRIMARY KEY (employee_id, skill_id),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);
