/*==== INSERT ====*/

INSERT INTO faculty (id, name, image_url) VALUES
('architecture', 'Architecture', 'faculty-architecture.webp'),
('automatic-control-robotics-electrical-engineering', 'Automatic Control, Robotics & Electrical Engineering', 'faculty-automatic-control-robotics-electrical-engineering.webp'),
('chemical-technology', 'Chemical Technology', 'faculty-chemical-technology.webp'),
('civil-transport-engineering', 'Civil and Transport Engineering', 'faculty-civil-transport-engineering.webp'),
('computing-telecommunications', 'Computing and Telecommunications', 'faculty-computing-telecommunications.webp'),
('engineering-management', 'Engineering Management', 'faculty-engineering-management.webp'),
('environmental-engineering-energy', 'Environmental Engineering and Energy', 'faculty-environmental-engineering-energy.webp'),
('materials-engineering-technical-physics', 'Materials Engineering and Technical Physics', 'faculty-materials-engineering-technical-physics.webp'),
('mechanical-engineering', 'Mechanical Engineering', 'faculty-mechanical-engineering.webp');

INSERT INTO course (id, title, description, ects, hours, semester, description_card, diploma, faculty_id) VALUES
('object-programming','Object Programming','The goal of the course is to teach students how to model and create reusable, easily-maintainable software, by using tools provided by object-oriented programming languages. Moreover, the students will learn how to create and use custom data types, how to model software systems based on clean code principles, and how to communicate their work to other programmers.',4,100,'Winter','Object-oriented-programming','Bsc','computing-telecommunications'),
('quality-management','Quality management and experimental Software Engineering','Provide students the knowledge regarding experimental Software Engineering, especially related to empirical research methods and their theoretical foundations.',5,125,'Winter','Quality-management-and-experimental-Software-Engineering','Master','computing-telecommunications'),
('software-architecture-and-verification','Software Architecture and Verification','Provide students with knowledge regarding software architecture, within the following scope of understanding what is software architecture, how it should be documented and evaluated.',6,145,'Winter','Software-Architecture-and-Verification','Master','computing-telecommunications'),
('software-development-studio-2','Software development studio 2','Provide to the students the foundations of project management and requirements engineering (and illustrate them with real-life cases) that are necessary to perform the management and analytical roles in software development projects.',6,150,'Winter','Software-development-studio-2','Master','computing-telecommunications');
