/*==== INSERT ====*/

INSERT INTO faculty (name, description, image) VALUES
('Architecture', 'X', 'faculty-architecture.webp'),
('Automatic Control, Robotics & Electrical Engineering', 'X', 'faculty-automatic-control-robotics-electrical-engineering.webp'),
('Chemical Technology', 'X', 'faculty-chemical-technology.webp'),
('Civil and Transport Engineering', 'X', 'faculty-civil-transport-engineering.webp'),
('Computing and Telecommunications', 'X', 'faculty-computing-telecommunications.webp'),
('Engineering Management', 'X', 'faculty-engineering-management.webp'),
('Environmental Engineering and Energy', 'X', 'faculty-environmental-engineering-energy.webp'),
('Materials Engineering and Technical Physics', 'X', 'faculty-materials-engineering-technical-physics.webp'),
('Mechanical Engineering', 'X', 'faculty-mechanical-engineering.webp');

INSERT INTO course (title, description, ects, hours, description_card, diploma) VALUES
('Object Programming','The goal of the course is to teach students how to model and create reusable, easily-maintainable software, by using tools provided by object-oriented programming languages. Moreover, the students will learn how to create and use custom data types, how to model software systems based on clean code principles, and how to communicate their work to other programmers.',4,100,'Object-oriented-programming','B.Sc.'),
('Quality management and experimental Software Engineering','Provide students the knowledge regarding experimental Software Engineering, especially related to empirical research methods and their theoretical foundations.',5,125,'Quality-management-and-experimental-Software-Engineering','Master'),
('Software Architecture and Verification','Provide students with knowledge regarding software architecture, within the following scope of understanding what is software architecture, how it should be documented and evaluated.',6,145,'Software-Architecture-and-Verification','Master'),
('Software development studio 2','Provide to the students the foundations of project management and requirements engineering (and illustrate them with real-life cases) that are necessary to perform the management and analytical roles in software development projects.',6,150,'Software-development-studio-2','Master');
